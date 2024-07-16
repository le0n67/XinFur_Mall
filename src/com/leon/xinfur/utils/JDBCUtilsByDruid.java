package com.leon.xinfur.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author leon
 * @version 1.0
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;

    private static ThreadLocal<Connection> tlConnection = new ThreadLocal<>();

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            //properties.load(new FileInputStream("src\\druid.properties"));
            properties.load(JDBCUtilsByDruid.class.getClassLoader()
                    .getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法

    /**
     * 从ThreadLocal中获取数据库连接池中的连接,保证从一个线程中获取的是同一个连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = tlConnection.get();
        if (connection == null) {
            try {
                connection = ds.getConnection();
                tlConnection.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    //public static Connection getConnection() throws SQLException {
    //    return ds.getConnection();
    //}

    //关闭连接, 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //提交事务

    public static void commit() {
        // 通过ThreadLocal获取当前线程的数据库连接
        Connection connection = tlConnection.get();
        if (connection != null) {
            try {
                // 对当前连接的事务进行提交
                connection.commit();
            } catch (SQLException e) {
                // 如果在提交事务时发生异常，打印异常堆栈跟踪
                e.printStackTrace();
            } finally {
                try {
                    // 无论提交事务是否成功，都尝试关闭数据库连接
                    connection.close();
                } catch (SQLException e) {
                    // 如果在关闭连接时发生异常，打印异常堆栈跟踪
                    e.printStackTrace();
                }
            }
        }
        // 从ThreadLocal中移除当前线程的数据库连接，避免资源泄露
        tlConnection.remove();

    }

    //回滚
    public static void rollback() {
        // 通过ThreadLocal获取当前线程的数据库连接
        Connection connection = tlConnection.get();
        if (connection != null) {
            try {
                // 对当前连接的事务进行回滚
                connection.rollback();
            } catch (SQLException e) {
                // 如果在回滚事务时发生异常，打印异常堆栈跟踪
                e.printStackTrace();
            } finally {
                try {
                    // 无论回滚事务是否成功，都尝试关闭数据库连接
                    connection.close();
                } catch (SQLException e) {
                    // 如果在关闭连接时发生异常，打印异常堆栈跟踪
                    e.printStackTrace();
                }
            }
        }
        // 从ThreadLocal中移除当前线程的数据库连接，避免资源泄露
        tlConnection.remove();
    }
}

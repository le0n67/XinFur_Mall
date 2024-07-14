package com.leon.xinfur.dao.impl;

import com.leon.xinfur.dao.BasicDAO;
import com.leon.xinfur.dao.OrderDAO;
import com.leon.xinfur.entity.Order;

import java.util.List;

/**
 * Date：2024/7/13  9:40
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `order`(`id`,`create_time`,`price`,`status`,`member_id`) " +
                "VALUES(?,?,?,?,?)";
        return update(sql, order.getId(),order.getCreateTime(),
                order.getPrice(),order.getStatus(),order.getMemberId());
    }

    @Override
    public List<Order> getOrders() {
        String sql= "SELECT * FROM `order`";
        return queryMulti(sql, Order.class);
    }

    @Override
    public Order getOrderById(String id) {
        return querySingle("SELECT * FROM `order` WHERE id=?", Order.class, id);
    }


}

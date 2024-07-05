package com.leon.xinfur.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * Date：2024/7/3  11:49
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

abstract public class BasicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");

        System.out.println("BasicServlet doPost");
        String action = req.getParameter("action");
        System.out.println("action:" + action);
        //使用反射获取当前对象方法

        //尝试获取当前类中名为action的方法
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法，传入req和resp参数
            method.invoke(this, req, resp);
        } catch (Exception e) {
            //打印异常堆栈信息
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("BasicServlet doGet");
        doPost(req, resp);
    }
}
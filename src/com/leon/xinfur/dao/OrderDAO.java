package com.leon.xinfur.dao;


import com.leon.xinfur.entity.Order;

import java.util.List;

/**
 * Date：2024/7/13  9:39
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface OrderDAO {
    int saveOrder(Order order);
    List<Order> getOrders();
    Order getOrderById(String id);
}

package com.leon.xinfur.service;

import com.leon.xinfur.entity.Cart;
import com.leon.xinfur.entity.Order;
import com.leon.xinfur.entity.OrderItem;

import java.util.List;

/**
 * Date：2024/7/13  9:41
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface OrderService {
    String createOrder(Cart cart, Integer memberId);
    List<Order> showOrders();
    List<OrderItem> showOrderItems();
    Order queryOrderById(String id);
    List<OrderItem> queryOrderItemsById(String id);
}

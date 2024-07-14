package com.leon.xinfur.dao;

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
public interface OrderItemDAO {
    int saveOrderItem(OrderItem orderItem);
    List<OrderItem> getOrderItems();
    List<OrderItem> getOrderItemsByOrderId(String orderId);
}

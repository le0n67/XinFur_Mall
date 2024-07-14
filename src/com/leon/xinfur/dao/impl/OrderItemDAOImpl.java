package com.leon.xinfur.dao.impl;

import com.leon.xinfur.dao.BasicDAO;
import com.leon.xinfur.dao.OrderItemDAO;
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

public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item`(`id`,`name`,`price`,`count`,`total_price`,`order_id`) " +
                "VALUES(?, ?,?,?,?,?) ";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getPrice(),
                orderItem.getCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> getOrderItems() {
        String sql = "SELECT * FROM `order_item`";
        return queryMulti(sql, OrderItem.class);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        String sql = "SELECT * FROM `order_item` WHERE `order_id` = ?";
        return queryMulti(sql, OrderItem.class, orderId);
    }
}

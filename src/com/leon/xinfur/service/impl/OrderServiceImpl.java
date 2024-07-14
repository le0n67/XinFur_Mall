package com.leon.xinfur.service.impl;

import com.leon.xinfur.dao.FurnDAO;
import com.leon.xinfur.dao.OrderDAO;
import com.leon.xinfur.dao.OrderItemDAO;
import com.leon.xinfur.dao.impl.FurnDAOImpl;
import com.leon.xinfur.dao.impl.OrderDAOImpl;
import com.leon.xinfur.dao.impl.OrderItemDAOImpl;
import com.leon.xinfur.entity.*;
import com.leon.xinfur.service.OrderService;

import java.util.*;

/**
 * Date：2024/7/13  9:42
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private FurnDAO furnDAO = new FurnDAOImpl();
    @Override
    public String createOrder(Cart cart, Integer memberId) {
        String orderId = System.currentTimeMillis() + "" + memberId;
        Order order = new Order(orderId, new Date(), cart.getCartTotalPrice(), 0, memberId);
        orderDAO.saveOrder(order);

        //通过cart对象 ,遍历出CartItem, 构建OrderItem对象， 并保存到对应的表order_item
        //HashMap<Integer, CartItem> items = cart.getItems();
        //Set<Integer> keys = items.keySet();
        //for (Integer id : keys) {
        //    CartItem item = items.get(id);
        //    //通过cartItem对象构建了OrderItem
        //    OrderItem orderItem = new OrderItem(null,item.getName(),item.getPrice(),
        //            item.getCount(),item.getTotalPrice(),orderId);
        //    //保存
        //    orderItemDAO.saveOrderItem(orderItem);
        //    //更新一把furn表的sales销量, stock存量
        //    //(1) 获取到furn对象
        //    Furn furn = furnDAO.queryFurnById(id);
        //    //(2) 更新一下这个furn的sales销量, stock存量
        //    furn.setSales(furn.getSales() + item.getCount());
        //    furn.setStock(furn.getStock() - item.getCount());
        //    //(3) 更新到数据表
        //    furnDAO.updateFurn(furn);
        //}

        //=======通过entryset的方式遍历items 取出CartItem===

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            //通过cartItem对象构建了OrderItem
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(),
                    item.getCount(), item.getTotalPrice(), orderId);

            //保存
            orderItemDAO.saveOrderItem(orderItem);

            //更新一把furn表的sales销量, stock存量
            //(1) 获取到furn对象
            Furn furn = furnDAO.queryFurnById(item.getId());
            //(2) 更新一下这个furn的sales销量, stock存量
            furn.setSales(furn.getSales() + item.getCount());
            furn.setStock(furn.getStock() - item.getCount());
            //(3) 更新到数据表
            furnDAO.updateFurn(furn);

        }

        //清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showOrders() {
        return orderDAO.getOrders();
    }

    @Override
    public List<OrderItem> showOrderItems() {
        return orderItemDAO.getOrderItems();
    }

    @Override
    public Order queryOrderById(String id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<OrderItem> queryOrderItemsById(String id) {
        return orderItemDAO.getOrderItemsByOrderId(id);
    }
}

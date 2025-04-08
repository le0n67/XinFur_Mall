//package com.leon.xinfur.test;
//
//import com.leon.xinfur.dao.FurnDAO;
//import com.leon.xinfur.dao.MemberDAO;
//import com.leon.xinfur.dao.OrderDAO;
//import com.leon.xinfur.dao.OrderItemDAO;
//import com.leon.xinfur.dao.impl.FurnDAOImpl;
//import com.leon.xinfur.dao.impl.MemberDAOImpl;
//import com.leon.xinfur.dao.impl.OrderDAOImpl;
//import com.leon.xinfur.dao.impl.OrderItemDAOImpl;
//import com.leon.xinfur.entity.Furn;
//import com.leon.xinfur.entity.Member;
//import com.leon.xinfur.entity.Order;
//import com.leon.xinfur.entity.OrderItem;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * Date：2024/7/1  17:11
// * Description：TODO
// *
// * @author Leon
// * @version 1.0
// */
//
//public class SQLTest {
//    MemberDAO memberDAO=new MemberDAOImpl();
//    FurnDAO furnDAO=new FurnDAOImpl();
//    OrderDAO orderDAO=new OrderDAOImpl();
//    OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
//
//    @Test
//    void queryMemberByUsername(){
//        Member member = memberDAO.queryMemberByUsername("roo1");
//        System.out.println(member==null);
//    }
//
//    @Test
//    void saveMember(){
//        Member root = new Member(404, "root", "root", "root@root.com");
//        int i = memberDAO.saveMember(root);
//        System.out.println(i);
//    }
//
//    @Test
//    void queryFurns(){
//        List<Furn> furns = furnDAO.queryFurns();
//        for (int i = 0; i < furns.size(); i++) {
//            System.out.println(furns.get(i));
//        }
//    }
//
//    @Test
//    void addFurn(){
//        Furn furn = new Furn(null, "无敌垃圾桶凳子", "猩猩董事长", new BigDecimal(999), 0, 1, "/static/img/furn/1.jpg");
//        int i = furnDAO.addFurn(furn);
//
//        System.out.println(i);
//    }
//
//     @Test
//    void getTotalRow(){
//        System.out.println(furnDAO.getTotalRow());
//     }
//
//     @Test
//     void getPageItems(){
//
//         List<Furn> furns = furnDAO.getPageItems(5, 5);
//         for (int i = 0; i < furns.size(); i++) {
//             System.out.println(furns.get(i));
//         }
//    }
//
//    @Test
//    void getTotalRowByName(){
//        System.out.println(furnDAO.getTotalRowByName("沙发"));
//    }
//
//    @Test
//    void getPageItemsByName(){
//        System.out.println(furnDAO.getPageItemsByName(1, 3, "沙发"));
//    }
//
//    @Test
//    void saveOrder(){
//        Order order = new Order("20230701",new Date(),new BigDecimal(999), 0, 7);
//        System.out.println(order.getCreateTime());
//        //int i = orderDAO.saveOrder(order);
//        //System.out.println(i);
//    }
//
//    @Test
//    void getOrders(){
//        List<Order> orders = orderDAO.getOrders();
//        System.out.println(orders);
//        System.out.println("---------------------------");
//        List<OrderItem> orderItems = orderItemDAO.getOrderItems();
//        System.out.println(orderItems);
//    }
//}

package com.leon.xinfur.web; /**
 * Date：2024/7/13  9:16
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.dao.OrderDAO;
import com.leon.xinfur.dao.impl.OrderDAOImpl;
import com.leon.xinfur.entity.Cart;
import com.leon.xinfur.entity.Member;
import com.leon.xinfur.entity.Order;
import com.leon.xinfur.entity.OrderItem;
import com.leon.xinfur.service.OrderService;
import com.leon.xinfur.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BasicServlet {
    OrderService orderService = new OrderServiceImpl();

    protected void saveOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Member member = (Member) request.getSession().getAttribute("member");
        if (member == null) {//未登录 转发到登录页面
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
            return;
        }
        if (cart == null || cart.isEmpty()) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        String orderId = orderService.createOrder(cart, member.getId());
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/views/order/checkout.jsp");
    }

    protected void showOrderItemById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String Id = request.getParameter("id");
        Order order = orderService.queryOrderById(Id);
        List<OrderItem> orderItems = orderService.queryOrderItemsById(Id);
        request.getSession().setAttribute("orderItems", orderItems);
        request.getSession().setAttribute("order", order);
        request.getRequestDispatcher("/views/order/order_detail.jsp").forward(request, response);
    }

    protected void showOrders(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Order> orders = orderService.showOrders();
        request.getSession().setAttribute("orders", orders);
        request.getRequestDispatcher("/views/order/order.jsp").forward(request, response);
    }

}

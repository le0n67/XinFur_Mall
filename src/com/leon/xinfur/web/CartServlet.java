package com.leon.xinfur.web;

import com.leon.xinfur.entity.Cart;
import com.leon.xinfur.entity.CartItem;
import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.impl.FurnServiceImpl;
import com.leon.xinfur.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date：2024/7/9  18:01
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class CartServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取使用工具类id
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);

        CartItem cartItem = new CartItem(furn.getId(), furn.getName(), furn.getPrice(), 1, furn.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        response.sendRedirect(request.getHeader("Referer"));
    }


}

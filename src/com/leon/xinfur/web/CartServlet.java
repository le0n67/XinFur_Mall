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

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session中的购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.clear();
        }

        //返回清空购物车的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void delItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        //获取到cart购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.delItem(id);
        }
        //返回到请求删除购物车的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 更新某个CartItem的数量, 即更新购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        //这里可以根据业务来处理
        int count = DataUtils.parseInt(req.getParameter("count"), 1);

        //获取session中购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.updateCount(id, count);
        }
        //回到请求更新购物车的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取使用工具类id
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);

        //判断库存
        if (furn.getStock() <= 0) {
            response.sendRedirect(request.getHeader("Referer"));
            return;
        }
        CartItem cartItem = new CartItem(furn.getId(), furn.getName(), furn.getPrice(), 1, furn.getPrice(), furn.getImgPath());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        response.sendRedirect(request.getHeader("Referer"));
    }


}

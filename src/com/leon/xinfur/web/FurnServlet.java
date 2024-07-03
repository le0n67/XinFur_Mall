package com.leon.xinfur.web; /**
 * Date：2024/7/3  20:21
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.impl.FurnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class FurnServlet extends BasicServlet {
    private FurnService furnService= new FurnServiceImpl();

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FurnServlet.list()");
        List<Furn> Furns = furnService.getAllFurn();
        request.setAttribute("furns", Furns);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }
}

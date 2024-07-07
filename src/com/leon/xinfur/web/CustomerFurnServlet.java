package com.leon.xinfur.web; /**
 * Date：2024/7/7  17:35
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.entity.Page;
import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.impl.FurnServiceImpl;
import com.leon.xinfur.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CustomerFurnServlet extends BasicServlet {
    FurnService furnService=new FurnServiceImpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.DEFAULT_PAGE_SIZE);
        Page<Furn> page = furnService.Page(pageNo, pageSize);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/views/customer/index.jsp").forward(request, response);
    }
}

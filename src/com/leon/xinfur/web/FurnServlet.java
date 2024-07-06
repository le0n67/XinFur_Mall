package com.leon.xinfur.web; /**
 * Date：2024/7/3  20:21
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
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public class FurnServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furn> Furns = furnService.getAllFurn();
        request.setAttribute("furns", Furns);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建一个新的Furn对象
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());

        // 将Furn对象添加到furnService中
        furnService.addFurn(furn);

        // 跳转到furnServlet页面，传入action=list参数
        //request.getRequestDispatcher("/manage/furnServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        furnService.deleteFurnById(DataUtils.parseInt(request.getParameter("id"), 0));
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
    }

    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        request.setAttribute("furn", furn);
        request.getRequestDispatcher("/views/manager/furn_update.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
        furnService.updateFurn(furn);
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.DEFAULT_PAGE_SIZE);
        Page<Furn> page = furnService.Page(pageNo, pageSize);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }
}

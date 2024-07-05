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

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FurnServlet.list()");
        List<Furn> Furns = furnService.getAllFurn();
        request.setAttribute("furns", Furns);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建一个新的Furn对象
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());

        // 将Furn对象添加到furnService中
        furnService.addFurn(furn);

        // 跳转到furnServlet页面，传入action=list参数
        //request.getRequestDispatcher("/manage/furnServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
    }
}

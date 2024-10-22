package com.leon.xinfur.filter;


/**
 * Date：2024/7/14  17:02
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.google.gson.Gson;
import com.leon.xinfur.entity.Member;
import com.leon.xinfur.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AuthFilter implements Filter {
    private List<String> excludedUrls;

    public void init(FilterConfig config) throws ServletException {
        String[] excludedUrlsStr = config.getInitParameter("excludedUrls").split(",");
        excludedUrls = Arrays.asList(excludedUrlsStr);
        System.out.println("excludedUrls:" + excludedUrls);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getServletPath();
        System.out.println("url:" + url);
        if (!excludedUrls.contains(url)) {
            Member member = (Member) req.getSession().getAttribute("member");

            //如果用户名id大于2 则为普通用户访问/views/manager/* 时跳转到/views/manager/manage_login.jsp
            if (member != null && member.getId() > 2) {
                if (url.startsWith("/views/manager/")) {
                    if (!DataUtils.isAjax(req)) {
                        req.getRequestDispatcher("/views/manager/manage_login.jsp").forward(request, response);
                    } else {
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("url", "views/manager/manage_login.jsp");
                    }
                }
            }

            if (member == null) {
                if (!DataUtils.isAjax(req)) {
                    req.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
                } else {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("url", "views/member/login.jsp");
                    String resultJson = new Gson().toJson(resultMap);
                    response.getWriter().write(resultJson);
                }
                return;
            }
        }
        chain.doFilter(request, response);
    }
}

package com.leon.xinfur.filter;


/**
 * Date：2024/7/14  17:02
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AuthFilter implements Filter {
    private List<String> excludedUrls;
    public void init(FilterConfig config) throws ServletException {
        String[] excludedUrlsStr = config.getInitParameter("excludedUrls").split(",");
        excludedUrls= Arrays.asList(excludedUrlsStr);
        System.out.println("excludedUrls:"+excludedUrls);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getServletPath();
        System.out.println("url:"+url);
        if(!excludedUrls.contains(url)) {
            Member member = (Member)  req.getSession().getAttribute("member");
            if (member == null) {
                req.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }
}

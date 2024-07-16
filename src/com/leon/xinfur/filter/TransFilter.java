package com.leon.xinfur.filter; /**
 * Date：2024/7/16  15:05
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import java.io.IOException;

public class TransFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            JDBCUtilsByDruid.commit();
        } catch (IOException e) {
            JDBCUtilsByDruid.rollback();
            throw new RuntimeException(e);
        }
    }
}

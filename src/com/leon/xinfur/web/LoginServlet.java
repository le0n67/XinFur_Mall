//package com.leon.xinfur.web; /**
// * Date：2024/7/2  17:04
// * Description：TODO
// *
// * @author Leon
// * @version 1.0
// */
//
//import com.leon.xinfur.entity.Member;
//import com.leon.xinfur.service.MemberService;
//import com.leon.xinfur.service.impl.MemberServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//public class LoginServlet extends HttpServlet {
//    MemberService memberService = new MemberServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取用户名和密码
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //判断这个用户是否存在
//        if (memberService.login(username, password) != null) {
//            //如果用户存在，则跳转到登录成功页面
//            request.getRequestDispatcher("/views/member/login_ok.jsp")
//                    .forward(request, response);
//        } else {
//            //如果用户不存在，则跳转到登录页面，并显示错误信息
//            request.setAttribute("msg", "登录名或密码错误");
//            request.setAttribute("username", username);
//            request.getRequestDispatcher("/views/member/login.jsp")
//                    .forward(request, response);
//        }
//    }
//}

//package com.leon.xinfur.web;
///**
// * Date：2024/7/1  18:02
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
//public class RegisterServlet extends HttpServlet {
//    MemberService memberService=new MemberServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //用户名
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//
//        //判断这个用户名是不是可用
//        if(!memberService.isExistsUserName(username)) {
//            //注册
//            //System.out.println("用户名 " + username + " 不存在, 可以注册");
//            //构建一个Member对象
//            Member member = new Member(null, username, password, email);
//            if(memberService.registerMember(member)) {
//                //请求转发
//                request.getRequestDispatcher("/views/member/register_ok.jsp")
//                        .forward(request,response);
//            } else  {
//                //请求转发
//                request.getRequestDispatcher("/views/member/register_fail.jsp")
//                        .forward(request,response);
//            }
//
//        } else  {
//            //返回注册页面
//            //后面可以加入提示信息...
//            request.getRequestDispatcher("/views/member/login.jsp")
//                    .forward(request,response);
//        }
//    }
//}

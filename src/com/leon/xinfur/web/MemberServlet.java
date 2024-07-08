package com.leon.xinfur.web; /**
 * Date：2024/7/3  11:20
 * Description：处理Member相关的请求
 *
 * @author Leon
 * @version 1.0
 */

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.leon.xinfur.entity.Member;
import com.leon.xinfur.service.MemberService;
import com.leon.xinfur.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class MemberServlet extends BasicServlet {
    private MemberService memberService = new MemberServiceImpl();

    //@Override
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    String action = request.getParameter("action");
    //    if ("login".equals(action)) {
    //        login(request, response);
    //    } else if ("register".equals(action)) {
    //        register(request, response);
    //    }else{
    //        response.getWriter().write("请求错误");
    //    }
    //}

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了登录操作");
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code1");
        Member member = memberService.login(username, password);
        //后端取得session
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除session内容
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {

            //判断这个用户是否存在
            if (member != null) {
                //如果用户存在，则跳转到登录成功页面
                //存入session
                request.getSession().setAttribute("member", member);
                request.getRequestDispatcher("/views/member/login_ok.jsp")
                        .forward(request, response);
            } else {
                //如果用户不存在，则跳转到登录页面，并显示错误信息
                request.setAttribute("msg1", "登录名或密码错误");
                request.setAttribute("username", username);
                request.getRequestDispatcher("/views/member/login.jsp")
                        .forward(request, response);
            }
        } else {
            //如果验证码错误，则跳转到登录页面，并显示错误信息
            request.setAttribute("msg1", "验证码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/member/login.jsp")
                    .forward(request, response);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了注册操作");
        //用户名
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code2");
        //后端取得session
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除session内容
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {
            //判断这个用户名是不是可用
            if (!memberService.isExistsUserName(username)) {
                //注册
                //System.out.println("用户名 " + username + " 不存在, 可以注册");
                //构建一个Member对象
                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)) {
                    //请求转发
                    request.getRequestDispatcher("/views/member/register_ok.jsp")
                            .forward(request, response);
                } else {
                    //请求转发
                    request.getRequestDispatcher("/views/member/register_fail.jsp")
                            .forward(request, response);
                }
            } else {
                //返回注册页面
                //后面可以加入提示信息...
                request.setAttribute("msg2", "用户名已存在");
                request.setAttribute("active","register");
                request.getRequestDispatcher("/views/member/login.jsp")
                        .forward(request, response);
            }
        } else {
            //如果验证码错误，则跳转到注册页面，并显示错误信息
            request.setAttribute("msg2", "验证码错误");
            request.setAttribute("email",email);
            request.setAttribute("username", username);
            request.setAttribute("active","register");
            request.getRequestDispatcher("/views/member/login.jsp")
                    .forward(request, response);
        }
    }

    //判断是否为管理员
    protected void isAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了判断是否为管理员操作");
        String username = request.getParameter("username");
        if (!memberService.isAdmin(username)) {
            request.setAttribute("msg", "管理员账号或密码有误");
            request.getRequestDispatcher("/views/manager/manage_login.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/views/manager/manage_menu.jsp")
                    .forward(request, response);
        }
    }

    //退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了退出登录操作");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
}

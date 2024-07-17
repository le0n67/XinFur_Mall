<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>猩家居</title>
    <base href="<%= request.getContextPath() +"/" %> ">
    <link rel="icon" href="assets/images/icons/icon.png" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css"/>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {//页面加载完毕的事件

            $("#username2").blur(function () {
                var username = this.value;
                $.getJSON(
                    "memberServlet", "action=isExist&username=" + username,
                    function (data) {
                        if (data.isExist) {
                            $(".errorMsg2").text("用户名已存在")
                        }
                    }
                )

            })

            if ("${requestScope.active}" === "register") {
                $("#register_tab")[0].click();//模拟点击
            }

            $("#sub-btn1").click(function () {
                var usernameVal = $("#username1").val();
                //正则表达式验证用户名
                var usernamePattern = /^\w{3,10}$/
                if (!usernamePattern.test(usernameVal)) {
                    $(".errorMsg1").text("用户名格式有误(3-10个字符)")
                    // $("span[class='errorMsg']").text("用户名格式有误(6-10个字符)")
                    return false
                }
                //验证密码
                var pwdVal = $("#password1").val();
                var pwdPattern = /^\w{4,10}$/
                if (!pwdPattern.test(pwdVal)) {
                    $(".errorMsg1").text("密码格式有误(4-10个字符)")
                    return false
                }

                // 验证码：浏览器这里验证不能为空
                var codeText = $("#code1").val();
                //去掉验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText === "") {
                    //提示
                    $("span.errorMsg1").text("验证码不能为空！");
                    return false;
                }

                //到这里就全部过关. => 我们暂时不提交，显示验证通过信息
                $("span.errorMsg1").text("验证通过...");
                //目前我们写了后台，当验证通过时，就提交给后台
                return true;
            })

            $("#sub-btn2").click(function () {
                var usernameVal = $("#username2").val();
                //正则表达式验证用户名
                var usernamePattern = /^\w{3,10}$/
                if (!usernamePattern.test(usernameVal)) {
                    $(".errorMsg2").text("用户名格式有误(3-10个字符)")
                    // $("span[class='errorMsg']").text("用户名格式有误(6-10个字符)")
                    return false
                }
                //验证密码
                var pwdVal = $("#password2").val();
                var pwdPattern = /^\w{4,10}$/
                if (!pwdPattern.test(pwdVal)) {
                    $(".errorMsg2").text("密码格式有误(4-10个字符)")
                    return false
                }
                var repwdVal = $("#repwd").val();
                if (repwdVal !== pwdVal) {
                    $(".errorMsg2").text("输入两次密码不相同")
                    return false
                }
                var emailVal = $("#email").val();
                var emailPattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
                if (!emailPattern.test(emailVal)) {
                    $(".errorMsg2").text("电子邮箱格式有误")
                    return false
                }

                // 验证码：浏览器这里验证不能为空
                var codeText = $("#code2").val();
                //去掉验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText === "") {
                    //提示
                    $("span.errorMsg2").text("验证码不能为空！");
                    return false;
                }

                //到这里就全部过关. => 我们暂时不提交，显示验证通过信息
                $("span.errorMsg2").text("验证通过...");
                //目前我们写了后台，当验证通过时，就提交给后台
                return true;
            })

            $("#codeimg1,#codeimg2").click(function () {
                this.src = "<%=request.getContextPath()%>/kaptchaServlet?d=" + new Date()
            })

        })


    </script>
</head>

<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top Message Start -->
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.jsp"><img src="assets/images/logo/logo.png" alt="Site Logo" width="280px"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->

            </div>
        </div>
    </div>
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.jsp"><img src="assets/images/logo/logo.png" alt="Site Logo" width="280px"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Header Area End  -->
<!-- login area start -->
<div class="login-register-area pt-70px pb-100px">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                <div class="login-register-wrapper">
                    <div class="login-register-tab-list nav">
                        <a id="login_tab" class="active" data-bs-toggle="tab" href="#lg1">
                            <h4>会员登录</h4>
                        </a>
                        <a id="register_tab" data-bs-toggle="tab" href="#lg2">
                            <h4>会员注册</h4>
                        </a>
                    </div>
                    <div class="tab-content">
                        <div id="lg1" class="tab-pane active">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg1"
                                          style="float: right; font-weight: bold; font-size: 18pt; color: red">
                                        ${requestScope.msg1}
                                    </span>
                                    <form action="memberServlet" method="post">
                                        <input type="hidden" name="action" value="login">
                                        <input type="text" id="username1" value="${requestScope.username}"
                                               name="username" placeholder="用户名"/>
                                        <input type="password" id="password1" name="password" placeholder="密码"/>
                                        <input type="text" id="code1" name="code1" style="width: 50%"
                                               placeholder="验证码"/><img id="codeimg1" alt="" src="kaptchaServlet">
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox"/>
                                                <a class="flote-none" href="javascript:void(0)">保存信息</a>
                                                <a href="#">忘记密码</a>
                                            </div>
                                            <button type="submit" id="sub-btn1"><span>登录</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="lg2" class="tab-pane">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg2"
                                          style="float: right; font-weight: bold; font-size: 18pt; color: red">
                                        ${requestScope.msg2}
                                    </span>
                                    <!-- 注册 -->
                                    <form action="memberServlet" method="post">
                                        <input type="hidden" name="action" value="register">
                                        <input type="text" id="username2" name="username" placeholder="用户名"
                                               value="${requestScope.username}"/>
                                        <input type="password" id="password2" name="password" placeholder="输入密码"/>
                                        <input type="password" id="repwd" name="repassword" placeholder="确认密码"/>
                                        <input name="email" id="email" placeholder="电子邮件" type="email"
                                               value="${requestScope.email}"/>
                                        <input type="text" id="code2" name="code2" style="width: 50%"
                                               placeholder="验证码"/><img id="codeimg2" alt="" src="kaptchaServlet">
                                        <div class="button-box">
                                            <button type="submit" id="sub-btn2"><span>会员注册</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- login area end -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">信息</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="#">关于我们</a></li>
                                        <li class="li"><a class="single-link" href="#">交货信息</a></li>
                                        <li class="li"><a class="single-link" href="#">隐私与政策</a></li>
                                        <li class="li"><a class="single-link" href="#">条款和条件</a></li>
                                        <li class="li"><a class="single-link" href="#">制造</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">我的账号</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">我的账号</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">我的购物车</a></li>
                                        <li class="li"><a class="single-link" href="login.jsp">登录</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">感兴趣的</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">结账</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text">Copyright &copy; 2024 猩家居</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>
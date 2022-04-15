<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>系统登录 | Log in</title>

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <style>
        .form-group .form-control {
            width: 250px !important;
        }

        .form-control-feedback {
            left: 200px;
        }
    </style>
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="all-admin-index.html"><b>19物联网</b>信息管理系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">验证码登录</p>

            <div class="row">
                <div class="col-xs-8">
                    <div class="form-group has-feedback">
                        <input id="phoneNumber" type="text" name="phoneNumber" class="form-control"
                               placeholder="手机号码"> <span
                            class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-4">
                    <button id="btn" type="button" class="btn btn-primary btn-block btn-flat" onclick="huoQu();"  >获取验证码</button>
                </div>
            </div>

        <form action="${pageContext.request.contextPath}/user/check"
              method="post">
            <div class="row">
                <div class="col-xs-8">
                    <div class="form-group has-feedback">
                        <input type="text" name="checkCode" class="form-control"
                               placeholder="请输入获取的验证码"> <span
                            class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/login.jsp">账密登录</a>


    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

</script>

<script >
    var phoneNumber = $("#phoneNumber").val();
    function huoQu() {
        $.post("${pageContext.request.contextPath}/user/message",{"phoneNumber":phoneNumber},function () {

        },"json");
    }
</script>
</body>
</html>
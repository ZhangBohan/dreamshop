<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bohan
  Date: 9/1/13
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <jsp:include page="../include/alert.jsp" />
    <div class="row">
        <div class="col-md-6">
            <h2 class="form-signin-heading">已有账号？请登录</h2>
            <form class="form-signin" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
                <input type="text" class="form-control" placeholder="用户名" autofocus name="username">
                <input type="password" class="form-control" placeholder="密码" name="password">
                <label class="checkbox">
                    <input type="checkbox" checked="" name="_spring_security_remember_me"> 记住我
                </label>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
            </form>
        </div>
        <div class="col-md-6">
            <h2 class="form-signin-heading">还没有账号？请注册</h2>
            <form:form commandName="signUp" cssClass="form-signin" class="form-horizontal" action="${pageContext.request.contextPath}/auth/signUp" method="post">
                <form:errors path="*" cssClass="alert-danger" element="div" />
                <div class="control-group">
                    <label for="suUsername" class="control-label">用户名</label>
                    <div class="controls">
                        <form:input path="username" cssClass="form-control" id="suUsername" placeholder="用户名" />
                        <span class="help-block"><form:errors path="username" cssClass="alert-danger" /></span>
                    </div>
                </div>
                <div class="control-group">
                    <label for="suPassword" class="control-label">密码</label>
                    <div class="controls">
                        <form:password path="password" cssClass="form-control" id="suPassword" placeholder="密码" />
                        <span class="help-block"><form:errors path="password" cssClass="alert-danger" /></span>
                    </div>
                </div>
                <div class="control-group">
                    <label for="suRePassword" class="control-label">再次输入密码</label>
                    <div class="controls">
                        <form:password path="rePassword" cssClass="form-control" id="suRePassword"
                                       placeholder="请再次输入一次您的密码" />
                        <span class="help-block"><form:errors path="rePassword" cssClass="alert-danger" /></span>
                    </div>
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
            </form:form>
        </div>
    </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>

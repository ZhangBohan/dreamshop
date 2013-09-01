<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-glyphicons.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <h2 class="form-signin-heading">注册</h2>

    <jsp:include page="../include/alert.jsp" />
    <form:form commandName="signUp" cssClass="form-signin" action="/auth/signUp" method="post">
        <form:errors path="*" cssClass="alert-danger" element="div" />
        <div class="form-group">
            <label for="inputUsername" class="col-lg-2 control-label">用户名</label>
            <div class="col-lg-10">
                <form:input path="username" cssClass="form-control" id="inputUsername" placeholder="用户名" />
                <span class="help-block"><form:errors path="username" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">名称</label>
            <div class="col-lg-10">
                <form:password path="password" cssClass="form-control" id="inputPassword" placeholder="密码" />
                <span class="help-block"><form:errors path="password" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputRePassword" class="col-lg-2 control-label">名称</label>
            <div class="col-lg-10">
                <form:password path="rePassword" cssClass="form-control" id="inputRePassword"
                               placeholder="请再次输入一次您的密码" />
                <span class="help-block"><form:errors path="rePassword" cssClass="alert-danger" /></span>
            </div>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form:form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>

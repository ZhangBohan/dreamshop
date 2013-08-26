<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" cntent="text/html;charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="test">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

    <title>修改商品|梦之店</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.css" rel="stylesheet">
</head>

<body>

<!-- Static navbar -->
<div class="navbar navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">梦之店</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">收银</a></li>
                <li><a href="/goods/add">增加商品</a></li>
                <li class="active"><a href="/goods">管理商品</a></li>
            </ul>
            <p class="navbar-text pull-right">Signed in as <a href="/user/<security:authentication property="principal.username"/>"><security:authentication property="principal.username"/></a></p>
        </div><!--/.nav-collapse -->
    </div>
</div>


<div class="container">
    <form:form method="post" commandName="goods" action="/goods/edit">
        <form:errors path="*" cssClass="alert-danger" element="div" />
        <div class="form-group">
            <label for="inputBarCode" class="col-lg-2 control-label">条码</label>
            <div class="col-lg-4">
                <form:input path="barCode" cssClass="form-control" id="inputBarCode" placeholder="商品条码" />
                <span class="help-block"><form:errors path="barCode" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputUsername" class="col-lg-2 control-label">名称</label>
            <div class="col-lg-4">
                <form:input path="name" cssClass="form-control" id="inputUsername" placeholder="商品名称" />
                <span class="help-block"><form:errors path="name" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPrice" class="col-lg-2 control-label">价格</label>
            <div class="col-lg-4">
                <form:input path="price" cssClass="form-control" id="inputPrice" placeholder="商品价格" />
                <span class="help-block"><form:errors path="price" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputCost" class="col-lg-2 control-label">成本</label>
            <div class="col-lg-4">
                <form:input path="cost" cssClass="form-control" id="inputCost" placeholder="商品成本" />
                <span class="help-block"><form:errors path="cost" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputUnit" class="col-lg-2 control-label">单位</label>
            <div class="col-lg-4">
                <form:input path="unit" cssClass="form-control" id="inputUnit" placeholder="商品单位" />
                <span class="help-block"><form:errors path="unit" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpecification" class="col-lg-2 control-label">规格</label>
            <div class="col-lg-4">
                <form:input path="specification" cssClass="form-control" id="inputSpecification" placeholder="商品规格" />
                <span class="help-block"><form:errors path="specification" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-4">
                <button type="submit" class="btn btn-primary btn-lg">进货</button>
            </div>
        </div>
    </form:form>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>

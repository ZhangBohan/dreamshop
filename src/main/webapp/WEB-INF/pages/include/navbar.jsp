<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- Static navbar -->
<div class="navbar navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/sell">梦之店</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="nav-sell"><a href="${pageContext.request.contextPath}/sell">收银</a></li>
                <li class="nav-add"><a href="${pageContext.request.contextPath}/goods/add">增加商品</a></li>
                <li class="nav-manage"><a href="${pageContext.request.contextPath}/goods">管理商品</a></li>
                <li class="nav-in"><a href="${pageContext.request.contextPath}/goods">收入统计</a></li>
            </ul>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span>
                        <security:authentication property="principal.username"/>
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/manage/auth/reset">修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/auth/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
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
            <a class="navbar-brand" href="#">梦之店</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="nav-come"><a href="#">收银</a></li>
                <li class="nav-add"><a href="/goods/add">增加商品</a></li>
                <li class="nav-manage"><a href="/goods">管理商品</a></li>
            </ul>
            <p class="navbar-text pull-right">您好，<a href="/user/detail"><security:authentication property="principal.username"/></a></p>
        </div><!--/.nav-collapse -->
    </div>
</div>
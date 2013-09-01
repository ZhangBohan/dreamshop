<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

    <title>管理商品|梦之店</title>
    <link href="/css/bootstrap-glyphicons.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">

</head>

<body>

<jsp:include page="../include/navbar.jsp" />


<div class="container">
    <jsp:include page="../include/alert.jsp">
        <jsp:param name="messages" value="${messages}" />
    </jsp:include>
    <div class="search-form">
        <form id="searchForm" class="form-format form-inline" role="form">
            <div class="input-group">
                <span class="input-group-addon">录入框</span>
                <input id="barCodeSearch" type="text" class="form-control" placeholder="请刷条码或输入搜索条件" autofocus="">
            </div>
        </form>
    </div>

    <div class="content-table">
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th></th>
                    <th>条码</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>单位</th>
                    <th>规格</th>
                    <th>数量</th>
                    <th>金额</th>
                </tr>
            </thead>
            <tbody id="goods-list">
                <c:forEach begin="1" end="5" var="index">
                    <tr class="empty-sell">
                        <td>${index}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="search-form">
        <form id="sumForm" class="form-format form-inline" role="form">
            <div class="input-group">
                <span class="input-group-addon">结算框</span>
                <input id="sum-input" type="text" class="form-control col-lg-4" placeholder="收款金额">
                <span class="input-group-btn">
                    <input type="submit" class="btn btn-primary" value="结算">
                </span>
            </div>
        </form>
    </div>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>

<script>
    $(document).ready(function(){
        $(".nav-sell").addClass("active");
    });
</script>
</body>
</html>

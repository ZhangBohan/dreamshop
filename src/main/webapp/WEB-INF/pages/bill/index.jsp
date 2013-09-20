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
    <link href="${pageContext.request.contextPath}/css/bootstrap-glyphicons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

</head>

<body>

<jsp:include page="../include/navbar.jsp" />


<div class="container">
    <jsp:include page="../include/alert.jsp">
        <jsp:param name="messages" value="${messages}" />
    </jsp:include>
    <script type="text/x-handlebars" data-template-name="details">
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
                        <th>数量</th>
                        <th>金额（¥）</th>
                    </tr>
                </thead>
                <tbody id="goods-list">
                    {{#each}}
                        <tr>
                            <td>{{_view.contentIndex}}</td>
                            <td>{{barCode}}</td>
                            <td>{{name}}</td>
                            <td>{{price}}</td>
                            <td>{{unit}}</td>
                            <td>{{count}}</td>
                            <td>{{sum}}</td>
                        </tr>
                    {{/each}}
                    {{#if isNotDeal}}
                        <c:forEach begin="1" end="5" var="index">
                            <tr class="empty-sell">
                                <td>${index}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    {{/if}}
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="6">合计</td>
                        <td>{{totalSum}}</td>
                    </tr>
                </tfoot>
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

    </script>
</div> <!-- /container -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>


<!-- Ember JS
================================================== -->
<script src="${pageContext.request.contextPath}/js/ember/libs/handlebars-1.0.0.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/libs/ember.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/libs/ember-data.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/libs/local_storage_adapter.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/application.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/router.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/models/goods.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/models/bill.js"></script>
<script src="${pageContext.request.contextPath}/js/ember/controllers/details_controller.js"></script>
</body>
</html>

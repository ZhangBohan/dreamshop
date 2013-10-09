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

    <title>收银 | 梦之店</title>
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
            <div class="input-group">
                {{input id="barCodeSearch" type="text" class="form-control"
                    placeholder="请刷条码或输入搜索条件，技巧：以“+”开始代表临时记录商品；以“-”开始代表结算。回车键提交当前内容" action="searchResult" value=searchText}}
                <span class="input-group-btn">
                    <button class="btn btn-info" {{action "settlement"}}><span class="glyphicon glyphicon-search"></span>搜索</button>
                </span>
            </div>
        </div>

        <div class="content-table">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr class="warning">
                        <th></th>
                        <th>条码</th>
                        <th>名称</th>
                        <th>价格（¥）</th>
                        <th>数量</th>
                        <th>金额（¥）</th>
                    </tr>
                </thead>
                <tbody>
                    {{#each}}
                        <tr>
                            <td>{{_view.contentIndex}}</td>
                            <td>{{barCode}}</td>
                            <td>{{name}}</td>
                            <td>{{price}}</td>
                            <td>{{count}}（{{unit}}）</td>
                            <td>{{sum}}</td>
                        </tr>
                    {{else}}
                        <tr class="empty-sell">
                            <td>0</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    {{/each}}
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5" class="warning">合计</td>
                        <td class="success">{{totalSum}}</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div id="settlement-modal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">梦之店结账单</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-hover table-bordered">
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>价格（¥）</th>
                                <th>数量</th>
                                <th>金额（¥）</th>
                            </tr>
                            </thead>
                            <tbody>
                            {{#each}}
                            <tr>
                                <td>{{name}}</td>
                                <td>{{price}}</td>
                                <td>{{count}}（{{unit}}）</td>
                                <td>{{sum}}</td>
                            </tr>
                            {{/each}}
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="3" class="warning">合计</td>
                                <td class="success">{{totalSum}}</td>
                            </tr>
                            </tfoot>
                        </table>
                        <h3>
                            <span class="label label-info">{{moneyGet}} 元</span> -
                            <span class="label label-info">{{totalSum}} 元</span> =
                            找零：<span class="label label-success">{{change}} 元</span>
                        </h3>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" {{action "clearBill"}}>清除当前数据</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" id="saveSettlement" class="btn btn-primary" {{action "createBill"}}>保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </script>
</div> <!-- /container -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/mousetrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/modal.js"></script>
<script src="${pageContext.request.contextPath}/js/alert.js"></script>
<script src="${pageContext.request.contextPath}/js/api.js"></script>
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
<script src="${pageContext.request.contextPath}/js/ember/views/details_view.js"></script>

<script>
    $(document).ready(function(){
        $(".nav-sell").addClass("active");
        $("#barCodeSearch").focus();

        if($.API.hasModified()) {
            console.log("Goods data has modified.");
            var goodsList = $.API.getGoodsList();
            localStorage.goodsListStr = JSON.stringify(goodsList);
            Details.Goods.FIXTURES = goodsList;
            console.log("Goods data has auto sync.");
        }
    });
</script>
</body>
</html>

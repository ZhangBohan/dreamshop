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
        <div class="search-form">
            <form id="searchForm" action="" class="form-format form-inline" method="post" role="form">
                <input type="hidden" id="pager_page" value="${pager.page}">
                <input type="hidden" id="pager_total" value="${pager.total}">
                <input type="hidden" id="pager_size" value="${pager.size}">
            </form>
        </div>

        <div class="content-table">
            <table class="table table-hover table-bordered">
                <tr>
                    <th><input type="checkbox" value="" class="selectAll" /></th>
                    <th>索引</th>
                    <th>条码</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>成本</th>
                    <th>单位</th>
                    <th>规格</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${list}" var="goods" varStatus="status">
                    <tr>
                        <td><input type="checkbox" name="ids" class='selectOne' value="${ goods.id }"/></td>
                        <td>${status.index + 1}</td>
                        <td><a href="/goods/${goods.id}/edit">${goods.barCode}</a></td>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>${goods.cost}</td>
                        <td>${goods.unit}</td>
                        <td>${goods.specification}</td>
                        <td>
                            <a href="/goods/${goods.id}/edit" class="btn btn-info">编辑</a>
                            <a href="/goods/${goods.id}/delete" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!-- ===================== Pagination Start ===================== -->
        <div class="pagination" id="itemPage"></div>
        </div>
        <!-- ===================== Pagination End ===================== -->
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.myPagination.js"></script>

    <script>
        $(document).ready(function(){
            $(".nav-manage").addClass("active");
        });

        var currPageDiv = "#pager_page";
        var totalDiv = "#pager_total";
        var sizeDiv = "#pager_size";
        $.pageList(".pagination","#searchForm",currPageDiv,totalDiv,sizeDiv);
    </script>
  </body>
</html>

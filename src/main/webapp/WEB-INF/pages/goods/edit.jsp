<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" cntent="text/html;charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="test">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

    <title>修改商品 | 梦之店</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap-glyphicons.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</head>

<body>

<jsp:include page="../include/navbar.jsp" />


<div class="container">
    <jsp:include page="../include/alert.jsp">
        <jsp:param name="messages" value="${messages}" />
    </jsp:include>

    <form:form method="post" id="edit_goods_form" commandName="goods" action="">
        <form:errors path="*" cssClass="alert-danger" element="div" />
        <div class="form-group">
            <label for="inputBarCode" class="col-lg-2 control-label">条码</label>
            <div class="col-lg-10">
                <form:input path="barCode" cssClass="form-control" id="inputBarCode" placeholder="商品条码" />
                <span class="help-block"><form:errors path="barCode" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-lg-2 control-label">名称</label>
            <div class="col-lg-10">
                <form:input path="name" cssClass="form-control" id="inputName" placeholder="商品名称" />
                <span class="help-block"><form:errors path="name" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPrice" class="col-lg-2 control-label">价格</label>
            <div class="col-lg-10">
                <form:input path="price" cssClass="form-control" id="inputPrice" placeholder="商品价格" />
                <span class="help-block"><form:errors path="price" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputCost" class="col-lg-2 control-label">成本</label>
            <div class="col-lg-10">
                <form:input path="cost" cssClass="form-control" id="inputCost" placeholder="商品成本" />
                <span class="help-block"><form:errors path="cost" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputUnit" class="col-lg-2 control-label">单位</label>
            <div class="col-lg-10">
                <form:input path="unit" cssClass="form-control" id="inputUnit" placeholder="商品单位" />
                <span class="help-block"><form:errors path="unit" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpecification" class="col-lg-2 control-label">规格</label>
            <div class="col-lg-10">
                <form:input path="specification" cssClass="form-control" id="inputSpecification" placeholder="商品规格" />
                <span class="help-block"><form:errors path="specification" cssClass="alert-danger" /></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpecification" class="col-lg-2 control-label">修改时间</label>
            <div class="col-lg-10">
                <p class="form-control-static">${goods.modifiedAt}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpecification" class="col-lg-2 control-label">创建时间</label>
            <div class="col-lg-10">
                <p class="form-control-static">${goods.createAt}</p>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-primary btn-lg">修改商品</button>
            </div>
        </div>
    </form:form>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $(".nav-manage").addClass("active");
        $("#inputBarCode").focus();
    });
</script>
</body>
</html>

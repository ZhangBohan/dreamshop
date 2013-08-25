<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

    <title>进货|梦之店</title>

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
                <li class="active"><a href="#about">进货</a></li>
            </ul>
            <p class="navbar-text pull-right">Signed in as <a href="#">Mark Otto</a></p>
        </div><!--/.nav-collapse -->
    </div>
</div>


<div class="container">
    <#include "/lib/alert.ftl">
    <form class="form-horizontal" role="form" method="post">
        <div class="form-group">
            <label for="inputBarCode" class="col-lg-2 control-label">条码</label>
            <div class="col-lg-4">
                <input name="barCode" class="form-control" id="inputBarCode" placeholder="商品条码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputUsername" class="col-lg-2 control-label">名称</label>
            <div class="col-lg-4">
                <input name="name" class="form-control" id="inputUsername" placeholder="商品名称">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPrice" class="col-lg-2 control-label">价格</label>
            <div class="col-lg-4">
                <input name="price" type="number" class="form-control" id="inputPrice" placeholder="商品价格">
            </div>
        </div>
        <div class="form-group">
            <label for="inputCost" class="col-lg-2 control-label">成本</label>
            <div class="col-lg-4">
                <input name="cost" type="number" class="form-control" id="inputCost"
                       placeholder="商品成本" value="${goods.cost}">
            </div>
        </div>
        <div class="form-group">
            <label for="inputUnit" class="col-lg-2 control-label">单位</label>
            <div class="col-lg-4">
                <input name="unit" class="form-control" id="inputUnit" placeholder="商品单位">
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpecification" class="col-lg-2 control-label">规格</label>
            <div class="col-lg-4">
                <textarea name="specification" class="form-control" id="inputSpecification" placeholder="商品规格"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-4">
                <button type="submit" class="btn btn-default">进货</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>

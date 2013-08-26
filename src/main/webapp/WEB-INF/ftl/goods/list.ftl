<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

    <title>管理商品|梦之店</title>

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">

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
              <p class="navbar-text pull-right">Signed in as <a href="#">Bohan</a></p>
          </div><!--/.nav-collapse -->
      </div>
  </div>


    <div class="container">
        <#include "/lib/alert.ftl">
        <div class="content-table">
            <table class="table table-hover table-bordered">
                <tr>
                    <th><input type="checkbox" value="" class="selectAll" /></th>
                    <th>索引</th>
                    <th>条码</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>成本</th>
                    <th>规格</th>
                    <th>操作</th>
                </tr>
                <#list list as goods>
                    <tr>
                        <td><input type="checkbox" name="ids" class='selectOne' value="${ goods.id }"/></td>
                        <td>${goods_index + 1}</td>
                        <td><a href="/goods/${goods.id}/edit">${goods.barCode}</a></td>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>${goods.cost}</td>
                        <td>${goods.specification}</td>
                        <td>
                            <a href="/goods/${goods.id}/edit" class="btn btn-info">编辑</a>
                            <a href="/goods/${goods.id}/delete" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
        <div class="content-pagination">
            <ul class="pagination">
                <li class="disabled"><a href="#">«</a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
            </ul>
        </div>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
  </body>
</html>

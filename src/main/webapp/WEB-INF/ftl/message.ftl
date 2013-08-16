<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>应用汇-运营后台</title>
<#include "lib/base_source.ftl">
</head>
<body>
<div class='whole-container'>
<#include "/lib/header.ftl">
    <div>
        <ul class="breadcrumb">
            <li>管理后台</li>
            <span class="divider">/</span>
            <li>消息页面</li>
        </ul>
    </div>

    <div class="container-fluid">
    <#include "lib/alert.ftl">
        <div class='hero-unit'>
            <div class="container">
                <p class="pull-right">
                    <a class="btn btn-large btn-primary" href="javascript:history.back();"><i class="icon-arrow-left icon-white"></i>返回</a>
                    <#if next??>
                        <a class="btn btn-large btn-primary" href="${context.contextPath}${next}"><i class="icon-arrow-right icon-white"></i>确定</a>
                    </#if>
                </p>

            </div>
        </div>
    </div>
</div>
</body>
</html>
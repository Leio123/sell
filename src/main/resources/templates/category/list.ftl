<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#--./ ：代表文件所在的目录（可以省略不写）-->
    <#--../ ：代表文件所在的父级目录-->
    <#--../../ ：代表文件所在的父级目录的父级目录-->
    <#--/ ：代表文件所在的根目录-->
    <#include "../common/nav.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                <tr>
                                    <th>类目id</th>
                                    <th>名字</th>
                                    <th>类型</th>
                                    <th>创建时间</th>
                                    <th>修改时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list categoryList as category>
                                    <tr>
                                        <td>${category.categoryId}</td>
                                        <td>${category.categoryName}</td>
                                        <td>${category.categoryType}</td>
                                        <td>${category.createTime}</td>
                                        <td>${category.updateTime}</td>
                                        <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <#--分页-->
                <#--<div class="col-md-12 column">-->
                    <#--<ul class="pagination pull-right">-->
                        <#--<#if currentPage lte 1>-->
                            <#--<li class="disabled"><a href="#">上一页</a></li>-->
                        <#--<#else>-->
                            <#--<li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>-->
                        <#--</#if>-->

                        <#--<#list 1..productInfoPage.getTotalPages() as index>-->
                            <#--<#if currentPage == index>-->
                                <#--<li class="disabled"><a href="#">${index}<br></a></li>-->
                            <#--<#else>-->
                                <#--<li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}<br></a></li>-->
                            <#--</#if>-->
                        <#--</#list>-->
                        <#--<#if currentPage gte productInfoPage.getTotalPages()>-->
                            <#--<li class="disabled"><a href="#">下一页</a></li>-->
                        <#--<#else>-->
                            <#--<li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>-->
                        <#--</#if>-->
                    <#--</ul>-->
                <#--</div>-->
            </div>
        </div>
    </div>
</div>

</body>

</html>
<#--<#list orderDTOPage.content as orderDTO>-->
<#--${orderDTOPage.orderId}<br>-->
<#--</#list>-->
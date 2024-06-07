<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
    <link rel="stylesheet" href="./Style/show_goods.css">
</head>
<body>
<p class="top">欢迎进入商品详情页</p>
<div class="container">
    <div class="product-image">
        <img src="${img}" alt="商品图片">
    </div>
    <div class="product-info">
        <h1 class="product-name">${name}</h1>
        <p class="product-price">¥${price}</p>
        <p class="product-description">${introduce}</p>
        <a href="/AddCar?id=${id}" class="add-to-cart">加入购物车</a>
        <a href="/Car?demo=7&&idd=${id}" class="add-to-favorites">加入收藏</a>
        <a href="/UserShow" class="go-back">返回</a>
    </div>
</div>


<%--<p class="top">欢迎进入商品详情页</p>--%>
<%--<div class="container">--%>
<%--    <div class="product-image">--%>
<%--        <img src="${img}" alt="商品图片">--%>
<%--    </div>--%>
<%--    <div class="product-info">--%>
<%--        <h1 class="product-name">${name}</h1>--%>
<%--        <p class="product-price">¥${price}</p>--%>
<%--        <p class="product-description">${introduce}</p>--%>
<%--        <a href="/AddCar?id=${id}" class="add-to-cart">加入购物车</a>--%>
<%--        <a href="/Car?demo=7&&idd=${id}" class="add-to-favorites">加入收藏</a>--%>
<%--        <a href="/UserShow" class="go-back">返回</a>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
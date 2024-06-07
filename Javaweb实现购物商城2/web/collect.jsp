<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="Style/collect.css">
</head>
<body>
<p class="top"><a href="/UserShow">首页</a>
    欢迎进入商品收藏页面</p>
<div class="container">
    <div class="product-list">
<c:forEach items="${Arraylist}" var="arr">
        <div class="product-card">
            <div class="product-image">
                <img src="${arr.img}" alt="商品图片">
            </div>
            <div class="product-info">
                <h1 class="product-name">${arr.name}</h1>
                <p class="product-price">¥${arr.price}</p>
                <p class="product-description">${arr.introduce}</p>
                <a href="/Car?demo=9&&shopidd=${arr.id}" class="button">取消收藏</a>
            </div>
        </div>
</c:forEach>
    </div>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="Style/bill.css">
</head>
<body>
<div class="container">
    <h1>订单结算</h1>

    <div class="form-group">
        <label for="name">姓名:</label>
        <input type="text" id="name" name="name" placeholder="请输入您的姓名" value="${name}">
    </div>

    <div class="form-group">
        <label for="phone">电话:</label>
        <input type="text" id="phone" name="phone" placeholder="请输入您的电话" value="${phone}">
    </div>

    <div class="form-group">
        <label for="address">收货地址:</label>
        <input type="text" id="address" name="address" placeholder="请输入您的收货地址" value="${address}">
    </div>

    <h2>购物商品</h2>

    <c:forEach items="${Arraylist}" var="commodity">
        <div class="product">
            <img src="${commodity.img}" alt="Product 1">
            <div class="product-details">
                <div class="product-name">商品名称 ${commodity.name}</div>
                <div class="product-quantity">数量: <span class="amounts">${commodity.amount}</span></div>
                <div class="product-price">商品单价: $ <span class="price">${commodity.price}</span> 元</div>
            </div>
        </div>

    </c:forEach>

    <div class="total">总价: $ <span class="endPrice"></span></div>

    <a href="/Car?demo=6" class="payment-button">付款</a>
    <a href="/Car?demo=2" class="payment-button">返回</a>
</div>
<script>
    let amounts = document.getElementsByClassName('amounts');
    let prices = document.getElementsByClassName('price');
    let sum = 0;
    for (let i = 0; i < amounts.length; i++) {
        sum += parseInt(amounts[i].innerHTML) * parseInt(prices[i].innerHTML);
    }
    document.getElementsByClassName('endPrice')[0].innerHTML = sum;
</script>
</body>
</html>

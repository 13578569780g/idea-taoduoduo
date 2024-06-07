<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./Style/user_index.css">
<html>
<head>
    <title>商城首页</title>
</head>

<body>
<p class="header">${footName}</p>
<div class="top">
    <div class="dropdown">
        <button class="dropbtn">商品分类</button>
        <div class="dropdown-content">
            <a href="/FindCommodity?id=3">美妆</a>
            <a href="/FindCommodity?id=5">食品</a>
            <a href="/FindCommodity?id=6">电器</a>
            <a href="/FindCommodity?id=8">服装</a>
            <a href="/FindCommodity?id=7">全部商品</a>
        </div>
    </div>

    <div class="search-box">
        <form action="/FindCommodity?id=2" method="post">
            <input type="text" name="text1" placeholder="请输入与您要搜索的商品名称">
            <button type="submit">Search</button>
        </form>
    </div>
    <span>当前登录的用户为:&nbsp;&nbsp;${userName}</span>
    <a href="/Car?demo=2" class="button">购物车</a>
    <a href="/Car?demo=3" class="button">我的订单</a>
    <a href="/Car?demo=8" class="button">我的收藏</a>
    <a href="/MyInfor?id=1" class="button">个人中心</a>
    <a href="login.html" class="button">退出登录</a>
</div>

<div class="banner ma" id="pics">
    <div id="xyd" class="yuandian">
        <div class=" yuandian1 fl">1</div>
        <div class=" yuandian2 fl">2</div>
        <div class=" yuandian2 fl">3</div>
        <div class=" yuandian2 fl">4</div>
        <div class=" yuandian2 fl">5</div>
    </div>
    <ul>
        <li><a href=""><img class="img01" src="./imgs/618.jpg"></a></li>
        <li><a href=""><img class="img01" src="./imgs/6.6.jpg"></a></li>
        <li><a href=""><img class="img01" src="./imgs/年终.jpg"></a></li>
        <li><a href=""><img class="img01" src="./imgs/双十一.jpg"></a></li>
        <li><a href=""><img class="img01" src="./imgs/618.jpg"></a></li>
    </ul>
</div>


<div class="container">
    <c:forEach items="${Arraylist1}" var="commodity">
        <div class="product">
            <a href="/Showgoods?id=${commodity.id}">
                <div class="product-content">
                    <img src="${commodity.img}" alt="Product Image" style="height: 200px">
                    <h3 class="product-name">${commodity.name}</h3>
                    <p class="product-price">¥${commodity.price}</p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>


</div>


<script>
    var pics = document.getElementById("pics");
    var yuandians = pics.getElementsByClassName("fl");
    var a = pics.getElementsByTagName("a");
    var currentIndex = 0; // 当前显示的图片的索引

    // 切换图片和圆点的函数
    function switchPic() {
        currentIndex++;
        if (currentIndex >= a.length) {
            currentIndex = 0;
        }
        for (var j = 0; j < yuandians.length; j++) {
            yuandians[j].style.backgroundColor = "yellow";
            a[j].style.display = "none";
        }
        yuandians[currentIndex].style.backgroundColor = "red";
        a[currentIndex].style.display = "block";
    }

    // 自动轮播
    var intervalId = setInterval(switchPic, 1000);

    // 点击圆点切换图片和圆点
    for (var i = 0; i < yuandians.length; i++) {
        yuandians[i].index = i;
        yuandians[i].onmouseover = function () {
            clearInterval(intervalId); // 清除之前的定时器
            currentIndex = this.index;
            for (var j = 0; j < yuandians.length; j++) {
                yuandians[j].style.backgroundColor = "yellow";
                a[j].style.display = "none";
            }
            this.style.backgroundColor = "red";
            a[currentIndex].style.display = "block";
        }
        yuandians[i].onmouseout = function () {
            intervalId = setInterval(switchPic, 2000); // 重新设置定时器
        }
    }
</script>
</body>
</html>
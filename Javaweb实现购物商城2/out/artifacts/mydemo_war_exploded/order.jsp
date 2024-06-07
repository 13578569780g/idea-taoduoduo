<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>我的订单</title>
    <link rel="stylesheet" href="./Style/order.css">
</head>

<body>
<div class="divv">
    <div class="head">
        <a href="/UserShow">首页</a>
    </div>
    <div class="contain">
        <div class="con">
            <div class="con_div1">
                <span style="margin-left: 350px;">商品信息</span>
                <span style="margin-left: 170px;">数量</span>
                <span style="margin-left: 150px;">单价</span>
                <span style="margin-left: 150px;">总价</span>
                <span style="margin-left: 90px;">操作</span>
            </div>
            <c:forEach items="${Arraylist}" var="user">
                <div class="con_div">
                    <div class="con_div_div1"> <img src="${user.img}" alt="" class="con_div_img"></div>
                    <div class="con_div_div2">${user.name}</div>
                    <div class="con_div2">${user.amount}</div>
                    <div class="con_div3">
                        <span class="con_div_s3">¥</span>
                        <span class="con_div_s2">${user.price}</span>
                    </div>
                    <div class="con_div5">
                        <span class="con_div_s5">¥</span>
                        <span class="con_div_s6"></span>
                    </div>
                    <a href="/Car?demo=10&&idd=${user.id}">删除</a>
                </div>

            </c:forEach>
        </div>
    </div>
</div>
<script>
    let gets = document.getElementsByClassName("con_div_s2");
    let amounts = document.getElementsByClassName("con_div2");
    let sum = document.getElementsByClassName("con_div_s6");
    for (let i = 0; i < gets.length; i++) {
        console.log(parseInt(gets[i].innerHTML))
        console.log(parseInt(amounts[i].innerHTML))
        console.log(parseInt(gets[i].innerHTML) * parseInt(amounts[i].innerHTML))
        document.getElementsByClassName("con_div_s6")[i].innerHTML = parseInt(gets[i].innerHTML) * parseInt(amounts[i].innerHTML);
    }

</script>
</body>

</html>

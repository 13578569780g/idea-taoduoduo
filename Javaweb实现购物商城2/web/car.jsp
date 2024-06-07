<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" href="./Style/car.css">
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
                <span style="margin-left: 150px;">金额</span>
                <span style="margin-left: 168px;">操作</span>
            </div>
            <c:forEach items="${Arraylist}" var="user">
                <div class="con_div">
                    <div class="con_div_div1"> <img src="${user.img}" alt="" class="con_div_img"></div>
                    <div class="con_div_div2">${user.name}</div>
                    <div class="con_div2">
                        <a href="/carjian?id=${user.id}&amount=${user.amount}" class="con_div2_a1">-</a>
                        <span class="con_div2_in1">${user.amount}</span>
                        <a href="/carjia?id=${user.id}&amount=${user.amount}" class="con_div2_a2">+</a>
                    </div>
                    <div style="width: 123px;display: inline-block;margin-left: 85px;">
                        <span class="con_div_s3">¥</span>
                        <span class="con_div_s2">${user.price}</span>
                    </div>

                    <a href="/delcar?id=${user.id}" class="con_div_a1">移除</a>
                </div>

            </c:forEach>
            <div class="con_end">
                <span class="con_end_s1">合计: </span>
                <em class="con_end_em">0.00</em>
                <a href="/Car?demo=5" class="con_end_a1">结算</a>
            </div>

        </div>
    </div>

</div>
<script>
    let gets = document.getElementsByClassName("con_div_s2");
    let amounts = document.getElementsByClassName("con_div2_in1");
    let sum = 0;
    for (let i = 0; i < gets.length; i++) {
        sum += parseInt(gets[i].innerHTML) * parseInt(amounts[i].innerHTML);
    }

    document.getElementsByClassName("con_end_em")[0].innerHTML = sum;



</script>
</body>

</html>

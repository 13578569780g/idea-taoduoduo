<%--
  Created by IntelliJ IDEA.
  User: 16957
  Date: 2022/12/26
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/Style/register.css">
<html>
<head>
    <title>注册页面</title>
</head>
<body class="divv">
<div class="div1">
    <div class="div2">
        <form action="user.let?type=register" method="post">
            <span class="s1">账号: </span>
            <input type="text" name="name" class="in1">
            <span class="s2">密码: </span>
            <input type="password" name="pwd" class="in2">
            <input type="submit" value="注册" class="in3">
            <!-- <a href="login.html" class="a1">登录</a> -->
        </form>

    </div>
</div>

</body>
</html>

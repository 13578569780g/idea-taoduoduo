<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="Style/myInfor.css">
</head>
<body>
<div class="container">
    <h1>个人中心</h1>
<c:forEach items="${Arraylist}" var="arr">

    <img src="${arr.imgs}" alt="头像" class="avatar">
    <form action="/MyInfor?id=2" method="post" enctype="multipart/form-data">
        <input type="text" style="display: none" name="id1" value="${arr.id}">
        <input type="text" style="display: none" name="img1" value="${arr.imgs}">
        <div class="file-upload-wrapper">
            <input type="file" class="file-upload-input" id="avatar-upload" name="newimg">
            <button class="file-upload-button">重新上传头像</button>
        </div>
        <label for="username">用户名</label>
        <input type="text" id="username" name="newname" value="${arr.name}">

        <label for="password">密码</label>
        <input type="text" id="password" name="newpwd" value="${arr.pwd}">

        <label for="contact">联系方式</label>
        <input type="tel" id="contact" name="newphone" value="${arr.phone}">

        <label for="address">收货地址</label>
        <textarea id="address" name="newaddress">${arr.address}</textarea>

        <input type="submit" value="保存信息">
    </form>
</c:forEach>
</div>

<script>
    // const container = document.querySelector('.container');
    // container.style.animationName = 'slideInDown';
    const fileUpload = document.getElementById('avatar-upload');
    const fileUploadButton = document.querySelector('.file-upload-button');

    fileUpload.addEventListener('change', function () {
        const files = fileUpload.files;
        if (files.length > 0) {
            fileUploadButton.textContent = files[0].name;
        }
    });
</script>
</body>
</html>

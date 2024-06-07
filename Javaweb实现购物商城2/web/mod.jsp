<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link rel="stylesheet" href="/Style/mod.css">
</head>
<body>

<div class="divv">
    <form action="/ModSubmit" method="post" enctype="multipart/form-data">
        <input style="display: none" type="text" name="type" value="mod2">
        <input style="display: none" type="text" name="mod" value="${id1}">
        <input type="text" value="${img1}" name="oldimg" style="display: none">
        <div class="con1">
            <img src="${img1}" alt="" name="oldimgs" style="width: 380px;height: 380px">
        </div>

        <div class="con2">
            <input type="text" name="name" value="${name1}" class="con2_p1">
            <input type="text" name="price" value="${price1}" class="con2_p2">
            <textarea name="introduce" cols="30" rows="10" >${introduce1}</textarea>
            <div class="form-group">
                <label for="category">商品分类:</label>
                <select id="category" name="category">
                    <option value="3">美妆</option>
                    <option value="6">食品</option>
                    <option value="5">电器</option>
                    <option value="8">服装</option>
                </select>
            </div>
            <div class="file-upload-wrapper">
                <input type="file" class="file-upload-input" id="avatar-upload" name="newimg">
                <button class="file-upload-button">重新上传图片</button>
            </div>
<%--            <input type="file" value="选择照片" name="newimg" style="margin-top: 10px;margin-bottom: 10px;">--%>
            <input type="submit" value="修改" class="con2_a1">
            <a href="/index" class="con2_a2">返回</a>
        </div>
    </form>

</div>

<script>
    const fileUpload = document.getElementById('avatar-upload');
    const fileUploadButton = document.querySelector('.file-upload-button');
</script>

</body>
</html>











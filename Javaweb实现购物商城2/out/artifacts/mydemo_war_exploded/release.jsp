<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>发布商品</title>
    <link rel="stylesheet" href="./Style/release.css">
</head>

<body>

<div class="head">
    <a href="/index" class="head_a1">首页</a>
    <a href="login.html" class="head_a1">安全退出</a>
</div>
<div class="container">
    <h1>发布商品信息</h1>

    <form action="release" enctype="multipart/form-data" method="post">
        <div class="form-group">
            <label for="name">商品名称:</label>
            <input type="text" name="name" placeholder="请输入商品名称">
        </div>

        <div class="form-group">
            <label for="price">商品价格:</label>
            <input type="text" name="price" placeholder="请输入商品价格">
        </div>

        <div class="form-group">
            <label for="description">商品介绍:</label>
            <textarea id="description" name="introduce" placeholder="请输入商品介绍"></textarea>
        </div>

        <div class="form-group">
            <label for="category">商品分类:</label>
            <select id="category" name="category">
                <option value="3">美妆</option>
                <option value="6">零食</option>
                <option value="5">电器</option>
                <option value="8">服装</option>
            </select>
        </div>

        <div class="form-group">
            <label for="image">上传商品图片:</label>
            <input type="file" id="image" name="myimg">
        </div>

        <button type="submit" class="submit-button">发布</button>
    </form>


</div>



</body>

</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="./Style/index.css">
    <html>

    <head>
      <title>商家主页面</title>
    </head>

    <body style="background-color: #f5f5f5;">

      <div class="head">
        <a href="release.jsp">发布商品</a>
        <a href="login.html" style="margin-right: 80px">安全退出</a>
      </div>

      <form action="/FindCommodity?id=1" method="post" class="head_sea1">
        <input type="text" name="text1" class="head_sea1_in1">
        <input type="submit" value="搜索" class="head_sea1_in2">
      </form>

      <div class="con1">

        <img src="/imgs/yingye.jpg" alt="" class="head_sea1_img1">
        <img src="/imgs/yingye.jpg" alt="" class="head_sea1_img2">
        <table class="tab1">
          <tr class="tr1">
            <td class="tr1_td"></td>
            <td class="tr1_td1">商品名称</td>
            <td class="tr1_td2">价格</td>
            <td class="tr1_td3">商品简介</td>
          </tr>
          <c:forEach items="${Arraylist}" var="user">
            <tr class="tr1">
              <td class="td1"><img src="${user.img}" alt="" style="width: 168px;height: 97px"></td>
              <td class="td2"><span>${user.name}</span></td>
              <td class="td3"><span>${user.price}</span></td>
              <td class="td4"><span>${user.introduce}</span></td>

              <td class="td5"><a href="/index?id=${user.id}" onclick="return confirmRemoval()">下架</a></td>
              <td class="td5"><a href="/indexmod?type=mod1&mod=${user.id}">修改</a></td>

            </tr>
          </c:forEach>

        </table>


      </div>

      <script>
        function confirmRemoval() {
          var confirmed = confirm("确定要下架该商品吗？");
          if (confirmed) {
            alert("下架成功！");
          }
          return confirmed;
        }
      </script>
    </body>

    </html>
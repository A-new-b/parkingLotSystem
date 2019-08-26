<%--
  Created by IntelliJ IDEA.
  User: jue
  Date: 19-8-26
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="login.css" type="text/css">
</head>
<script>
</script>
<body>
<div >
    <form action="/parkingLotSystem/registerServlet" method="post" class="backgroud">
        <h1>表单</h1>
        <div class="input">
            <p>帐号：</p>
            <input type="text" name="username" placeholder="请输入你的帐号" />
        </div>
        <div class="input">
            <p>密码：</p>
            <input type="text" name="password" placeholder="请输入你的密码" />
        </div>
        <div class="input">
            <p>姓名：</p>
            <input type="text" name="name" placeholder="请输入你的姓名" />
        </div>
        <div class="input">
            <p>性别：</p>
            <input type="text" name="sex" placeholder="请输入你的性别" />
        </div>
        <div class="input">
            <p>电话：</p>
            <input type="text" name="phone" placeholder="请输入你的电话" />
        </div>
        <button type="submit" >注册</button>
        <strong>${register_msg}</strong>
    </form>

</div>

</body>
</html>

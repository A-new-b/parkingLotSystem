<%--
  Created by IntelliJ IDEA.
  Service: jue
  Date: 19-7-24
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="login.css" type="text/css">
</head>
<script>
</script>
<body>
<div >
    <form action="/parkingLotSystem/login" method="post" class="backgroud">
    <h1>停车场管理系统</h1>
    <div class="input">
        <p>帐号：</p>
        <input type="text" name="username" placeholder="请输入你的帐号" />
    </div>
    <div class="input">
        <p>密码：</p>
        <input type="text" name="password" placeholder="请输入你的密码" />
    </div>
    <button type="submit" >登录</button>
        <a href="${pageContext.request.contextPath}/register.jsp">注册 </a>
        <strong>${login_msg}</strong>
    </form>


</div>

</body>
</html>

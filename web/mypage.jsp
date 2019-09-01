<%--
  Created by IntelliJ IDEA.
  User: jue
  Date: 19-8-26
  Time: 下午12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的主页</title>
    <link rel="stylesheet" href="my_page.css" type="text/css">
    <script src="nomalFunction.js"></script>
    <link rel="stylesheet" type="text/css" href="./vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="backgrousrud">
    <div class="headline">
        <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" href="${pageContext.request.contextPath}/mypageServlet">我的主页</a>
<%--        <div style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" onclick="tooccupy()">停车位查看</div>--%>
        <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" href="${pageContext.request.contextPath}/occupyServlet">停车位查看</a>
    </div>
    <div class="body">
    <c:choose>
        <c:when test="${sessionScope.login}">
            <div class="row">
                <div class="col-lg" style="width: 300px">姓名：${sessionScope.resultUser.name}</div>
                <div class="col-lg">电话号码：${sessionScope.resultUser.phone}</div>
                <div class="col-lg">性别：${sessionScope.resultUser.sex}</div>
            </div>
            <div>
                <h3>收费标准：每6分钟一元</h3>
            </div>
            <c:if test="${requestScope.haveCar}">
                <table border="1" class="table">
                    <tr>
                        <th>车牌号</th>
                        <th>品牌</th>
                        <th>入库时间</th>
                        <th>备注</th>
                        <th>位置</th>
<%--                        <th>收费</th>--%>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.cars}" var="car" varStatus="s">
                        <tr>
                            <td>${car.car_number}</td>
                            <td>${car.car_brand}</td>
                            <td>${car.car_intime}</td>
                            <td>${car.car_info}</td>
                            <td>${car.car_position}</td>
                            <td><a href="${pageContext.request.contextPath}/exitServlet?number=${car.car_number}">离开</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </c:when>
        <c:otherwise>
            <h1>请先登录</h1>
        </c:otherwise>
    </c:choose>


    </div>
</div>
</body>
</html>


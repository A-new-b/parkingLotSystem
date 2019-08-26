<%--
  Created by IntelliJ IDEA.
  User: jue
  Date: 19-8-26
  Time: 下午2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看停车位</title>
    <link rel="stylesheet" href="my_page.css" type="text/css">
    <script src="nomalFunction.js"></script>
</head>
<body>
<div class="backgrousrud">
    <div class="headline">
        <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" href="${pageContext.request.contextPath}/mypageServlet">我的主页</a>
        <%--        <div style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" onclick="tooccupy()">停车位查看</div>--%>
        <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" href="${pageContext.request.contextPath}/occupyServlet">停车位查看</a>
    </div>
    <div class="body">
        <h1>${requestScope.post_msg}</h1>
        <c:choose>
            <c:when test="${sessionScope.login}">
                <c:if test="${requestScope.haveSeats}">
                    <table border="1">
                        <tr>
                            <th>位置</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.seats}" var="seat" varStatus="s">
                            <tr>
                                <td>${seat.position}</td>
                                <td><a href="${pageContext.request.contextPath}/seatServlet?position=${seat.position}">预约</a></td>
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

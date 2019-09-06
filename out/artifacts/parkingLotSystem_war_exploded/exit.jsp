<%--
  Created by IntelliJ IDEA.
  User: jue
  Date: 19-8-26
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <link rel="stylesheet" href="my_page.css" type="text/css">
    <script src="nomalFunction.js"></script>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="headline">
    <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer"
       href="${pageContext.request.contextPath}/mypageServlet">我的主页</a>
    <%--        <div style="color: white;font-size: 36px;margin-left:2%;cursor: pointer" onclick="tooccupy()">停车位查看</div>--%>
    <a style="color: white;font-size: 36px;margin-left:2%;cursor: pointer"
       href="${pageContext.request.contextPath}/occupyServlet">停车位查看</a>
</div>
<div style="margin-top: 30px">
    <img src="./images/greentick.png" alt="green_tick" style="width: 150px; display: block;margin: auto"/>
    <div style="text-align: center">
        <h3>离开成功</h3>
        <table class="table" >
            <tr>
                <th>车牌号</th>
                <th>品牌</th>
                <th>备注</th>
                <th>入库时间</th>
                <th>占有车位</th>
                <th>所花钱</th>
                <th>已停时间</th>
            </tr>
            <tr>
                <th>${requestScope.car.car_number}</th>
                <th>${requestScope.car.car_brand}</th>
                <th>${requestScope.car.car_info}</th>
                <th>${requestScope.car.car_intime}</th>
                <th>${requestScope.car.car_position}</th>
                <th>${requestScope.money/(60*6)}</th>
                <th>${requestScope.min}分${requestScope.money%60}秒</th>
            </tr>
        </table>
    </div>
<%--    <h1>离开成功</h1>--%>
<%--    <h1>车牌号：${requestScope.car.car_number}</h1>--%>
<%--    <h1>品牌：${requestScope.car.car_brand}</h1>--%>
<%--    <h1>备注${requestScope.car.car_info}</h1>--%>
<%--    <h1>入库时间${requestScope.car.car_intime}</h1>--%>
<%--    <h1>车位：${requestScope.car.car_position}</h1>--%>
<%--    <h1>所花钱：${requestScope.money}</h1>--%>
</div>
</body>
</html>

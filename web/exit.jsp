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
</head>
<body>
<div>
    <h1>离开成功</h1>
    <h1>车牌号：${requestScope.car.car_number}</h1>
    <h1>品牌：${requestScope.car.car_brand}</h1>
    <h1>备注${requestScope.car.car_info}</h1>
    <h1>入库时间${requestScope.car.car_intime}</h1>
    <h1>车位：${requestScope.car.car_position}</h1>
    <h1>所花钱：${requestScope.money}</h1>
</div>
</body>
</html>

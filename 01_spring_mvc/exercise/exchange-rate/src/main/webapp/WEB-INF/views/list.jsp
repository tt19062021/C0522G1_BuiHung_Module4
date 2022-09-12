<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 09/09/2022
  Time: 4:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ExChange USA to VNĐ</h1>
<form action="/convert" method="get">
    <input name="usd" type="text" placeholder="input USA...">
    <button type="submit">EXCHANGE</button>
</form>
<h2>Result : ${exchange} VNĐ</h2>
</body>
</html>

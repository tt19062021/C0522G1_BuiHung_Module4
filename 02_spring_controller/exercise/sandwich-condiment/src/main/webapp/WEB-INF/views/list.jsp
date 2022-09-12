<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/09/2022
  Time: 11:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chose Sandwich Condiment</title>
</head>
<body>
<h1>Chose Sandwich Condiment</h1>

<form action="/save" method="get">
    <input id="Lettuce" value="Lettuce" type="checkbox" name="condiment">
    <label for="Lettuce" >Lettuce</label>

    <input id="Tomato" value="Tomato" type="checkbox" name="condiment">
    <label for="Tomato">Tomato</label>

    <input id="Mustard" value="Mustard" type="checkbox" name="condiment">
    <label for="Mustard">Mustard</label>

    <input id="Sprouts" value="Sprouts" type="checkbox" name="condiment">
    <label for="Sprouts">Sprouts</label>
    <hr>
    <button type="submit" >Save</button>
</form>

    <label>You chose: </label>
    <c:forEach items="${condiment}" var="chose">
        <p>${chose}</p>
    </c:forEach>
</body>
</html>

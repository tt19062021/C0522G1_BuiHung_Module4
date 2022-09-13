<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13/09/2022
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<h4>Setting Email</h4>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${configEmails}" var="email">
        <tr>
            <td>${email.id}</td>
            <td><a href="/email/update?id=${email.id}">${email.language}</a></td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h5>${mess}</h5>
</body>
</html>

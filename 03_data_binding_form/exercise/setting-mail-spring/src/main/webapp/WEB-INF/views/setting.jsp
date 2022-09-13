<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13/09/2022
  Time: 11:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h3>Setting</h3>

<form:form action="/email/save" method="post" modelAttribute="configEmail">
    <fieldset style="width: 300px; height: 150px">
        <table class="table">
            <tr>
                <td>
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td><b>Language</b></td>
                <td>
                    <form:select path="language" items="${languageList}" multiple="false"/>
                </td>
            </tr>
            <tr>
                <td><b>Page size:</b></td>
                <td>
                    Show <form:select path="pageSize" items="${pageSizeList}" multiple="false"/>email per page
                </td>
            </tr>
            <tr>
                <td>Spam fillter</td>
                <td>
                    <form:checkbox path="spamsFilter" value="spamsFilter"/>
                    Enable spams fillter
                </td>
            </tr>
            <tr>
                <td>Sinature</td>
                <td>
                    <form:textarea path="signature" title="dsadas"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Update</button>
                </td>
                <td colspan="2">
                    <button type="submit">Cancel</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>

</body>
</html>

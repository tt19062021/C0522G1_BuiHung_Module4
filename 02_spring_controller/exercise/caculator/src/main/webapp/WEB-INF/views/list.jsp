<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/09/2022
  Time: 2:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="get" action="/operator">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand: </td>
                <td><input name="firstOperand" type="text"/></td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td>
                    <select name="operator">
                        <option value="Addition" nam>Addition</option>
                        <option value="Subtraction">Subtraction</option>
                        <option value="Multiplication">Multiplication</option>
                        <option value="Division">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operand: </td>
                <td><input name="secondOperand" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<h2>Result ${operator} : ${result}</h2>
<%--<h3>${firstOperand} ${operator} ${secondOperand} = ${result}</h3>--%>
</body>
</html>

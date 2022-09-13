<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13/09/2022
  Time: 9:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Tờ khai y tế</h1><br>

<p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM</p>

<p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

<form:form action="/save" modelAttribute="declaration" method="post">
    <b>Họ và tên(ghi chữ IN HOA)</b><br>
    <form:input size="100%" path="name"/>

    <table style="width: 100%">
        <tr>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tịch</td>
        </tr>
        <tr>
            <td>
                <form:select cssStyle="width: 33%" path="yearOfBirth" items="${yearOfBirth}"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="gender" items="${gender}"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="nationality" items="${nationality}"/>
            </td>
        </tr>
    </table>

    <b>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</b><br>
    <form:input size="100%" path="identityCard"/><br>

    <b>Thông tin đi lại</b><br>
    <form:radiobuttons path="travelInformation" items="${travel}"/>

    <table style="width: 100%">
        <tr>
            <td><b>Số hiệu phương tiện</b></td>
            <td>Số ghế</td>
        </tr>
        <td>
            <form:input cssStyle="width: 50%" path="vehicleNumber"/>
        </td>
        <td>
            <form:input cssStyle="width: 50%" path="seats"/>
        </td>
    </table>

    <table style="width: 100%">
        <tr>
            <td colspan="3">Ngày khởi hành:</td>
            <td colspan="3">Ngày kết thúc:</td>
        </tr>

        <td>
            <form:select cssStyle="width: 33%" path="departureDay" items="${day}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="departureMonth" items="${month}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="departureYear" items="${year}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endDay" items="${days}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endMonth" items="${months}"/>
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endYear" items="${years}"/>
        </td>
    </table>
    <table>
        <tr>
            <td><b>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</b></td>
        </tr>
        <tr>
            <td><form:textarea size="100%" path="note"/></td>
        </tr>

    </table>
    <b style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo
        quốc gia về Phòng chống dịch Covid-19.</b><br>
    <b style="color: red">Khi bạn nhấn nút"Gửi" là bạn đã hiểu và đồng ý</b><br>

    <h4 style="text-align: center"><button type="submit" >Gửi tờ khai</button></h4>
</form:form>
</body>
</html>

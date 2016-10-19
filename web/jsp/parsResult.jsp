<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Диана и Глеб
  Date: 28.06.2016
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Result</title>
</head>
<body>
    <div class="container ">
    <div class="row">
    <div class="col-sm-8 col-sm-offset-2">
        <h2 class="form-signin-heading text-capitalize text-center">Have a good trip :)    ${parserName} parser</h2>
<%--    <div>
        <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="/controller">Log out</a></li>
        </ul>
    </div>--%>
    <div class="col-md-6">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Country</th>
            <th>Days</th>
            <th>Transport</th>
            <th>Stars</th>
            <th>Meal</th>
            <th>Rooms</th>
            <th>Condition</th>
            <th>TV</th>
            <th>WIFI</th>
            <th>Cost</th>
        </tr>
        </thead>
        <c:forEach var="voucher" items="${vouchers}">
            <tbody>
            <tr>
                <td><c:out value="${ voucher.id}" /></td>
                <td><c:out value="${ voucher.name}" /></td>
                <td><c:out value="${ voucher.type }" /></td>
                <td><c:out value="${ voucher.country}" /></td>
                <td><c:out value="${ voucher.numberDaysNights}" /></td>
                <td><c:out value="${ voucher.transport}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.stars}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.kindOfMeal}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.rooms}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.condition}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.tv}" /></td>
                <td><c:out value="${ voucher.hotelCharacs.wifi}" /></td>
                <td><c:out value="${ voucher.cost}" /></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

    <form name="back" method="POST" action="controller">
    <input type="hidden" name="command" value="back"/>
    <input class="btn btn-primary" type="submit" value="Back"/>
    </form>
    <form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input class="btn btn-default" type="submit" value="Logout"/>
    </form>
    </div>
    </div>
    </div>
    </div>
</body>
</html>

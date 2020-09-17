<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 16.09.2020
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Painters offers</title>
</head>
<body>
<table>
    <caption>Painters offers</caption>
    <thead>
    <th scope="col">id</th>
    <th scope="col">rfq</th>
    <th scope="col">leadTime</th>
    <th scope="col">wagon</th>
    <th scope="col">designer</th>
    <th scope="col">technologist</th>
    <th scope="col">buyer</th>
    </thead>
    <c:forEach items="${offersList}" var="offerList">
    <tr>
        <td>${offerList.id}</td>
        <td>${offerList.rfq}</td>
        <td>${offerList.leadTime}</td>
        <td>${offerList.wagon.type}</td>
        <td>${offerList.technologist.email}</td>
        <td>${offerList.buyer.email}</td>
        <td>${offerList.designer.email}</td>
        </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/resources/all.css" var="allcss" />
<link href="${allcss}" rel="stylesheet" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wagons list</title>
</head>
<body>
<table>
    <caption>Wagons list</caption>
    <thead>
    <th scope="col">id</th>
    <th scope="col">type</th>
    </thead>
    <c:forEach items="${wagons}" var="wagon">
    <tr>
        <td>${wagon.id}</td>
        <td>${wagon.type}</td>
        <td>
            <a href="<c:url value="/wagon/${wagon.id}/offer"/>">all wagons offer</a>

        </td>
        </c:forEach>
</table>
</body>
</html>

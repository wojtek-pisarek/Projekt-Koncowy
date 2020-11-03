<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wagons list</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/wagons.jsp" %>
<style> tr,th,td { border: 1px solid black;
    padding: 5px;
    text-align: center     ;
}
</style>
<table>
<table>
    <thead>
    <th scope="col">id</th>
    <th scope="col">type</th>
    </thead>
    <c:forEach items="${wagons}" var="wagon">
    <tr>
        <td>${wagon.id}</td>
        <td>${wagon.type}</td>
        <td>
            <a href="<c:url value="/wagon/${wagon.id}/offer"/>">All Wagons Offer</a>
            <a href="<c:url value="/wagon/delete?id=${wagon.id}"/>">Delete Wagon</a>
            <a href="<c:url value="/wagon/update?id=${wagon.id}"/>">Update Wagon</a>
        </td>
        </c:forEach>
</table>
</body>
</html>

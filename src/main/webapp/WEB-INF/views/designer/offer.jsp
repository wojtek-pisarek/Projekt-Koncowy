<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 13.09.2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/designers.jsp" %>
<style> tr, td, th,table {
    border: 1px solid black;
    padding: 5px;
    text-align: center;
}
</style>
<table>
    <caption>Designers offers</caption>
    <thead>
    <th scope="col">id</th>
    <th scope="col">rfq</th>
    <th scope="col">leadTime</th>
    <th scope="col">wagon</th>

    <th scope="col">technologist</th>
    <th scope="col">technologistPainter</th>
    <th scope="col">specialistBuyer</th>
    </thead>
    <c:forEach items="${offersList}" var="offerList">
    <tr>
        <td>${offerList.id}</td>
        <td>${offerList.rfq}</td>
        <td>${offerList.leadTime}</td>
        <td>${offerList.wagon.type}</td>
        <td>${offerList.technologist.email}</td>
        <td>${offerList.painter.email}</td>
        <td>${offerList.buyer.email}</td>
        </c:forEach>
</table>
</body>
</html>

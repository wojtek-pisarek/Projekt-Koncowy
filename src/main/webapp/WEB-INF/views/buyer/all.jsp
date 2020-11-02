<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Buyers all</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/buyers.jsp" %>
<style> tr,th,td { border: 1px solid black;
padding: 5px;
text-align: center     ;
}
</style>
<table>
    <thead>
    <th scope="col">id</th>
    <th scope="col">name</th>
    <th scope="col">surname</th>
    <th scope="col">email</th>
    <th scope="col">phoneNumber</th>
    </thead>
    <c:forEach items="${buyers}" var="buyer">
    <tr>
        <td>${buyer.id}</td>
        <td>${buyer.name}</td>
        <td>${buyer.surname}</td>
        <td>${buyer.email}</td>
        <td>${buyer.phoneNumber}</td>

<td>
    <a href="<c:url value="/buyer/delete?id=${buyer.id}"/>">Delete Buyer</a>
    <a href="<c:url value="/buyer/update?id=${buyer.id}"/>">Update Buyer</a>
    <a href="<c:url value="/buyer/${buyer.id}/offer"/>">All Buyers Offer</a>
</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

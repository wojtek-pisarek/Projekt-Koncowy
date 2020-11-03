<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/designers.jsp" %>
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
    <c:forEach items="${designers}" var="designer">
    <tr>
        <td>${designer.id}</td>
        <td>${designer.name}</td>
        <td>${designer.surname}</td>
        <td>${designer.email}</td>
        <td>${designer.phoneNumber}</td>
        <td>
            <a href="<c:url value="/designer/delete?id=${designer.id}"/>">Delete Designer</a>
            <a href="<c:url value="/designer/update?id=${designer.id}"/>">Update Designer</a>
            <a href="<c:url value="/designer/${designer.id}/offer"/>">all designer offer</a>
        </td>
        </c:forEach>
</table>
</body>
</html>

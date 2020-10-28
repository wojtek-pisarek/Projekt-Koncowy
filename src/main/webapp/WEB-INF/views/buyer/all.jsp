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
<%@include file="/WEB-INF/views/fragments/header.jsp" %>
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


    <td>
        <p></p>
        <a href="<c:url value="/buyer/add"/>">Add Buyer</a>
    </td>

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                    integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                    crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                    crossorigin="anonymous"></script>
</body>
</html>

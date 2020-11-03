<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 03.11.2020
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update wagon</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/wagons.jsp" %>
<style> tr, td, table {
    border: 1px solid black;
    padding: 5px;
    text-align: right;
}
</style>
<form:form method="post" modelAttribute="wagon">
    <table>
        <tr>
            <td><form:label path="type">name:<form:input path="type"/></form:label></td>
            <form:errors path="type"/>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
</html>

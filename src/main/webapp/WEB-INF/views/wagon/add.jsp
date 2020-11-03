<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 13.09.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wagon add</title>
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
        <td><form:label path="type">type:<form:input path="type"/></form:label></td>
        <form:errors path="type"/>
    </table>
    <input type="submit">
</form:form>
</body>
</html>

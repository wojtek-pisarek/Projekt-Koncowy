<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 25.10.2020
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="/app">
            <span>Pulpit</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/app/recipe/list/">
            <span>Przepisy</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/app/plan/list">
            <span>Plany</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/app/user/edit">
            <span>Edytuj dane</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="/app/change-password">
            <span>Zmień hasło</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <c:if test="${admin.superadmin==1}">
        <li class="nav-item">
            <a class="nav-link" href="/app/super-admin-users">
                <span>Użytkownicy</span>
                <i class="fas fa-angle-right"></i>
            </a>
        </li>
    </c:if>
</ul>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Bleard
  Date: 8/11/2020
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui borderless blue inverted pointing menu">
    <div class="ui container">
        <a class="header active item" href="${pageContext.request.contextPath}/">Home</a>
        <a class="item" href="${pageContext.request.contextPath}/category/">Categories</a>
        <a class="item" href="#root">Press</a>
        <div class="right menu">
            <security:authorize access="!isAuthenticated()">
                <a class="item" href="${pageContext.request.contextPath}/login">Login!</a>
                <a class="item" href="${pageContext.request.contextPath}/register">Register!</a>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
                <a class="item" href="${pageContext.request.contextPath}/addTerm">Add!</a>
                <a class="item" href="${pageContext.request.contextPath}/manageTerms">Terms!</a>
                <a class="item" href="${pageContext.request.contextPath}/logout">LogOut!</a>
            </security:authorize>
        </div>
    </div>
</div>

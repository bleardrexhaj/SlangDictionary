<%--
  Created by IntelliJ IDEA.
  User: Bleard
  Date: 8/10/2020
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>
<body id="root">
<jsp:include page="menu.jsp"/>
<div class="ui content container">
    <spring:form class="ui form" modelAttribute="user" action="/register" method="post">

        <spring:errors cssClass="ui red basic label" path="*"/>

        <div class="field">
            <spring:label path="firstName">First Name</spring:label>
            <spring:input type="text" name="first-name" placeholder="First Name" path="firstName"/>
        </div>

        <div class="field">
            <spring:label path="lastName">Last Name</spring:label>
            <spring:input type="text" name="last-name" placeholder="Last Name" path="lastName"/>
        </div>

        <div class="field">
            <spring:label path="email">Email</spring:label>
            <spring:input type="text" name="email" placeholder="Email" path="email"/>
        </div>

        <div class="field">
            <spring:label path="singleAddress.street">Street</spring:label>
            <spring:input type="text" name="Street" placeholder="Street" path="singleAddress.street"/>
        </div>

        <div class="field">
            <spring:label path="singleAddress.city">City</spring:label>
            <spring:input type="text" name="City" placeholder="City" path="singleAddress.city"/>
        </div>

        <div class="field">
            <spring:label path="singleAddress.country">Country</spring:label>
            <spring:input type="text" name="Country" placeholder="Country" path="singleAddress.country"/>
        </div>

        <div class="field">
            <spring:label path="singleAddress.zipCode">Zip</spring:label>
            <spring:input type="number" name="Zip" placeholder="Zip" path="singleAddress.zipCode"/>
        </div>

        <div class="field">
            <spring:label path="userCredentials.password">Password</spring:label>
            <spring:input type="text" name="password" placeholder="Password" path="userCredentials.password"/>
        </div>

        <div class="field">
            <spring:label path="userCredentials.verifyPassword">Confirm Password</spring:label>
            <spring:input type="text" name="verifyPassword" placeholder="Password" path="userCredentials.verifyPassword"/>
        </div>

        <spring:button class="ui button" type="submit">Submit</spring:button>
    </spring:form>
</div>
<footer class="ui secondary segment">
    <div class="ui center aligned container">
        <p>
            Slang Dictionary @2020 All rights reserved.
        </p>
        <a href="#root">Back to top</a>
    </div>
</footer>
</body>
</html>

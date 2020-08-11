<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
    <title>Register</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="semantic/dist/semantic.min.js"></script>
</head>
<body>
<spring:form class="ui form" modelAttribute="user" action="/register" method="post">

    <spring:errors cssClass="ui-state-error" path="*"/>
    <div class="field">
        <spring:label path="firstName">First Name</spring:label>
        <spring:input type="text" name="first-name" placeholder="First Name" path="firstName"/>
    </div>
    <div class="field">
        <spring:label path="lastName">First Name</spring:label>
        <spring:input type="text" name="last-name" placeholder="First Name" path="lastName"/>
    </div>
    <div class="field">
        <div class="ui checkbox">
            <input type="checkbox" tabindex="0" class="hidden">
            <label>I agree to the Terms and Conditions</label>
        </div>
    </div>
    <spring:button class="ui button" type="submit">Submit</spring:button>
</spring:form>
</body>
</html>

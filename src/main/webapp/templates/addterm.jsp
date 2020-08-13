<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 8/12/20
  Time: 11:24
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
    <spring:form class="ui form" modelAttribute="term" action="/register" method="post">

        <spring:errors cssClass="ui red basic label" path="*"/>

        <div class="field">
            <spring:label path="word">Term</spring:label>
            <spring:input type="text" name="word" placeholder="Term" path="word"/>
        </div>

        <div class="field">
            <spring:label path="definition">Definition</spring:label>
            <spring:textarea type="text" name="definition" placeholder="Definition" path="definition"/>
        </div>

        <div class="field">
            <spring:label path="example">Example</spring:label>
            <spring:input type="text" name="example" placeholder="Example" path="example"/>
        </div>

        <div class="field">
            <spring:label path="author">author</spring:label>
            <spring:input type="text" name="author" placeholder="author" path="author"/>
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

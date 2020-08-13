<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 8/12/20
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>
<body id="root">
<jsp:include page="menu.jsp"/>

<div class="ui content container">
    <spring:form class="ui form" modelAttribute="term" action="/term/addTerm" method="POST">

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
            <spring:textarea type="text" name="example" placeholder="Example" path="example"/>
        </div>

<%--        <spring:select path="category">--%>
<%--            <c:forEach var="cat" items="${categoryList}">--%>
<%--                <spring:option value="${cat}" label="${cat}" />--%>
<%--            </c:forEach>--%>
<%--        </spring:select>--%>

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

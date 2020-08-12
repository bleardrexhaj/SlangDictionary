<%--
  Created by IntelliJ IDEA.
  User: Erdenesaikhan
  Date: 8/11/2020
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>
<body id="root">
<jsp:include page="menu.jsp"/>
<div class="ui grid stackable container">
    <div class="row" id="page-header">
        <div class="ui basic segment">
            <h1 class="ui huge header">
                <div class="content">List of categories</div>
                <div class="sub header">
                    Search through words grouped by category.
                </div>
            </h1>
        </div>
    </div>
    <div class="row" id="article">
        <div class="eleven wide column">
            <c:forEach var="category" items="${categoryList}" varStatus="tagStatus">

                <a href="/category/list/{category}">
                    <h2 class="ui large header">
                        <div class="content">${category.name}</div>
                        <div class="sub header">
                                ${category.description}
                        </div>
                    </h2>
                </a>
                <div class="ui divider"></div>
            </c:forEach>
        </div>

        <div class="four wide right floated column">
            <div class="ui secondary segment">
                <h4 class="ui header">About</h4>
                <p>
                    Etiam porta <i>sem malesuada magna mollis euismod</i>. Cras mattis
                    consectetur purus sit amet fermentum. Aenean lacinia bibendum
                    nulla sed consectetur.
                </p>
            </div>
            <h4 class="ui header">Archives</h4>
            <div class="ui list">
                <a class="item">Septempber 2017</a> <a class="item">August 2017</a>
                <a class="item">June 2017</a> <a class="item">April 2017</a>
                <a class="item">March 2017</a> <a class="item">February 2017</a>
                <a class="item">January 2017</a> <a class="item">December 2016</a>
                <a class="item">October 2016</a> <a class="item">July 2016</a>
                <a class="item">July 2016</a> <a class="item">May 2016</a>
                <a class="item">April 2016</a> <a class="item">January 2016</a>
                <a class="item">May 2015</a>
            </div>
            <h4 class="ui header">Elsewhere</h4>
            <div class="ui list">
                <a class="item">GitHub</a> <a class="item">Twitter</a>
                <a class="item">Facebook</a>
            </div>
        </div>
    </div>
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


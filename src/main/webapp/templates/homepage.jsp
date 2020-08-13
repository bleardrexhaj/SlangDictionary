<%--
  Created by IntelliJ IDEA.
  User: Bleard
  Date: 8/10/2020
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
                <div class="content">Random Slang Words</div>
                <div class="sub header">
                    Search through thousands of slang words.
                </div>
            </h1>
        </div>
    </div>
<%--    <div class="ui grid" style="margin-top: 20px; margin-bottom: 20px;">--%>
<%--        <div class="ui input focus">--%>
<%--            <input type="text" placeholder="Search..." value="${word}">--%>
<%--        </div>--%>
<%--        <button class="ui primary button" onclick="location.href='/search/${word}'">Search</button>--%>
<%--    </div>--%>
    <spring:form class="ui grid" cssStyle="margin-bottom: 20px; margin-top: 20px;" modelAttribute="searchInput" action="/term/search${searchInput.input}" method="GET" >
        <div class="ui input focus">
            <spring:input type="text" name="word" placeholder="Search..." path="input"/>
        </div>
        <spring:button class="ui primary button" type="submit">Search</spring:button>
    </spring:form>

    <div class="row" id="article">
        <div class="eleven wide column">
            <c:forEach var="term" items="${termList}" varStatus="tagStatus">
                <div class="ui raised segment">
                    <h2 class="ui large header">
                        <div class="content"><i>${term.word}</i></div>
                        <div class="sub header" style="margin-top: 20px;">
                                ${term.definition}
                        </div>
                        <div class="ui divider"></div>
                        <div class="sub header" style="margin-bottom: 20px;">
                                ${term.example}
                        </div>
                    </h2>
                    <p>${term.written_on} by <a>${term.author}</a></p>

                    <div>
                        <a href="/thumbup/${term.word}"><img src="./../icons/thumb-up.png" style="width: 20px;" /><span style="margin-lef: 10px; margin-right: 30px;">${term.thumbs_up}</span></a>
                        <a href="/thumbdown/${term.word}"><img src="./../icons/thumb-down.png" style="width: 20px; padding-top: 5px;" /><span style="margin-lef: 10px; margin-right: 30px;">${term.thumbs_down}</span></a>
                    </div>
                </div>
            </c:forEach>

        </div>

        <div class="four wide right floated column">
            <div class="ui secondary segment">
                <h4 class="ui header">About</h4>
                <p>
                    Slang dictionary will be a project where users could simply browse new slang words every day. The web application ?SLANG DICTIONARY? will provide an easy and convenient way for users to register and add slang words, the normal guest users can simply browse through and read about the words they are interested in. Registration will require a valid Email address for identity verification, guests will be able to add comments and to vote regarding the words, Word publishers will be able to edit their slang added words.
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


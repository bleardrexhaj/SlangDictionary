<%--
  Created by IntelliJ IDEA.
  User: Bleard
  Date: 8/10/2020
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="https://semantic-ui.com/dist/semantic.min.css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="https://semantic-ui.com/dist/semantic.min.js"></script>
</head>
<body id="root">
<div class="ui borderless blue inverted pointing menu">
    <div class="ui container">
        <a class="header active item" href="#root">Home</a>
        <a class="item" href="#root">New feature</a>
        <a class="item" href="#root">Press</a>
        <a class="item" href="#root">New hires</a>
        <a class="item" href="#root">About</a>
    </div>
</div>
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
    <div class="row" id="article">
        <div class="eleven wide column">
            <h2 class="ui large header">
                <div class="content">Term #1</div>
                <div class="sub header">
                    March 6, 2017 by <a href="#root">Jack</a>
                </div>
            </h2>
            <div class="ui hidden divider"></div>
            <p>
                description
            </p>


            <%--<div class="ui secondary segment">
                <code>Example code block</code>
            </div>--%>


            <div class="ui hidden divider"></div>
            <h2 class="ui large header">
                <div class="content">Term #2</div>
                <div class="sub header">
                    April 1, 2027 by <a href="#root">Mac</a>
                </div>
            </h2>
            <div class="ui hidden divider"></div>
            <p>
                description
            </p>

            <div class="ui hidden divider"></div>
            <h2 class="ui large header">
                <div class="content">Term #3</div>
                <div class="sub header">
                    Autumn 13, 2019 by <a href="#root">Semantic</a>
                </div>
            </h2>
            <div class="ui hidden divider"></div>
            <p>
                description
            </p>

            <div class="ui hidden divider"></div>
            <div class="ui basic circular huge button">
                <a href="#root">Previous</a>
            </div>
            <div class="ui basic circular huge button">
                <a href="#root">Next</a>
            </div>
            <div class="ui hidden divider"></div>
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
</html>

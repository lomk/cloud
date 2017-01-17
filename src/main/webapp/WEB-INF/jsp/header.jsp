<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



   <div class="jumbotron">
        <div class="row text-center">
            <%--<img src="/images/1212.png" width="1000" height="100"/>--%>
            <div class="">
                <h3>Cloud</h3>
            </div>
        </div>
    </div>
    <div class="header">
        <div class="row text-center">
            <%--<img src="/images/1212.png" width="1000" height="100"/>--%>
        </div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Главная</a>
                    <ul class="nav navbar-nav">
                        <li><a href="/article/all">Топики</a></li>
                        <li><a href="/article/all">Темы</a></li>
                        <li><a href="/">FAQ</a></li>
                        <sec:authorize access="isAnonymous()">
                            <li><a href="/login">Login</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li> <a href="/logout">${user.username} Logout</a></li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>


    </div>


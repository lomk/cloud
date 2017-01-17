<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


    <div class="header">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <%--<a class="navbar-brand" href="/">Главная</a>--%>
                    <a class="navbar-brand" href="/admin">Admin</a>
                    <ul class="nav navbar-nav">
                        <li><a href="/admin/vm/all">Virtual machines</a></li>
                        <li><a href="/admin/hypervisor/all">Hypervisor nodes</a></li>
                        <li><a href="/admin/role/all">Roles</a></li>
                        <li><a href="/admin/user/all">Users</a></li>
                        <li><a href="/admin/ssh/run">Run command</a></li>
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


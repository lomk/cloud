<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>
<%@ include file="../../header.jsp"%>
<div class="container">
    <%--<div th:if="${not #lists.isEmpty(products)}">--%>
        <h2>Product List</h2>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>User Id</th>
                <th>User name</th>
                <th>View</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td text="${user.id}"><a href="/user/${user.id}">Id</a></td>
                        <td text="${user.id}">${user.id}</td>
                        <td text="${user.username}">${user.username}</td>
                        <td><a href="user/${user.id}">View</a></td>
                        <td><a href="user/edit/${user.id}">Edit</a></td>
                        <td><a href="user/delete/${user.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>

    </div>
<%--</div>--%>
</body>
</html>
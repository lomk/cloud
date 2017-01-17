<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>

<div class="container">
    <%@ include file="../header.jsp"%>
    <%--<div th:if="${not #lists.isEmpty(products)}">--%>
    <h2>Roles List</h2>
    <a href="new">Create new role</a>
    <table class="table table-striped">
        <tr>
            <th>Command</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:if test="${not empty roles}">
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td text="${role.name}">${role.name}</td>
                    <td><a href="admin/role/${role.id}">View</a></td>
                    <td><a href="admin/role/edit/${role.id}">Edit</a></td>
                    <td><a href="admin/role/delete/${role.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>
<%--</div>--%>
</body>
</html>
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
    <h2>VM List</h2>
    <table class="table table-striped">
        <tr>
            <th>VM Id</th>
            <th>VM Name</th>
            <th>VM State</th>
            <th>Hypervisor node</th>
        </tr>
        <c:if test="${not empty virtualMachines}">
            <c:forEach var="vm" items="${virtualMachines}">
                <tr>
                    <td text="${vm.id}"><a href="/admin/vm/${vm.id}">Id</a></td>
                    <td text="${vm.hostname}"><a href="/admin/vm/${vm.id}">${vm.hostname}</a></td>
                    <td text="${vm.state}">${vm.state}</td>
                    <td text="${vm.hypervisor.hostname}">${vm.hypervisor.hostname}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<%--</div>--%>
</body>
</html>
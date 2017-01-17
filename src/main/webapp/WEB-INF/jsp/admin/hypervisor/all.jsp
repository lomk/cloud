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
    <p><a href="/admin/hypervisor/new">Add hypervisor</a></p>
    <table class="table table-striped">
        <tr>
            <th>HV Id</th>
            <th>HV Hostname</th>
            <th>HV State</th>
            <th>HV external IP</th>
            <th>HV cloud IP</th>
            <th>HV Virtual Net IP</th>
        </tr>
        <c:if test="${not empty hypervisors}">
            <c:forEach var="hv" items="${hypervisors}">
                <tr>
                    <td text="${hv.id}"><a href="/vm/${hv.id}">Id</a></td>
                    <td text="${hv.hostname}">${hv.hostname}</td>
                    <td text="${hv.state}">${hv.state}</td>
                    <td text="${hv.externalIPAdress}">${hv.externalIPAdress}</td>
                    <td text="${hv.cloudIPAdress}">${hv.cloudIPAdress}</td>
                    <td text="${hv.hvIPAdress}">${hv.hvIPAdress}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <p><a href="/admin/hypervisor/new">Add hypervisor</a></p>
</div>
<%--</div>--%>
</body>
</html>
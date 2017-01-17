<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<html>
<head><title>Add hypervisor</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>
<div class="container">
    <%@ include file="../header.jsp"%>
    <h2>Run command</h2>
    <div>
        <sf:form class="form-horizontal" action="/admin/ssh/run" method="POST" modelAttribute="sshcommand">
           <%-- <div class="form-group">
                <label class="col-sm-2 control-label">Command</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="command"/>
                </div>
            </div>--%>
            <div class="form-group">
                <label class="col-sm-2 control-label">Run with sudo:</label>
                <div class="col-sm-10">
                    <sf:checkbox class="form-control" path="withSudo"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Choose command</label>
                <div class="col-sm-10">
                    <sf:select path="command" class="form-control">
                        <sf:option value="NONE"> --SELECT--</sf:option>
                        <sf:options items="${commands}" itemValue="id" itemLabel="command"></sf:options>
                    </sf:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Choose servers:</label>
                <div class="col-sm-10">
                    <sf:checkboxes class="form-control" items="${servers}" path="servers" itemLabel="hostname" itemValue="hostname"/>
                </div>
            </div>
            <div class="row">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Run command</button>
            </div>
        </sf:form>
    </div>
    <div>
        <c:if test="${not empty result}">
            <c:forEach var="line" items="${result}">
                <ul>${line}</ul>
            </c:forEach>
        </c:if>
    </div>
</div>
</body>
</html>
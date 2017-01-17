<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>
<div class="container">
    <%@ include file="../../header.jsp"%>

    <h2>Product Details</h2>
    <div>
        <sf:form class="form-horizontal" action="/registration" method="POST" modelAttribute="userForm">
            <%--<sf:form class="form-horizontal" action="/product" method="post">--%>
            <sf:hidden field="${id}" path="id"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">User name:</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="username"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password:</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="password"/>
                </div>
            </div>
            <div class="form-group">
                <sf:select  path="nameOfInstitution">
                    <sf:option value="NONE"> --SELECT--</sf:option>
                    <sf:options items="${listOfInstitutionsNames}"></sf:options>

                <label class="col-sm-2 control-label">Roles:</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="roles"/>
                </div>
                </sf:select>
            </div>
            <div class="row">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </sf:form>
    </div>
</div>
</body>
</html>
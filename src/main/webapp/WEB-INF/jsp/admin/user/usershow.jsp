<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>

<div class="container">
    <%@ include file="../../header.jsp"%>
    <h2>User Details</h2>
    <div>
        <form class="form-horizontal">
            <c:if test="${not empty user}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">User Id:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">ID ${user.id}</p></div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">User name:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">Name ${user.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Roles:</label>
                    <div class="col-sm-10">
                        <c:if test="${not empty role}">
                            <p class="form-control-static">Role ${role.name}</p>
                        </c:if>
                    </div>
                </div>
            </c:if>
        </form>
    </div>
</div>
</body>
</html>

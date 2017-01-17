<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="bootstrapsource.jsp"%>
<body>
<div class="container">
    <%@ include file="header.jsp"%>
    <div class="row">
        <div class="col-sm-10">
            Main content goes here
        </div>
        <div class="col-sm-2">
            <%--<%@ include file="sidebar.jsp"%>--%>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
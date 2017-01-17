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
    <h2>Add hypervisor node</h2>
    <div>
        <sf:form class="form-horizontal" action="/admin/hypervisor/new" method="POST" modelAttribute="hypervisor">
            <div class="form-group">
                <label class="col-sm-2 control-label">Hostname</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="hostname"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">External IP</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="externalIPAdress"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Internal cloud IP</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="cloudIPAdress"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Local Virtual Net IP</label>
                <div class="col-sm-10">
                    <sf:input class="form-control" path="hvIPAdress"/>
                </div>
            </div>
            <div class="row">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
            </div>
        </sf:form>
    </div>
</div>
</body>
</html>
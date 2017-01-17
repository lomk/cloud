<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="../../bootstrapsource.jsp"%>
<body>

<div class="container">
    <%@ include file="../header.jsp"%>
    <h2>VM Details</h2>
    <div>
            <c:if test="${not empty virtualmachine}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Hostname:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${virtualmachine.hostname}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Hypervisor:</label>
                    <div class="col-sm-10">
                        <c:if test="${not empty hypervisor}">
                            <p class="form-control-static">${hypervisor.hostname}</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">State:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${virtualmachine.state}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Cloud IP:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${virtualmachine.cloudipAdress}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">HV Net IP:</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${virtualmachine.ipAdress}</p>
                    </div>
                </div>
                <div class="form-group">
                    <sf:form action="/admin/vm/act/${virtualmachine.id}" method="POST" modelAttribute="action">
                            <label class="col-sm-2 control-label">Actions:</label>
                            <div class="col-sm-4">
                                <sf:radiobuttons path="name" items="${actions}" delimiter="<ul></ul>"/>
                            </div>
                        <div class="col-sm-4"><sf:errors path="name"/></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"></label>
                            <div class="col-sm-2">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">SUBMIT</button>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </c:if>
    </div>
</div>
</body>
</html>

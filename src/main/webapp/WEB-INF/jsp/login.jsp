<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>Hello world Example</title></head>
<%@ include file="bootstrapsource.jsp"%>
<body>

<div class="container">
    <%@ include file="header.jsp"%>

      <%--      <div class="row text-center">
                <form action="/login_check" method="post">
                    <input class="form-control" type="text" name="username"/>
                    <br>
                    <input class="form-control" type="password" name="password"/>
                    <br>
                    <button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
                </form>
            </div>
            --%>
        <div class="row" alight="center">
          <form method="POST" action="/login" class="form-signin"   style="width: 300px;" alight="center">
              <h2 class="form-heading">Log in</h2>

              <div class="form-group ${error != null ? 'has-error' : ''}">
                  <span>${message}</span>
                  <input name="username" type="text" class="form-control" placeholder="Username"
                         autofocus="true"/>
                  <input name="password" type="password" class="form-control" placeholder="Password"/>
                  <span>${error}</span>
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                  <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                  <h4 class="text-center"><a href="/registration">Create an account</a></h4>
              </div>

          </form>
    </div>

</div>
</body>
</html>
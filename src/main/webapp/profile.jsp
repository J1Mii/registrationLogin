<%--
  Created by IntelliJ IDEA.
  User: j1mi
  Date: 2022-08-26
  Time: 6:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headers.jsp"/>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="TraitementLogin"/>
</c:if>

<h1>Hello ${sessionScope.user.getUsername()}</h1><br>

<div>
    <h3>Changer votre mot de passe</h3>
    <form name="formChangePasswd" action="TraitementChangePassword" method="POST">
        <label for="oldpasswd">Ancien password</label>
        <input type="password" id="oldpasswd" name="username">

        <label for="passwd">Nouveau Password</label>
        <input type="password" id="passwd" name="passwd">

        <label for="cpasswd">Confirm Nouveau password</label>
        <input type="password" id="cpasswd" name="cpasswd">


        <input type="submit" value="Submit">
    </form>
</div>


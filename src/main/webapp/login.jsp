<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headers.jsp"/>

<c:if test="${sessionScope.user != null}">
    <c:redirect url="TraitementProfile"/>
</c:if>

<div>
    <h3>Connectez-vous</h3>
    <form name="formLogin" action="TraitementLogin" method="POST">
        <label for="username">Username</label>
        <input type="text" id="username" name="username">

        <label for="passwd">Password</label>
        <input type="password" id="passwd" name="passwd">

        <input type="submit" value="Submit">
    </form>
</div>
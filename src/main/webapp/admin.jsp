<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headers.jsp"/>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="TraitementIndex"/>
</c:if>
<c:if test="${sessionScope.user != null}">
    <c:if test="${!sessionScope.user.isAdmin()}">
        <c:redirect url="TraitementProfile"/>
    </c:if>
</c:if>

<h1>
    <c:if test="${sessionScope.user != null}">
        ${sessionScope.user.getUsername()}
        <br>
        ${sessionScope.user.isAdmin()}
    </c:if>
</h1>
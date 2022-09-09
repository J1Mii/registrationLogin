<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headers.jsp"/>

<h1>
<c:if test="${sessionScope.user == null}">
    Bienvenu sur Frenchflix !
</c:if>

<c:if test="${sessionScope.user != null}">
    Rebonjour ${sessionScope.user.getUsername()} !
</c:if>

</h1>
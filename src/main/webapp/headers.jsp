<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Frenchflix</title>
  <link href="css/main.css" rel="stylesheet">
</head>
<body>
<ul>
  <li><a href="TraitementIndex">Home</a></li>
  <c:if test="${sessionScope.user == null}">
    <li><a href="TraitementLogin">Login</a></li>
    <li><a href="TraitementRegister">Register</a></li>
  </c:if>
  <c:if test="${sessionScope.user != null}">
    <li><a href="TraitementProfile">Profile</a></li>
    <c:if test="${sessionScope.user.isAdmin()}">
      <li><a href="TraitementAdmin">Admin</a></li>
    </c:if>
    <li><a href="TraitementLogout">Logout</a></li>
  </c:if>
</ul>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="${bundle}"/>
<fmt:setLocale value=""/>

<html>
<body>
<h1><a href = "http://localhost:8080/finalProject/login">Sign in</a>
<h2><fmt:message key="hello.me"/></h2>
</body>
</html>
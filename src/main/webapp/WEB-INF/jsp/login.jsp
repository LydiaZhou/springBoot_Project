<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Lydia's Website</title>
	</head>
	<body>
		<c:if test="${!empty error}">
	        <font color="red"><c:out value="${error}" /></font>
		</c:if>        
		<form action="<c:url value="loginCheck.html"/>" method="post">
			Username:
			<input type="text" name="userName">
			<br>
			Password:
			<input type="password" name="password">
			<br>
			<input type="submit" value="Sign in" />
			<input type="button" value="Sign up" />
		</form>
	</body>
</html>

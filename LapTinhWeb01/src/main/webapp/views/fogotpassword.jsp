<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FORGOT PASSWORD</h1>
	<form action="forgot-password" method="POST">
		<label for="email"> Enter your account's email: </label> 
		<input class="input-a" type="text" id="email" name="email" placeholder="Email" required> 
		<label for="password">Enter your new password: </label> 
		<input class="input-a" type="password" id="password" name="password" placeholder="Password" required>
		<label for="password"> Re-enter your new password: </label> 
		<input class="input-a" type="password" id="re-password" name="re-password" placeholder="Re-enter password" required>
		<div class="wrap"><button type="submit" onclick="solve()">Reset password</button>
		</div>
	</form>
	<h5 style="color: red">
		<%
		Object alert = request.getAttribute("alert");
		if (alert != null) {
			out.print(alert);
		}
		%>
	</h5>
	<p>
		<a href="login" style="text-decoration: none;"> Back to login </a>
	</p>
</body>
</html>
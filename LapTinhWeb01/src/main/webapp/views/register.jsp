<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Register</h1>	
	<c:if test="${alert !=null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</c:if>
	<form action="register" method="POST">
		<label for="username"> Username: </label> 
		<input type="text"id="username" name="username" placeholder="Enter your username"required> 
			<label for="fullName"> Full name: </label> 
			<input type="text" id="fullName" name="fullname" placeholder="Enter your full name" required> 
			<label for="email"> Email: </label> 
			<input type="text" id="email"name="email" placeholder="Enter your email" required> 
			<label for="phone"> Phone number: </label> 
			<input type="text" id="phone"name="phone" placeholder="Enter your phone number" required>
			<label for="password"> Password: </label> 
			<input type="password" id="password" name="password" placeholder="Enter your password"required> 
			<label for="re-password"> Password: </label> 
			<input type="password" id="re-password" name="re-password"placeholder="Re-enter your password" required>

		<div class="wrap">
			<button type="submit" onclick="solve()">Register</button>
		</div>
	</form>

    <p>Already have an account?
        <a href="login"
           style="text-decoration: none;">
            Login
        </a>
    </p>
</body>
</html>
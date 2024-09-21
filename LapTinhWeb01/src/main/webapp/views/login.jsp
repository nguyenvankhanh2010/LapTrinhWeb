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

	<h2>Đăng nhập</h2>
	<c:if test="${alert !=null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</c:if>
	<form action="/LapTinhWeb01/login" method="post">
		<label for="username">Tên đăng nhập:</label><br> <input
			type="text" id="username" name="uname"><br> <br> <label
			for="password">Mật khẩu:</label><br> <input type="password"
			id="password" name="psw"><br> <br>

		<button type="submit">Đăng nhập</button>
	</form>

	<br>
	<button type="submit">Đăng ký tài khoản</button>
	<br>
	<button type="submit">Quên mật khẩu?</button>
	<p>
		<a href="forgot-password" style="text-decoration: none;"> Forgot
			password? </a>
	</p>
	<p>Not registered? <a href="register" style="text-decoration: none;">
			Create an account </a>
	</p>

</body>
</html>
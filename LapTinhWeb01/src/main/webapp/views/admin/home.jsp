<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<head>
<title>Administrator's Home Page</title>
    <style>
.homepage {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head></head>

<body>
	<c:choose>
		<c:when test="${sessionScope.account == null}">
			<div class="homepage">
				<h1>You haven't login, please login or register</h1>
			</div>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a href="${pageContext.request.contextPath }/login">Login</a>
					</li>
					<li><a href="${pageContext.request.contextPath }/register">Register</a>
					</li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${sessionScope.account.roleId != 1}">
			<div class="homepage">
				<h1>You doesn't have administrator role</h1>
			</div>
		</c:when>
		<c:otherwise>
			<div class="homepage">
				<h1>Administrator's Home Page</h1>
			</div>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a
						href="${pageContext.request.contextPath}/member/my-account">My account: ${sessionScope.account.fullName}</a></li>
					<li><a href="${pageContext.request.contextPath }/logout">Logout</a>
					</li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>



</body>
</html>
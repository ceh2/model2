<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<h1>개인 회원 정보</h1>
	${requestScope.member}
	
	<div id="memberInfo">
		<div class="userImg"><img src="${sessionScope.loginMember.userimg}"/></div>
		<div>${sessionScope.loginMember.userid}</div>
		<div>${sessionScope.loginMember.point}</div>
		<div>${sessionScope.loginMember.registerdate}</div>
	</div>
	
	<div id="pointlog">
		<table border="1">
			<tr>
				<th>포인트 가감일</th>
				<th>가감 포인트</th>
				<th>포인트 가감 사유</th>
			</tr>
			<c:forEach items="${requestScope.pointLog}" var="log">
			<tr>
				<td>${log.givendate}</td>
				<td>${log.pointval}</td>
				<td>${log.why}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
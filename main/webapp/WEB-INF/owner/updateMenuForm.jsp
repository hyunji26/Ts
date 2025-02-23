<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 수정</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

h1 {
	color: #6a7cff;
	text-align: center;
	margin-top: 30px;
}

.header {
	display: flex;
	justify-content: flex-start;
	padding: 10px;
}

.header button {
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 4px;
	background-color: #6a7cff;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.header button:hover {
	background-color: #3e4db4;
}

.menu-info {
	margin: 30px auto;
	text-align: center;
	width: 60%;
}

.menu-info h2 {
	font-size: 24px;
	color: #333;
}

.menu-info p {
	font-size: 18px;
	color: #555;
}

.form-container {
	margin: 20px auto;
	width: 50%;
	background-color: #cfe8fc;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.form-container input {
	width: 80%;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 14px;
}

.form-container button {
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	background-color: #6a7cff;
	color: white;
	font-size: 16px;
	cursor: pointer;
	display: block;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
}

.form-container button:hover {
	background-color: #4f5ecc;
}

.result-message {
	margin-top: 20px;
	font-size: 16px;
	text-align: center;
}

.alert {
	margin-top: 20px;
	font-size: 14px;
	text-align: center;
	color: red;
}
</style>
</head>
<body>
	<!-- 뒤로 버튼 -->
	<div class="header">
		<form action="${pageContext.request.contextPath}/owner/UpdateMenuForm" method="GET">
			<button type="submit">뒤로</button>
		</form>
		<form action="${pageContext.request.contextPath}/owner/ownerMain" method="GET">
			<button type="submit">홈</button>
		</form>
	</div>

	<h1>TastySom!</h1>
	<hr>

	<!-- 메뉴 정보 -->
	<div class="menu-info">
		<h2>${menuInfo.name}</h2>
		<p>${menuInfo.price}원</p>
	</div>

	<!-- 메뉴 수정 폼 -->
	<div class="form-container">
		<h3>변경할 메뉴의 정보를 입력해주세요.</h3>
		<form action="${pageContext.request.contextPath}/owner/UpdateMenu" method="POST">
			<input type="text" name="menuName" placeholder="메뉴 이름"
				value="${menuInfo.name}" required> <input type="number"
				name="price" placeholder="가격" value="${menuInfo.price}" required>
			<button type="submit">확인</button>
		</form>
	</div>

	<!-- 결과 메시지 -->
	<c:if test="${not empty result}">
		<div class="result-message">${result}</div>
	</c:if>
</body>
</html>

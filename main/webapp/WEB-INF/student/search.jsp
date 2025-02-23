<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>메뉴 검색</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
}

.header {
	display: flex;
	justify-content: flex-start;
	padding: 10px;
}

.header button {
	border: none;
	color: #f9f9f9;
	padding: 10px 15px;
	border-radius: 4px;
	font-size: 14px;
	cursor: pointer;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.container {
	margin: 30px auto;
	padding: 20px;
	width: 60%;
	text-align: center;
}

h1 {
	color: #6a7cff;
	text-align: center;
}

select {
	width: 50%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 4px;
	background-color: #fff;
	margin-bottom: 20px;
}

form {
	margin-bottom: 20px;
}

.find-btn {
	text-align: center;
}

.find-btn1 {
	display: inline-block;
	margin: 5px;
}

.button-container {
	display: flex;
	justify-content: center; /* 버튼들을 가운데 정렬 */
	gap: 10px; /* 버튼들 사이 간격 */
	margin-top: 20px;
}

button {
	padding: 10px 20px;
	border: none;
	background-color: #6a7cff;
	color: white;
	font-size: 16px;
	cursor: pointer;
	border-radius: 4px;
}

button:hover {
	background-color: #4f5ecc;
}

.form-container {
	background-color: #dceefb;
	margin: 20px auto;
	width: 50%;
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

.alert {
	color: red;
	font-size: 14px;
	margin-top: 10px;
}
</style>
</head>
<body>

	<!-- 뒤로 버튼 -->
	<div class="header">
		<form action="${pageContext.request.contextPath}/student/studentMain" method="GET">
			<button type="submit">뒤로</button>
		</form>
	</div>
	<hr>

	<h1>TastySom!</h1>
	<hr>
	<!-- 검색 폼 -->
	<div class="container">
		<div class="form-container">
			<form method="POST" action="${pageContext.request.contextPath}/student/SearchResult">
				<h3>검색할 메뉴를 입력하세요</h3>
				<div class="input-group">
					<input type="text" id="search_menu" name="search_menu" required>
				</div>
				<div class="button-container">
					<button type="submit">검색하기</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
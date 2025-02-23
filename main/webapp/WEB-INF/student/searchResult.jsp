<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Search Result</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f7f9fc;
	margin: 0;
	padding: 0;
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

.container {
	margin: 30px auto;
	max-width: 900px;
}

h2 {
	text-align: center;
	color: #6a7cff;
	margin-top: 20px;
}

.result-table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	background-color: white;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.result-table th, .result-table td {
	text-align: left;
	padding: 15px;
}

.result-table thead {
	background-color: #6a7cff;
	color: white;
}

.result-table tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}

.result-table tbody tr:hover {
	background-color: #e3f2fd;
}

.no-results {
	text-align: center;
	color: #424242;
	margin: 50px 0;
}

.button-container {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

.back-button {
	background-color: #6a7cff;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 14px;
}

.back-button:hover {
	background-color: #3e4db4;
}

.home-button {
	background-color: #6a7cff;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 14px;
}

.home-button:hover {
	background-color: #bdbdbd;
}

.sort-options {
	float: right;
	margin-bottom: 20px;
}

.sort-options button {
	background-color: #6a7cff;
	color: white;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
}

.sort-options button:hover {
	background-color: #3e4db4;
}
</style>
</head>
<body>
	<div class="header">
	<form action="${pageContext.request.contextPath}/student/SearchMenu" method="GET">
			<button type="submit">뒤로</button>
		</form>
		<form action="${pageContext.request.contextPath}/student/studentMain" method="GET">
			<button type="submit">홈</button>
		</form>
	</div>
	<hr>
	<h2>${search_menuName} 검색 결과</h2>

	<div class="container">
		<!-- 검색된 식당 리스트가 없을 경우 메시지 표시 -->
		<c:if test="${empty restaurantlist}">
			<div class="no-results">
				<p>검색 결과가 없습니다. 다시 시도해 주세요.</p>
			</div>
		</c:if>

		<!-- 검색된 식당 리스트가 있는 경우 테이블 표시 -->
		<c:if test="${not empty restaurantlist}">
			<table class="result-table">
				<thead>
					<tr>
						<th>식당 이름</th>
						<th>위치</th>
						<th>별점</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="restaurant" items="${restaurantlist}">
						<tr>
							<td>${restaurant.name}</td>
							<td>${restaurant.location}</td>
							<td>${restaurant.rating}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>

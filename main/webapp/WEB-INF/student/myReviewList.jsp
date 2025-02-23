<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.ReviewDAO" %>
<%@ page import="model.domain.Review" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>my review list</title>
<style>
	body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
            background-color: #f9f9f9;
        }
        header {
            text-align: left;
            padding: 10px;
        }
        button {
            background-color: #a4b1ff;
            border: none;
            color: white;
            padding: 8px 16px;
            border-radius: 12px;
            font-size: 14px;
            cursor: pointer;
        }
        h1 {
            color: #4a6ee0;
            font-size: 36px;
            margin-top: 20px;
        }
        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f0f4ff;
        }
</style>
</head>
<body>
	<header>
		<button onclick="location.href='${pageContext.request.contextPath}/student/studentMain'">홈</button>
	</header>
	
	<h1>TastySom!</h1>
	<p>나의 리뷰 목록입니다.</p>
	
	<table>
		<tr>
			<th>식당 이름</th>
			<th>별점</th>
			<th>리뷰</th>
		</tr>
		<c:forEach var="review" items="${myReviewList}">
			<tr>
				<td>${review.restName}</td>
				<td>별점 ${review.reviewPoint}</td>
				<td>${review.reviewContent}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
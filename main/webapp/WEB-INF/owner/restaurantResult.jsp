<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Restaurant Menu Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f9f9f9;
        }
        .container {
            margin: 30px auto;
            padding: 20px;
            background-color: #dceefb;
            border-radius: 8px;
            width: 60%;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #6a7cff;
        }
        .restaurant-info {
            margin-bottom: 20px;
        }
        .restaurant-info img {
            width: 150px;
            height: 150px;
            border-radius: 10px;
            object-fit: cover;
        }
        .restaurant-info div {
            margin: 10px 0;
            font-size: 18px;
        }
        .menu-section {
            margin-top: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }
        th {
            background-color: #6a7cff;
            color: white;
        }
        button {
            margin-top: 20px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #6a7cff;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4f5ecc;
        }
         .back-btn {
            position: absolute;
            top: 10px;
            left: 10px;
            padding: 5px 10px;
            background-color: #6a7cff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            color: black;
            font-size: 14px;
        }

        .back-btn:hover {
            background-color: #E6BE00;
        }
    </style>
</head>
<body>
	<div>
		 <a href="${pageContext.request.contextPath}/owner/ownerMain" class="back-btn">홈</a>
	</div>
    <div class="container">
        <h1>TastySom!</h1>
        <div class="restaurant-info">
            <!-- Restaurant details -->
            <div><strong><c:out value="${restaurant.name}"/></strong></div>
            <div>평점: <c:out value="${restaurant.rating}"/> 점</div>
            <div>거리: <c:out value="${restaurant.location}"/></div>
        </div>
        <hr>
        <div class="menu-section">
            <h2>메뉴 목록</h2>
            <table>
                <thead>
                    <tr>
                        <th>메뉴 이름</th>
                        <th>가격 (원)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="menu" items="${menuList}">
                        <tr>
                            <td><c:out value="${menu.name}"/></td>
                            <td><c:out value="${menu.price}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

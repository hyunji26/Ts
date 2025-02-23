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

        input {
            width: 60%;
            padding: 10px;
            font-size: 16px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #fff;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .button-container {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        button {
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

        .delete-btn {
            background-color: #6a7cff;
        }

        .delete-btn:hover {
            background-color: darkred;
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
    <!-- Back button -->
    <a href="${pageContext.request.contextPath}/owner/ownerMain" class="back-btn">홈</a>

    <div class="container">
        <h1>TastySom!</h1>
        <div class="restaurant-info">
            <!-- Restaurant details -->
            <div><strong><c:out value="${restaurant.name}"/></strong></div>
            <div>평점: <c:out value="${restaurant.rating}"/> 점</div>
            <div>주소: <c:out value="${restaurant.location}"/></div>
        </div>
        <hr>
        <div class="menu-section">
            <h3>변경할 식당의 정보를 입력해주세요.</h3>
            <!-- Form for updating restaurant information -->
            <form action="<c:url value='/owner/updateRestaurant'/>" method="POST" style="display: inline;">
                <!-- 공통 입력 필드 -->
                <input type="text" name="name" placeholder="식당 이름">
                <input type="text" name="location" placeholder="위치">
                <!-- 수정 버튼 -->
                <button type="submit">수정</button>
            </form>
        </div>
    </div>
</body>
</html>

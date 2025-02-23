<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>write review</title>
<style>
 body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
            background-color: #f9f9f9;
        }
        header {
            display: flex;
            justify-content: flex-start;
            padding: 10px;
        }
        button {
            background-color: #a4b1ff;
            border: none;
            color: white;
            padding: 8px 16px;
            margin-right: 10px;
            border-radius: 12px;
            font-size: 14px;
            cursor: pointer;
        }
        h1 {
            color: #4a6ee0;
            font-size: 36px;
        }
        .restaurant-info {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
            margin: 20px auto;
        }
        .review-form {
            background-color: #d5eaff;
            padding: 20px;
            border-radius: 10px;
            display: inline-block;
            text-align: left;
        }
        .form-field {
            margin-bottom: 15px;
        }
        .form-field label {
            display: inline-block;
            width: 150px;
        }
        .form-field input, .form-field textarea {
            width: 300px;
            padding: 5px;
            font-size: 14px;
        }
        .submit-btn {
            display: block;
            margin: 10px auto;
            background-color: #ff6868;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 10px;
            cursor: pointer;
        }
        
</style>
</head>
<body>
	<header>
		<button onclick="location.href='${pageContext.request.contextPath}/student/studentMain'">홈</button>
	</header>
	
	<h1>TastySom!</h1>
	
	<div class="restaurant-info">
		<div>
			<p><b>${restaurant.name}</b></p>
        	<p>평점: ${restaurant.rating} | ${restaurant.location} </p>
		</div>
	</div>
	
	<form class="review-form" method="POST" action="<c:url value='/student/writeReview/update' />">
		<input type="hidden" name="studentId" value="${studentId}" />
		<input type="hidden" name="restaurantId" value="${restaurant.restaurantId}" />
		 <div class="form-field">
            <label for="point">별점을 남겨주세요! (5점 만점)</label>
            <input type="number" id="point" name="point" min="1" max="5" required>
        </div>
        <div class="form-field">
            <label for="content">짧은 후기를 남겨주세요!</label>
            <textarea id="content" name="content" rows="3" required></textarea>
        </div>                                                                                                                                                           
        <button type="submit" class="submit-btn">확인</button>
	</form>
</body>
</html>
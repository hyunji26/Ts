<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>choose restaurant</title>
<style>
  body {
	    font-family: Arial, sans-serif;
	    text-align: center;
	    margin: 0;
	    padding: 0;
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
	    margin-top: 30px;
	}
	p {
	    color: #333;
	    font-size: 16px;
	}
	.form-container {
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    margin-top: 30px;
	}
	.dropdown {
	    padding: 10px;
	    font-size: 16px;
	    border: 1px solid #ccc;
	    border-radius: 6px;
	    width: 300px;
	    margin-top: 10px;
	    text-align: center;
	}
	.submit-btn {
	    background-color: #a4b1ff;
	    color: white;
	    border: none;
	    padding: 10px 20px;
	    border-radius: 12px;
	    font-size: 16px;
	    cursor: pointer;
	    margin-top: 20px;
        }
</style>
</head>
<body>
	<header>
		<button onclick="location.href='${pageContext.request.contextPath}/student/studentMain'">홈</button>
	</header>
	<h1>TastySom!</h1>
	<p>리뷰를 작성할 식당을 선택해주세요.</p>
	
	<form class="form-container" method="POST" action="<c:url value='/student/writeReview/form' />">
        <label for="restaurant">식당 목록</label>
        <select name="restaurant" id="restaurant" class="dropdown" > <!-- required 추가하기 -->
            <option value="" selected>식당을 선택하세요</option> <!-- disabled 추가하기 -->
            <!-- Dynamic List of Restaurants -->
            <c:forEach var="restaurant" items="${restList}">
                <option value="${restaurant.restaurantId}">${restaurant.name}</option>
            </c:forEach>
        </select>
        <button type="submit" class="submit-btn">선택</button>
    </form>
</body>
</html>
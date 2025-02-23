<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TastySom!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #6a7cff; /* Title color */
            margin: 30px 0;
        }
        .header {
   			display: flex;
   			justify-content: flex-start;
   			padding: 10px;
		}

		/* 뒤로 버튼 스타일 변경 */
		.header button {
   			padding: 10px 20px;
   			border: none;
   			border-radius: 4px;
   			background-color: #6a7cff;
   			color: white;
   			font-size: 16px;
   			cursor: pointer;
		}

		.header button:hover {
  			 background-color: #4f5ecc; /* hover 시 색상 변경 */
		}

        .container {
            display: grid;
            grid-template-columns: 1fr 1fr;
            grid-template-rows: auto auto;
            gap: 20px;
            justify-items: center;
            align-items: center;
            margin-top: 30px;
        }

        .button {
            width: 180px;
            height: 50px;
            background-color: #87CEFA;
            color: black;
            font-weight: bold;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            text-decoration: none;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #6abefd;
            color: white;
        }

        .center-icon {
            grid-column: 1 / span 2;
            margin: 20px 0;
            width: 120px;
            height: 120px;
        }
    </style>
</head>
<body>
	<div class="header">
      <form action="/TastySom/student/logout" method="POST">
         <button type="submit">로그아웃</button>
      </form>
   </div>
    <h1>TastySom!</h1>
    <div class="container">
        <a href="${pageContext.request.contextPath}/student/SearchMenu" class="button">메뉴 검색</a>
        
        <a href="${pageContext.request.contextPath}/student/studentRecommend" class="button">나의 추천메뉴</a>
        
        <img src="../images/main_icon.png" alt="Main Icon" class="center-icon">

        <a href="${pageContext.request.contextPath}/student/writeReview" class="button">리뷰 작성</a>
        
        <a href="${pageContext.request.contextPath}/student/myReview" class="button">나의 리뷰</a>
    </div>
</body>
</html>

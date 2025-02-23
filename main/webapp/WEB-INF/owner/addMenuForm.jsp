<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>메뉴 추가</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f5f5f5;
        }

        /* Header Section */
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

        /* Main Title */
        h1 {
            color: #6a7cff;
            font-size: 32px;
            margin-top: 20px;
        }

        /* Restaurant Info */
        .menu-info {
            margin: 20px 0;
            font-size: 18px;
            color: #555; /* 메뉴 정보 색상 */
        }

        .menu-info img {
            width: 150px;
            height: 150px;
            border-radius: 10px;
        }

        /* Form Container */
        .form-container {
            margin: 30px auto;
            width: 50%;
            background-color: #dceefb; /* Changed to match second code */
            border-radius: 8px;
            padding: 25px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Updated box-shadow */
        }

        .form-container h3 {
            font-size: 22px;
            color: #333;
            margin-bottom: 20px;
        }

        .form-container input {
            width: 80%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            color: #333;
            display: block; /* 입력 필드를 블록 레벨 요소로 설정하여 줄 바꿈 */
            margin-left: auto;
            margin-right: auto;
        }

        /* 확인 버튼 스타일 */
        .form-container button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px; 
            background-color: #6a7cff;
            color: white;
            font-size: 16px;
            cursor: pointer;
            display: block; /* 버튼을 블록 레벨 요소로 설정하여 줄 바꿈 */
            margin-top: 20px; /* 버튼과 입력 항목 사이 간격 추가 */
            margin-left: auto;
            margin-right: auto;
        }

        .form-container button:hover {
            background-color: #4f5ecc; /* Changed to match second code */
        }

        /* Result Message Section */
        .Insertresult-message {
            margin-top: 20px;
            font-size: 18px;
            color: #d9534f; /* Red color for message */
        }
    </style>
</head>
<body>
    <!-- Header with Back Button -->
    <div class="header">
        <form action="${pageContext.request.contextPath}/owner/ownerMain" method="GET">
            <button type="submit">뒤로</button>
        </form>
    </div>

    <h1>TastySom!</h1><hr>
    <div class="menu-info">
        <div><strong>${resInfo.name}</strong></div>
        <div>평점: <c:out value="${resInfo.rating}"/> 점</div>
        <div><c:out value="${resInfo.location}"/></div>
    </div>
    <hr>

    <!-- Form Container for Adding Menu -->
    <div class="form-container">
        <h3>추가할 메뉴의 정보를 입력해주세요.</h3>
        <form action="${pageContext.request.contextPath}/owner/insertMenu" method="POST">
            <input type="text" name="menuName" placeholder="메뉴 이름" required>
            <input type="number" name="price" placeholder="가격" required>
            <!-- 버튼은 폼의 맨 아래로 배치됨 -->
            <button type="submit">확인</button>
        </form>
    </div>

    <!-- Insert Result Message -->
    <c:if test="${not empty insert_result}">
        <div class="Insertresult-message">
            ${insert_result}
        </div>
    </c:if>

</body>
</html>

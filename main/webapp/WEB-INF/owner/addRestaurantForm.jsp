<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>add restaurant</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            text-align: center;
        }

        .container {
            margin: 50px auto;
            width: 50%;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2.5em;
            color: #5a5ad1;
        }

        p {
            font-size: 1.2em;
            color: #333;
        }

        .form-box {
            margin: 30px auto;
            padding: 20px;
            background-color: #e0f7ff;
            border-radius: 10px;
            width: 70%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .form-box input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }

        .submit-btn {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #f04e4e;
            border: none;
            color: white;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: #d54343;
        }

        header {
            position: absolute;
            top: 20px;
            left: 20px;
        }

        header button {
            padding: 10px 20px;
            background-color: #a4b1ff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            text-align: center;
        }

        header button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <header>
        <button onclick="location.href='${pageContext.request.contextPath}/owner/ownerMain'">홈</button>
    </header>
    
    <div class="container">
        <h1>TastySom!</h1>
        <p>추가할 식당의 정보를 입력하세요.</p>
        <div class="form-box">
            <form method="POST" action="<c:url value='/owner/insertRestaurant/insert' />">
                <input type="text" name="name" placeholder="식당 이름" required>
                <input type="text" name="location" placeholder="위치" required>
                <button type="submit" class="submit-btn">확인</button>
            </form>
        </div>
    </div>
</body>
</html>

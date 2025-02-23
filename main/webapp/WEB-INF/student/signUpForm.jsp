<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TastySom! 회원가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .signup-container {
            background-color: #e3f2fd;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px 30px;
            width: 400px;
            text-align: center;
            position: relative;
        }
        .signup-container h1 {
            color: #1e88e5;
            margin-bottom: 20px;
        }
        .signup-container form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .signup-container label {
            align-self: flex-start;
            margin-bottom: 5px;
            color: #424242;
            font-weight: bold;
        }
        .signup-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #b0bec5;
            border-radius: 5px;
            font-size: 14px;
        }
        .signup-container .role-group {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 15px;
        }
        .signup-container .role-group label {
            margin: 0 10px;
            color: #424242;
            font-weight: bold;
        }
        .signup-container input[type="radio"] {
            margin-right: 5px;
        }
        .signup-container .submit-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .signup-container .submit-btn:hover {
            background-color: #0056b3;
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
    <a href="${pageContext.request.contextPath}/student/studentLogin/Form" class="back-btn">로그인</a>

    <div class="signup-container">
        <h1>TastySom! 회원가입</h1>
        <p>사용하실 아이디와 비밀번호를 입력하세요.</p>
        <form action="${pageContext.request.contextPath}/student/signUp" method="POST">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" placeholder="아이디를 입력하세요" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>

            <div class="role-group">
                <label><input type="radio" name="role" value="student" required> 학생</label>
                <label><input type="radio" name="role" value="owner" required> 식당 대표</label>
            </div>

            <button type="submit" class="submit-btn">확인</button>
        </form>
    </div>
</body>
</html>

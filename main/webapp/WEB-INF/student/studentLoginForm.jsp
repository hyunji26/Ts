<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.dao.StudentDAO"%>
<%@page import="model.dao.OwnerDAO"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.SQLException"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        .parent {
            text-align: center;
            line-height: 30px;
            margin: 0 auto;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }

        fieldset {
            width: 60%;
            background-color: skyblue;
            margin: 30px auto;
            padding: 30px;
            border: none;
            border-radius: 8px;
        }

        h1 {
            margin-bottom: 40px;
        }

        .input-group {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
        }

        label {
            width: 120px;
            text-align: left;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            flex: 1;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .checkbox-group {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 10px;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }

        input[type="submit"] {
            margin-top: 10px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #007BFF;
            color: white;
            font-size: 14px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .signup-message {
            margin-top: 20px;
            text-align: center;
            font-size: 14px;
        }

        .signup-message a {
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }

        .signup-message a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="parent">
    <h1>
        <hr>
        <span style="color:skyblue">TastySom</span>
        <span style="color:black">로그인</span>
        <hr>
    </h1>

    <c:if test="${loginFailed}">
        <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
    </c:if>

    <form method="POST" action="<c:url value='/student/studentLogin' />">
        <fieldset>
            <div class="input-group">
                <label for="user_id">ID</label>
                <input type="text" id="user_id" name="user_id" required>
            </div>
            <div class="input-group">
                <label for="user_password">PASSWORD</label>
                <input type="password" id="user_password" name="user_password" required>
            </div>
            <div class="checkbox-group">
                <label><input type="radio" name="role" value="student" required> 학생</label>
                <label><input type="radio" name="role" value="owner" required> 식당 대표</label>
            </div>
            <input type="submit" value="확인">
        </fieldset>
    </form>

    <!-- 회원가입 메시지 및 버튼 추가 -->
    <div class="signup-message">
        <p>아직 회원이 아니신가요? <a href="${pageContext.request.contextPath}/student/signUp/form">회원가입</a></p>
    </div>
</div>
</body>
</html>

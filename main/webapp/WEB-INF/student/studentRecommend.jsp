<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>TastySom!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            text-align: center;
            margin-top: 50px;
        }
        .menu-list {
            margin-top: 20px;
        }
        .menu-item {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
        }
        .menu-item span {
            margin-right: 20px;
        }
        .search-btn {
            padding: 5px 10px;
            background-color: #87CEFA;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .back-btn {
            position: absolute;
            top: 10px;
            left: 10px;
            padding: 5px 10px;
            background-color: #6a7cff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
    <!-- Back button -->
    <a href="${pageContext.request.contextPath}/student/studentMain" class="back-btn">홈</a>
    
    <div class="container">
        <h1>TastySom!</h1>
        <h3>오늘은 이거 어때요?</h3>
        <div class="menu-list">
            <!-- Check if mostSearchedMenus is null or empty -->
            <c:choose>
                <c:when test="${empty topMenus}">
                    <p>추천 메뉴가 없습니다.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="menu" items="${topMenus}" varStatus="status">
                        <div class="menu-item">
                            <span>${status.index + 1}위</span> <span>${menu}</span>
                            <form action="${pageContext.request.contextPath}/student/SearchResult" method="POST" style="display: inline;">
                                <input type="hidden" name="search_menu" value="${menu}">
                                <button type="submit" class="search-btn">검색</button>
                            </form>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>수정 메뉴 선택</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
}

.header {
    display: flex;
    justify-content: flex-start;
    padding: 10px;
}

.header button {
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 4px;
	background-color: #6a7cff;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.header button:hover {
	background-color: #3e4db4;
}

.container {
    margin: 30px auto;
    padding: 20px;
    background-color: #dceefb;
    border-radius: 8px;
    width: 60%;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h1 {
    color: #6a7cff;
    text-align: center;
}

.restaurant-info {
    margin-bottom: 20px;
    text-align: center;
}

.restaurant-info div {
    margin: 10px 0;
    font-size: 18px;
    color: #555;
     text-align: center;
}

.menu-section {
    margin-top: 20px;
}

select {
    width: 50%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #fff;
    margin-bottom: 20px;
}

form {
    margin-bottom: 20px;
}

button {
    padding: 10px 20px;
    border: none;
    background-color: #6a7cff;
    color: white;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
}

button:hover {
    background-color: #4f5ecc;
}

.alert {
    color: red;
    font-size: 14px;
    margin-top: 10px;
    text-align: center;
}
</style>
</head>
<body>
    <!-- 뒤로 가기 -->
    <div class="header">
    <form action = "${pageContext.request.contextPath}/owner/ownerMain"  method="GET">
        <button type ="submit">뒤로 </button> 
        </form>
    </div>

    <h1>TastySom!</h1>
    <hr>

    <!-- 레스토랑 정보 -->
    <div class="restaurant-info">
        <div>
            <strong>${resInfo.name}</strong>
        </div>
        <div>
            평점: <c:out value="${resInfo.rating}" /> 점
        </div>
        <div>
            <c:out value="${resInfo.location}" />
        </div>
    </div>
    <hr>

    <!-- 메뉴 섹션 -->
    <div class="menu-section">
        <div class="container">
            <h3>수정/삭제할 메뉴를 선택해주세요.</h3>
            
            <!-- Form for update and delete -->
            <form action="${pageContext.request.contextPath}/owner/UpdateMenuOption" method="POST">
                <select name="menuIdd" required>
                    <option value="" selected>메뉴를 선택하세요</option>
                    <c:forEach var="menu" items="${menulist}">
                        <option value="${menu.menuId}">${menu.name}</option>
                    </c:forEach>
                </select>
                <br>
                <!-- Buttons for different actions -->
                <button type="submit" name="action" value="update">수정하기</button>
                <button type="submit" name="action" value="delete">삭제하기</button>
            </form>
        </div>
     </div>
    <!-- 알림 메시지 -->
    <c:if test="${empty menulist}">
        <div class="alert">메뉴 목록이 비어 있습니다. 메뉴를 추가하세요!</div>
    </c:if>
    <c:if test="${not empty delete_result}">
        <div class="alert">${delete_result}</div>
    </c:if>
</body>
</html>

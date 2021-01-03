<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>장바구니</h1> <br />
<c:forEach items="${cartList }" var="list">
	<c:out value="${list.res_menu_name }" /> <br />
	<c:out value="${list.amount }" />개 <br />
	<c:out value="${list.res_menu_price }" />원 총합계: <c:out value="${list.sum }" /> <br />	
</c:forEach>

<hr>
최종금액: ${sumTotal }원

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
장바구니 담기 테스트
<form action="/cart/insert" method="get">
식당코드: <input type="text" name="res_code"> <br />
메뉴코드: <input type="text" name="res_menu_code"> <br />
수량: <input type="text" name="amount"> <br />
<input type="submit" value="장바구니 담기">
</form>
</body>
</html>
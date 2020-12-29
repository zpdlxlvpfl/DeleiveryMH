<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/cart/insert" method="get">
<!-- 	<input type="text" name="id"> <br /> -->
	<input type="range" name="res_menu_code" value="res_02A01"> 기본 파스타 <br />
	<input type="radio" name="res_menu_code" value="res_02A02"> 크림파스타 <br />
	<input type="radio" name="res_menu_code" value="res_02B01"> 리조또 <br />
	<input type="submit" value="장바구니 담기">
</form>



</body>
</html>
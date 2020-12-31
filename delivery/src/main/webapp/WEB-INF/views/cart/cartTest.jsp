<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sec:authentication property="principal.CustomerVO.id"/>
<form action="/cart/insert" method="get">
<!-- 	<input type="text" name="id"> <br /> -->
<input type="text" name="list[0].id" value=<sec:authentication property="principal.CustomerVO.id"/>> <br />
	<input type="checkbox" name="list[0].res_menu_code" value="res_02A01"> 기본 파스타 <br />
	<input type="number" name="list[0].amount"> <br />
	<input type="text" name="list[1].id" value=<sec:authentication property="principal.CustomerVO.id"/>> <br />
	<input type="checkbox" name="list[1].res_menu_code" value="res_02A02"> 크림파스타 <br />
	<input type="number" name="list[1].amount"> <br />
	<input type="text" name="list[2].id" value=<sec:authentication property="principal.CustomerVO.id"/>> <br />
	<input type="checkbox" name="list[2].res_menu_code" value="res_02B01"> 리조또 <br />
	<input type="number" name="list[2].amount"> <br />
	<input type="submit" value="장바구니 담기">
</form>

<script>


</script>



</body>
</html>
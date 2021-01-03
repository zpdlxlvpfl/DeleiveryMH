<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
	


	<script>
	$(document).ready(
		function restList() {
			$.ajax({
				type : "get",
				url : "/restaurant/restList",
		        dataType: "json",
				data : {
					RES_CODE : "${RES_CODE}",
					RES_NAME : "${RES_NAME}",
					RES_INFO : "${RES_INFO}",
					RES_MENU_PRICE : "${RES_MENU_PRICE}",
					DEL_PRICE : "${DEL_PRICE}"
				},
				error : function(error) {
					alert('error' + data);
					console.log("error " + data);
					
				},
				success : function(data) {
					alert('success' + data);
					console.log("success" + data);
				}
			});
		}
	</script>
	
	
	
	


</body>
</html>
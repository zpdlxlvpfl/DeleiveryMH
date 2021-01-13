<!DOCTYPE html>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page
	import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Delivery TEST Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script
	src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<script>
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">

<script src="../resources/js/vendor/bootstrap.min.js"></script>
<script src="../resources/js/plugins.js"></script>
<script src="../resources/js/main.js"></script>




</head>


<body>


	<table>
		<tr>


			<th>주문내역</th>
			<c:forEach items="${orderList}" var="id">
				<td><c:out value="${id.cart_no}" /></td>
				<td><c:out value="${id.id}" /></td>
				<td><c:out value="${id.res_menu_name}" /></td>
				<td><c:out value="${id.order_date}" /></td>
				<td><c:out value="${id.amount}" /></td>
				<td><c:out value="${id.cart_no}" /></td>
				<td><c:out value="${id.sum}" /></td>

				<%-- <td>${HashMapList.order_no}</td>
				<td>${HashMapList.id}</td>
				<td>${HashMapList.res_menu_name}</td>
				<td>${HashMapList.order_date}</td>
				<td>${HashMapList.amount}</td>
				<td>${HashMapList.sum}</td> --%>
			</c:forEach>
		</tr>
	</table>


<script>
	var order_no = $(order_no);
	var cart_no = $(cart_no);
	var id = $(id);
	var HashMapList = $(HashMapList);
	function orderList() {

		restaurantService.orderList(function(orderList) {
			var json = {
				id : "${id}",
				order_no : "${order_no}",
				cart_no : "${cart_no}",
				res_code : "${res_code}",
				res_menu_code : "${res_menu_code}",
				res_menu_name : "${res_menu_name}",
				order_date : "${order_date}",
				amount : "${amount}",
				sum : "${sum}"
			};
			$.ajax({
				type : "get",
				url : "/order/orderList",
				data : json,
				success : function(string) {
					alert('주문 성공');
					document.location.href = "/order/orderList";
				},
				error : function(error) {
					alert("error.");
				}
			});

		});
	};
</script>
</body>

</html>
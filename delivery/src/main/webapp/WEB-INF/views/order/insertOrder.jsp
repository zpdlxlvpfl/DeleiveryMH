<!DOCTYPE html>
<%@page import="java.util.List"%>
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
</head>
<script
	src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>


<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">

<script src="../resources/js/vendor/bootstrap.min.js"></script>
<script src="../resources/js/plugins.js"></script>
<script src="../resources/js/main.js"></script>





<body>




	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="#home"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#services"><span>Services</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login.html"><span>LOGIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="join.html"><span>JOIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>

	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="15px";>Restaurant List</font>
		</h1>
		<span><font color="orange">Restaurant List </font></span>

	</div>


	<div class="service-content" id="services">
		<div class="container">
			<div class="row">

				<div class="col-md-12">


					<div style="margin: 0 auto; width: 300px;">



						<div class="service-item">
							<div class="col-md-12">
								<h4>주문 확인</h4>
								<div class="line-dec"></div>


								<c:forEach items="${HashMapList}" var="HashMapList">
									<input type="hidden" id="cart_no" name="cart_no"
										value='<c:out value="${HashMapList.cart_no }" />'>
										<td>주문번호 :<c:out value="${order_no.order_no }" /></td> <br>
									<td>메뉴 이름 : <c:out value="${HashMapList.res_menu_name }" /></td> <br>
									<td>총액 : <c:out value="${HashMapList.sum }" /></td>
								</c:forEach>

								<div class="primary-button">
									<a href="/order/orderList">주문하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="primary-button">
						<a href="#home">Back To Top</a>
					</div>
					<ul>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-google"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<script>
		var id = $(id);
		var orderList = $(orderList);

		function orderList() {

			OrderService.orderList(function() {
				$.ajax({
					url : "/restaurant/orderList",
					type : "GET",
					contentType : "application/json; charset=utf-8;",
					dataType : "json",
					data : {
						id : "${id}",
						m_name : "${m_name}",
						res_menu_name : "${res_menu_name}",
						address : "${address}",
						sum : "${sum}"
					},
					success : function(data) {
						console.log("success" + data);
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
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.bind.annotation.SessionAttribute"%>
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



<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">



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


</head>


<body>



	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="15px">Restaurant Home</font>
		</h1>
		<span><font color="orange" size="5px">Restaurant Home </font></span>

	</div>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>




	<div class="service-content" id="services">

		<div class="row">
			<div class="col-md-12">
				<div id="owl-testimonials" class="owl-carousel owl-theme">


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
								<img src="../resources/img/6th-item.jpg" alt="" id="">
									<c:forEach items="${list}" var="RES_CODE" begin="6"
										end="6" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
									</c:forEach>
									<div class="primary-button">
										<a href="cart">cart</a>
									</div>
								</div>
							</div>
						</div>

					
					
				</div>
			</div>
	
				</div>
		</div>
	</div>



	<div class="parallax-content contact-content " id="contact-us"></div>





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

	<script type="text/javascript">
	var RES_CODE = $(RES_CODE);
	var res_menu_code = $(res_menu_code);
	var list = $(list);
	
	function menuread() {

		restaurantService.menuread(function(menuread) {
				$.ajax({
				url : "restaurant/menuread?RES_CODE="+RES_CODE,
				type : "GET",
				contentType : "application/json; charset=utf-8;",
				dataType : "json",
				data : {
					RES_CODE : "${RES_CODE}",
					res_menu_code : "${res_menu_code}",
					res_menu_name : "${res_menu_name}",
					res_menu_explan : "${res_menu_explan}",
					res_menu_price : "${res_menu_price}"
				},
				error : function(error) {
					console.log("error " + data);

				},
				success : function(data) {
					alert('success' + data);
					console.log("success" + data);
					return RES_CODE;
				} 
			});
		});
	}
	</script>


	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>
</body>
</html>
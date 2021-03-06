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



<form name="Logout" action="/logout" method="post">
	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-restList"><a class="nav-link" href="#"
				onclick="location.href='/'"><span>Delivery Home</span></a></li>
			<li class="nav-item"><a class="nav-link" href="myCart"><span>myCart</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#" onclick="javascript:document.Logout.submit();" ><span>LOGOUT</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#"><span>UP</span></a></li>
		</ul>
	</div>
	</form>

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
								<h4>주문 성공</h4>
								<div class="line-dec"></div>

								<c:forEach items="${OrderList}" var="OrderList">
									<input type="hidden" id="cart_no" name="cart_no"
										value='<c:out value="${OrderList.cart_no }" />'>

									<td>주문번호: <c:out value="${OrderList.cart_no }" /></td>
									<br>
									<td>아이디: <c:out value="${OrderList.id }" /></td>
									<br>
									<td>이름: <c:out value="${OrderList.m_name }" /></td>
									<br>
									<td>주소: <c:out value="${OrderList.address }" /></td>
									<br>
									<td>메뉴이름 : <c:out value="${OrderList.res_menu_name }" /></td>
									<br>
									<td>총액 :<c:out value="${OrderList.sum }" /></td>
									<br>
									<td>전화번호 :<c:out value="${OrderList.tel }" /></td>
									<br>
								</c:forEach>

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




</body>

</html>
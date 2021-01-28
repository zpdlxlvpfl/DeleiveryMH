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
<script type="text/javascript"
	src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<script>
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>

<script type="text/javascript">
var RES_CODE = $(RES_CODE);
var res_menu_code = $(res_menu_code);

function menuList() {

	restaurantService.menuList(function(menuList) {
		$.ajax({
			url : "/restaurant/menuList",
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

			}
		});
	});
}

	function deleteMenu(RES_CODE) {
		var is = confirm("Are you sure you want to delete this?");
		var RES_CODE = $(RES_CODE);
		var res_menu_code = $(res_menu_code);
		var url = "/restaurant/menuList?RES_CODE="+RES_CODE;
		success : function e(data) {
		if (is) {
			alert("RES_CODE=" + RES_CODE);
			return url;
		} else {
			return false;
		}window.location.reload();
		}

	}

	function updateMenu() {
		var RES_CODE = $(RES_CODE);
		var url = "/restaurant/menuList?RES_CODE=";
		console.log(RES_CODE);
 	success : function updateMenu(data) {
		alert('success' + data);
		$("#update").load(window.location.href + "#update");
	}location.replace();
	}
	
	
	
	function deleteRest(RES_CODE) {
		var RES_CODE = $(RES_CODE);
		var res_menu_code = $(res_menu_code);
		var isa = confirm("Are you sure you want to delete this?");
		success : function deleteRes(data) {
		if (isa) {
			alert("RES_CODE=" + RES_CODE);
			window.location.reload();
			return true;
		} else {
			return false;
		}
		}

	}

	function updateRest() {
		var RES_CODE = $(RES_CODE);
		var res_menu_code = $(res_menu_code);
		success : function(data) {
			alert('success' + data);
		}
	}
	
</script>

</head>


<body>



	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="15px">Restaurant Home</font>
		</h1>
		<span><font color="orange" size="5px">Restaurant Home </font></span>

	</div>


<form name="Logout" action="/logout" method="post">
	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="#" onclick="location.href='/'"><span>Delivery Home</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#" onclick="location.href='/foodmaptest'"><span>Map Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#" onclick="javascript:document.Logout.submit();" ><span>LOGOUT</span></a></li>
			<li class="nav-item"><a class="nav-link" href="restList"><span>Restaurant List</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#"  onclick="location.href='/cart/myCart'"><span>TEST</span></a></li>
		</ul>
	</div>
	</form>




	<div class="service-content" id="services">

		<div class="row">
			<div class="col-md-12">


				<div id="owl-testimonials" class="owl-carousel owl-theme">




					<div class="col-md-8">
						<c:forEach items="${menuList}" var="RES_CODE" begin="0" end="0"
							step="1" varStatus="i">
							<input type="hidden" id="RES_CODE" name="RES_CODE"
								value='<c:out value="${RES_CODE.RES_CODE }" />'>
							<div class="left-text">
								<h4>My restaurant</h4>
								<div class="line-dec"></div>
								<p>My restaurant Info Update/Delete</p> <br>
								<div class="primary-button" >
									<a href="javascript:window.open('/restaurant/res_pop_up?RES_CODE=${RES_CODE.RES_CODE}',updateRes,'width=500,height=500');"
										id="updateRes" onclick="updateRest">Update</a> <a
										href="/restaurant/deleteRes?RES_CODE=${RES_CODE.RES_CODE}"
										onclick="if(!confirm('Are you sure you want to delete this ?')){return false;}; {location.replace();}">
										Delete </a>
								</div>
							</div>
						</c:forEach>
					</div>





					<div class="col-md-8" id="update">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item" >
									<img src="../resources/img/0st-item.jpg" alt="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="0" end="0"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="javascript:updateMenu();"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>


									</c:forEach>
								</div>
							</div>
						</div>
					</div>





					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/1st-item.jpg" alt="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="1" end="1"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/2nd-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="2" end="2"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/3rd-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="3" end="3"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/4th-item.jpg" alt="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="4" end="4"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/5th-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="5" end="5"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/6th-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="6" end="6"
										step="1" varStatus="i">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${RES_CODE.RES_CODE }" />'>

										<h4 id="res_menu_name">
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p id="res_menu_explan">
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span id="res_menu_price"><c:out
												value="${RES_CODE.res_menu_price}"></c:out> &#8361;</span>
										<div class="primary-button">

											<a
												href="javascript:window.open('/restaurant/menu_pop_up?res_menu_code=${RES_CODE.res_menu_code}',updateMenu,'width=500,height=500');"
												id="updateMenu" onclick="updateMenu"> Update </a> <a
												href="/restaurant/deleteMenu?res_menu_code=${RES_CODE.res_menu_code}"
												onclick="if(!confirm('Are you sure you want to delete this ?')){return false;};">
												Delete</a>
										</div>
									</c:forEach>
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



	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>
</body>
</html>
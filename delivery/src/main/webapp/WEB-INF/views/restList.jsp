<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Rest List</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">



<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../resources/js/vendor/bootstrap.min.js"></script>
<script src="../resources/js/plugins.js"></script>
<script src="../resources/js/main.js"></script>


<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script
	src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script type="text/javascript">
	window.jQuery
			|| document
					.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
</script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<!-- <script type="text/javascript">
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script> -->


</head>
<body>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-restList"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-restList"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-restList"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
			<li class="nav-restList"><a class="nav-link" href="join"><span>JOIN</span></a></li>
			<li class="nav-restList"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>





	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="14px">Restaurant List</font>
		</h1>
		<span><font color="orange" size="5px">Restaurant List </font></span>
	</div>




	<div class="service-content" id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div id="owl-testimonials" class="owl-carousel owl-theme">


						<div class="col-md-8">
							<div class="left-text">
								<h4>Delivery TEST</h4>
								<div class="line-dec"></div>
								<p>
									Delivery TEST abcdefgsadqasdfaffadac <a rel="nofollow"
										href="https://templatemo.com"> website</a> whsskwhfflek.
								</p>
								<ul>
									<li>- test test test test test test</li>
									<li>- test test test test test test</li>
									<li>- test test test test test test</li>
									<li>- test test test test test test</li>
								</ul>
								<div class="primary-button">
									<a href="#portfolio">Delivery TEST</a>
								</div>
							</div>
						</div>



						<c:forEach items="${restList}" var="RES_CODE" varStatus="loop">
							<c:set var="nextVal" value="${restList[loop.index]}" />
							<div class="col-md-12">
								<div class="service-item">
									<div class="left-text">
										<input type="hidden" id="RES_CODE" name="RES_CODE"
											value='<c:out value="${nextVal.RES_CODE }" />'>
										<h4>
											<a href="/restaurant/menuList?RES_CODE=${nextVal.RES_CODE}">
												${nextVal.RES_NAME }</a>
										</h4>
										<div class="line-dec"></div>
										<p>${nextVal.RES_INFO }</p>
										<p>
											Delivery Tips : ${nextVal.DEL_PRICE }<font color="orange">
												&#8361; </font>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
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
</body>
</html>
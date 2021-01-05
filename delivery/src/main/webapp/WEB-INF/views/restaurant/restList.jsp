<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<script>
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>

<script>
	$(document).ready(function restList() {
		$.ajax({
			type : "get",
			url : "/restaurant/restList",
			dataType : "json",
			data : {
				RES_CODE : "${RES_CODE}",
				RES_NAME : "${RES_NAME}",
				RES_INFO : "${RES_INFO}",
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
	});
</script>
</head>
<body>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>





	<div class="parallax-content projects-content" id="portfolio">

			<h1> <font color="white" size="14px">Restaurant List</font> </h1>
		<span><font color="orange" size="5px">Restaurant List </font></span> </div>


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
						<div class="col-md-12">
						
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="1" end="1" step="1" varStatus="status">
								<h4><a href="/restaurant/reshome/get?RES_CODE=${RES_CODE.RES_CODE}"><c:out value=" ${RES_CODE.res_name}"></c:out></a></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
								<p>Delivery Tips : <c:out value=" ${RES_CODE.del_price}"></c:out> &#8361;</p>
								
							</c:forEach>
							</div>
								
								<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="2" end="2" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="3" end="3" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							</div>
							
							
						<div class="col-md-12">
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="4" end="4" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="5" end="5" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="6" end="6" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							</div>
							
							

						<div class="col-md-12">
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="7" end="7" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="8" end="8" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="9" end="9" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							</div>
							
							
							
							
						<div class="col-md-12">
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="10" end="10" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="11" end="11" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="12" end="12" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							</div>
							
							<div class="col-md-12">
						<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="13" end="13" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
							
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="14" end="14" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
							</div>
						
							<div class="service-item">
								<c:forEach items="${RestList}" var="RES_CODE" begin="15" end="15" step="1" varStatus="i">
								<h4><c:out value=" ${RES_CODE.res_name}"> </c:out></h4>
								<div class="line-dec"></div>
								<p><c:out value=" ${RES_CODE.res_info}"> </c:out></p>
							</c:forEach>
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
			</div></div>
	</footer>


</body>
</html>

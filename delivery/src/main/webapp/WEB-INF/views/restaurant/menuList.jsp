<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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



<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//	var url = '/restaurant/menuList';
						$
								.ajax({
									url : "/restaurant/menuList",
									type : "GET",
									contentType : "application/json; charset=utf-8;",
									dataType : "json",
									data : JSON.stringify({
										res_code : "res_code",
										res_menu_code : "res_menu_code",
										res_menu_name : "res_menu_name",
										res_menu_explan : "res_menu_explan",
										res_menu_price : "res_menu_price"
									}),

									success : function(result) {
										var e = result.e;
										$('#menuList').html(e);

										console.log("success"
												+ JSON.stringify(e.result));
										console.log("msg" + e.msg);

										$(".res_code").empty();
										$(".res_menu_code").empty();
										$(".res_menu_name").empty();
										$(".res_menu_explan").empty();
										$(".res_menu_price").empty();

										$
												.each(
														menuList,
														function(idx, val) {
															$(".res_code")
																	.text(
																			val.res_code);
															$(".res_menu_code")
																	.text(
																			val.res_menu_code);
															$(".res_menu_name")
																	.text(
																			val.res_menu_name);
															$(
																	".res_menu_explan")
																	.text(
																			val.res_menu_explan);
															$(".res_menu_price")
																	.text(
																			val.res_menu_price);

															var html = "";
															$("#menuList")
																	.empty(); //div
															html += "<table id='menuList';>";
															html += "<tr><th>res_code</th><th>res_menu_code</th><th>res_menu_name</th><th>res_menu_explan</th><th>res_menu_price</th></tr>";

															var menuList = returnFix.btnsearchFix;
															$
																	.each(
																			menuList,
																			function(
																					idx,
																					val) {

																				//	html += "<tr> <td>" + res_code + "</td>"
																				//	html += "<td>" + res_menu_code + "</td>"
																				html += "<h4>"
																						+ res_menu_name
																						+ "</h4>"
																				//	html += "<td>" + res_menu_explan + "</td>"
																				html += "<span>"
																						+ res_menu_price
																						+ "</span>"
																			});
															$("#menuList")
																	.append(
																			html);
														});
									},
									error : function(error) {
										console.log("error" + error);
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

		<h1>
			<font color="white">Restorent Home TEST</font>
		</h1>
		<span><font color="orange">Restorent Home TEST </font></span>



		<div class="container">

			<div class="row">

				<div class="col-md-12">

					<div id="owl-testimonials" class="owl-carousel owl-theme">

						<div class="item" id="menuList">
							<div class="testimonials-item">
								<a href="../resources/img/1st-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/1st-item.jpg" alt=""></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">

										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}"></c:out>
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/2nd-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/2nd-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">
										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}" />&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/3rd-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/3rd-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">
										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}" />&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/4th-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/4th-item.jpg" alt=""
									id="${res_menu_name}"></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">
										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/5th-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/5th-item.jpg" alt=""
									id="${res_menu_name}"></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">
										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/6th-big-item.jpg"
									data-lightbox="image-1"><img
									src="../resources/img/6th-item.jpg" alt=""
									id="${res_menu_name}"></a>
								<div class="text-content">
									<c:forEach items="${HashMapList}" var="res_menu_code">
										<h4>
											<c:out value="${res_menu_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_menu_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="service-content" id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
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
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-6">
							<div class="service-item">
								<h4>Delivery TEST</h4>
								<div class="line-dec"></div>
								<p>test test test test test test</p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="service-item">
								<h4>Delivery TEST</h4>
								<div class="line-dec"></div>
								<p>test test test test test test</p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="service-item">
								<h4>Delivery TEST</h4>
								<div class="line-dec"></div>
								<p>test test test test test test</p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="service-item">
								<h4>Delivery TEST</h4>
								<div class="line-dec"></div>
								<p>test test test test test test</p>
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


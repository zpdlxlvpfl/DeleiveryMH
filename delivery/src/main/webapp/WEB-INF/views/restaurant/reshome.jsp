<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>


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
	
		<h1><font color="white">Restorent List</font></h1> 
		<span><font color="orange">Restorent  List </font></span>
		
		<table width="70%"
					class="table table-striped table-bordered table-hover" id="test">
					<thead>
				
						<tr>
							<th>res_code</th>
							<th>res_menu_code</th>
							<th>res_menu_name</th>
							<th>res_menu_explan</th>
							<th>res_menu_price</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${HashMapList}" var="res_code">
							<tr class="odd gradeX">
								<td><c:out value="${res_code.res_code}" /></td>
								<td><a href="/restaurant/test/get?res_code=${res_code}"><c:out
											value="${res_code.RES_NAME}" /></a></td>
								<td><c:out value="${res_code.RES_INFO}" /></td>
								<td><c:out value="${res_code.DEL_PRICE}" /></td>
								<td><c:out value="${res_code.RES_MENU_PRICE}" /></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
				
				
		
				
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
	
	<div class="parallax-content contact-content " id="contact-us">
	
	
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



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
	</script>
<script src="../resources/js/vendor/bootstrap.min.js"></script>
<script src="../resources/js/plugins.js"></script>
<script src="../resources/js/main.js"></script>

<!-- <script>
	$(document).ready(function() {
			$.ajax({
				type : "GET",
				url : "/restaurant/menuList",
				dataType: "json",
				contentType: "application/json; charset=utf-8;"
				data :  JSON.stringify(jsonData)
				{	res_code : "${res_code}",
					res_menu_code : "${res_menu_code}",
					res_menu_name : "${res_menu_name}",
					res_menu_explan : "${res_menu_explan}",
					res_menu_price : "${res_menu_price}"
				},
				error : function(error) {
					console.log("error " + data);
				},
				success : function(result) {
					console.log("success"+JSON.stringify(result.data));
		            console.log("msg"+result.msg );
		            var html = "";
					$j("#item").empty(); //div
					html += "<table id='menuList';>";
					
					var menuList = returnFix.btnsearchFix;
					$j.each(item , function(idx, val) {
						
						html += "<tr> <td>"+val.RES_CODE+"</td>"
						html += "<td>"+val.res_menu_code+" &#8361;</td></tr>"
						html += "<tr> <td>"+val.res_menu_name+"</td>"
						html += "<td>"+val.res_menu_explan+" &#8361;</td></tr>"
						html += "<tr> <td>"+val.RES_MENU_PRICE+"</td>"
					});
					html += "</table>";
				}
			 });
	 };

				
				
		
	</script> -->


</body>
</html>
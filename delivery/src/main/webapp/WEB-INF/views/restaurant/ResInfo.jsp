<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
			<font color="white" size="15px">Restaurant Info</font>
		</h1>
		<span><font color="orange" size="5px">Restaurant Info </font></span>

	</div>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="logout"><span>LOGOUT</span></a></li>
			<li class="nav-item"><a class="nav-link" href="TEST"><span>TEST</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>







	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">

					<div class="parallax-content contact-content " id="contact-us">
						<div id ="list">
						<input type="hidden" id="list" name="list" value='<c:out value="${list.RES_CODE }" />'>
						<input type="hidden" id="${status.count}" disabled>
						<table class="table table-striped table-bordered table-hover">
							
							<thead>
								<tr>
									<th>RES NAME</th>
									<th>RES_INFO</th>
									<th>DEL_PRICE</th>
								</tr>
							</thead>
							
								<c:forEach items="${list}" var="list">
									<tr class="odd gradeX">
										<td>${list.RES_CODE }</td>
										<td>${list.res_name }</td>
										<td>${list.res_info }</td>
										<td>${list.del_price }</td>
									</tr>
								</c:forEach>
						</table>
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



	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>



</body>
<script type="text/javascript">
	var ResInfo = $("#ResInfo");
	var list = $("#list");
	var RES_CODE = $("#RES_CODE");

	$(document).ready(function(list) {
		$.ajax({
			url : "/restaurant/ResInfo",
			type : "GET",
			contentType : "application/json; charset=utf-8;",
			dataType : "text",
			data : JSON.stringify({
				RES_CODE : "RES_CODE",
				RES_NAME : "res_name",
				RES_INFO : "res_info",
				DEL_PRICE : "del_price"
			}),
			error : function(data, list) {
				console.log("error " + data + list);
			},
			success : function(data, list) {
				alert('success' + data);
				console.log("success" + data + list);
				var html = "";
				for(var i=0, len=list.length||0; i<len; i++){		
							html += "<td>"+list.RES_CODE+"</td>"
							html += "<td>"+list.res_name+"</td>"
							html += "<td>"+list.res_info+"</td>"
							html += "<td>"+list.del_price+"</td>"
							console.log(html);
						}
				ResInfo.html(list);
			}
		});
	});
</script>
</html>
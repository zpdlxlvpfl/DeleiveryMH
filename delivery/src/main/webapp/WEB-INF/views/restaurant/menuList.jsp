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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"
	type="text/javascript"></script>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
 <script>
	window.jQuery
			|| document
					.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js" ><\/script>')
</script>
 



<!-- 
	<script type="text/javascript">
		$(document).ready(function() {
		//	var url = '/restaurant/menuList?';
			$.ajax({
				url : "/restaurant/menuList",
				type : "GET",
				contentType : "application/json; charset=utf-8;",
				dataType : "json",
				data : JSON.stringify ({
					res_code : "res_code",
					res_menu_code : "res_menu_code",
					res_menu_name : "res_menu_name",
					res_menu_explan : "res_menu_explan",
					res_menu_price : "res_menu_price"
				}),

				success : function(result) {
					var e = result.e;
					$('#menuList').html(e);

					console.log("success" + JSON.stringify(e.result));
					console.log("msg" + e.msg);
					
					$(".res_code").empty();
					$(".res_menu_code").empty();
					$(".res_menu_name").empty();
					$(".res_menu_explan").empty();
					$(".res_menu_price").empty();
		              
					$.each(menuList , function(idx, val) {
			 			$(".res_code").text(val.res_code);
						$(".res_menu_code").text(val.res_menu_code);
						$(".res_menu_name").text(val.res_menu_name); 
						$(".res_menu_explan").text(val.res_menu_explan);
						$(".res_menu_price").text(val.res_menu_price);

					var html = "";
					$("#menuList").empty(); //div
					html += "<table id='menuList';>";
					html += "<tr><th>res_code</th><th>res_menu_code</th><th>res_menu_name</th><th>res_menu_explan</th><th>res_menu_price</th></tr>";

					var menuList = returnFix.btnsearchFix;
					$.each(menuList, function(idx, val) {

					//	html += "<tr> <td>" + res_code + "</td>"
					//	html += "<td>" + res_menu_code + "</td>"
						html += "<h4>" + res_menu_name + "</h4>"
					//	html += "<td>" + res_menu_explan + "</td>"
						html += "<span>" + res_menu_price + "&#8361; </span>"
					});
					$("#menuList").append(html);
				});
				},
				error : function(error) {
					console.log("error" + error);
				}
			});
		});
	</script>
	 -->
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
			<font color="white"> MENU LIST TEST</font>
		</h1>
		<span><font color="orange"> MENU LIST TEST </font></span>
		<br>
		<br>
		<br>



		<div class="container" id="menuList">
		<div class="row">
			
				<div class="panel-body">
				<table width="100%"
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

						<c:forEach items="${menuList}" var="res_code">
							<tr class="odd gradeX">
								<td><c:out value="${res_code.res_code}" /></td>
								<td><a href="/restaurant/menuList/get?res_code=${res_code}"><c:out
											value="${res_code.res_menu_code}" /></a></td>
								<td><c:out value="${res_code.res_menu_name}" /></td>
								<td><c:out value="${res_code.res_menu_explan}" /></td>
								<td><c:out value="${res_code.res_menu_price}" /></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
		</div>
	</div>
</div>





	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>



</body>
</html>


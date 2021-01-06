<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<style>
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Restaurant</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">


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

<div class="fixed-side-navbar">
	<ul class="nav flex-column">
		<li class="nav-item"><a class="nav-link" href="home"><span>Delivery</span></a></li>
		<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
		<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
		<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
		<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
	</ul>
</div>


<div class="parallax-content baner-content" id="home">
	<div class="container">
		<div class="first-content">
			<h1 style="font-size: 100px">Restaurant Write Test</h1>
			<br>
			<p>
				<span><em>Restaurant Write TEST</em></span>
			</p>
			<br> <br>


			<div class="contact-form" style="width: center; height: center">
				<div class="form-group" style="float: center;">
					<form id="contact"
						action="${pageContext.request.contextPath }/file/upload.do"
						method="post"> <!-- 파일 업로드 구현 테스트중임 -->


						<div class="filebox">
							<label><input type="file" name="upload"
								style="font-family: inherit; width: 220px; height: 40px;" /> </label>
						</div>




						<div style="margin: 0 auto; width: 300px;">
						

							<fieldset>

								<input name="RES_NAME" id="RES_NAME" type="text"
									class="form-control" 
									placeholder="Restaurant_name.."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset>

							<fieldset>

								<input name="RES_INFO" type="text" class="form-control"
									id="RES_INFO" placeholder="Restauran_Explan.."
									style="font-family: inherit; width: 300px; height: 150px;">
							</fieldset>

							
								<fieldset>
							
								<input name="DEL_PRICE" id="DEL_PRICE" type="number"
									class="form-control"  placeholder="Del_price .."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset>
							
						
						</div>
						<fieldset>
							<div style="float: center;">
								<p>
									<button type="button" id="insertres" name ="insertres"
										class="btn"	style="font-family: inherit; width: 300px; height: 60px;">WRITE</button>
								</p>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</fieldset>
					</form>
				</div>
			</div>
	</div>
	</div>

	<div class="col-md-6"></div>

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




<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<script>
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>


	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>
	
	<script>
		$(document).ready(
				function() {
					$("#insertres").click(
							function() {
								var json = {
									RES_CODE :  $("#RES_CODE").val(),
									RES_NAME : $("#RES_NAME").val(),
									RES_INFO : $("#RES_INFO").val(),
									DEL_PRICE : $("#DEL_PRICE").val()
									//RES_DATE : $("#RES_DATE").val()
								};

								for (var data in json) {
									if (json[data] == 0) {
										alert($("#" + data).attr("placeholder")
												+ " 정보를 입력해주세요.");
										$("#" + data).focus();
										return false;
									}
								}
									$.ajax({
										type : "GET",
										url : "/restaurant/insertres",
										data : json,
										success : function(string) {
											alert('매장 등록 성공');
											document.location.href="/restaurant/restList";
										},
										error : function(error) {
											alert("에러" + error);
										}
									});
								});
				});
	</script>
</html>

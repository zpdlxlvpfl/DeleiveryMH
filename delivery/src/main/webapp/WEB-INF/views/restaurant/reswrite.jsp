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
		<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
		<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
		<li class="nav-item"><a class="nav-link" href="login.html"><span>LOGIN</span></a></li>
		<li class="nav-item"><a class="nav-link" href="join.html"><span>JOIN</span></a></li>
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
						method="post">


						<div class="filebox">
							<label><input type="file" name="upload"
								style="font-family: inherit; width: 220px; height: 40px;" /> </label>
						</div>




						<div style="margin: 0 auto; width: 300px;">
						
						
						<!-- <fieldset>

								<input name="Restaurant_name" id="RES_CODE" type="number"
									class="form-control" 
									placeholder="Restaurant_name.."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset> -->

							<fieldset>

								<input name="Restaurant_name" id="RES_NAME" type="text"
									class="form-control" 
									placeholder="Restaurant_name.."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset>

							<fieldset>

								<input name="Restauran_Explan" type="text" class="form-control"
									id="RES_INFO" placeholder="Restauran_Explan.."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset>

							<fieldset>
							
								<input name="del_price" id="del_price" type="number"
									class="form-control"  placeholder="Restauran Tel.."
									style="font-family: inherit; width: 300px; height: 40px;">
							</fieldset>
							<fieldset>
							<div id="map"
										style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
										
							<input type="text" id="RES_ADDRESS" placeholder="Address...">
							<input type="text" 
								placeholder="Detailed Address..."> 
								<input type="button" id="addressSearch" onclick="sample5_execDaumPostcode()" 
								value="Address Search" 
								style="width: 300px; height: 40px; text-align: left; font-family: inherit; font-size: 13px; background-color: #fd7e14; color: white;"><br>
							<div id="map"
								style="width: 150px; height: 150px; margin-top: 10px; display: none"></div>
							<script
								src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1ae9605eb7fea18b91aa4e9f1d11e64&libraries=services"></script>

							<script>
										var mapContainer = document
												.getElementById('map'), // 지도를 표시할 div
										mapOption = {
											center : new daum.maps.LatLng(
													37.537187, 127.005476), // 지도의 중심좌표
											level : 5
										// 지도의 확대 레벨
										};

										//지도를 미리 생성
										var map = new daum.maps.Map(
												mapContainer, mapOption);
										//주소-좌표 변환 객체를 생성
										var geocoder = new daum.maps.services.Geocoder();
										//마커를 미리 생성
										var marker = new daum.maps.Marker({
											position : new daum.maps.LatLng(
													37.537187, 127.005476),
											map : map
										});

										function sample5_execDaumPostcode() {
											new daum.Postcode(
													{
														oncomplete : function(
																data) {
															var addr = data.address; // 최종 주소 변수

															// 주소 정보를 해당 필드에 넣는다.
															document
																	.getElementById("RES_ADDRESS").value = addr;
															// 주소로 상세 정보를 검색
															geocoder
																	.addressSearch(
																			data.address,
																			function(
																					results,
																					status) {
																				// 정상적으로 검색이 완료됐으면
																				if (status === daum.maps.services.Status.OK) {

																					var result = results[0]; //첫번째 결과의 값을 활용

																					// 해당 주소에 대한 좌표를 받아서
																					var coords = new daum.maps.LatLng(
																							result.y,
																							result.x);
																					// 지도를 보여준다.
																					mapContainer.style.display = "block";
																					map
																							.relayout();
																					// 지도 중심을 변경한다.
																					map
																							.setCenter(coords);
																					// 마커를 결과값으로 받은 위치로 옮긴다.
																					marker
																							.setPosition(coords)
																				}
																			});
														}
													}).open();
										}
									</script>
							</fieldset>
						</div>
						<fieldset>
							<div style="float: center;">
								<p>
									<button type="button" id="insertres"
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




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
	window.jQuery
			|| document
					.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')
</script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>
	</div>
	</body>
	<script>
		$(document).ready(
				function() {
					$("#insertres").click(
							function() {
								var json = {
									RES_CODE : $("#RES_CODE").val(),
									RES_ADDRESS : $("#RES_ADDRESS").val(),
									RES_NAME : $("#RES_NAME").val(),
									RES_TEL : $("#RES_TEL").val(),
									RES_MENU_EXPLAN : $("#RES_MENU_EXPLAN").val()
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
										type : "get",
										url : "/insertres",
										data : json,
										success : function(string) {
											alert('매장 등록 성공' + string);
											document.location.href="/restaurant/reshome";
										},
										error : function(error) {
											alert("에러" + error);
										}
									});
								});
				});
	</script>

</html>

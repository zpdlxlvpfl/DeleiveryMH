<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Delivery TEST Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">



<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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



</head>


<body>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
			</sec:authorize>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="/admin/memberList?pageNum=1&amount=10&auth=ROLE_MEMBER"><span>#관리자페이지</span></a></li>
			</sec:authorize>
		</ul>
	</div>

	





	<div class="parallax-content contact-content" id="contact-us">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="contact-form">
						<div class="row">
							<form id="contact" action="" method="post">
								<div class="row">
									<div class="col-md-12">
										<fieldset>
											<input name="name" type="text" class="form-control" id="name"
												placeholder="Your name..." required="">
										</fieldset>
									</div>
									<div class="col-md-12">
										<fieldset>
											<input name="email" type="email" class="form-control"
												id="email" placeholder="Your email..." required="">
										</fieldset>
									</div>
									<div class="col-md-12">
										<fieldset>
											<textarea name="message" rows="6" class="form-control"
												id="message" placeholder="Your message..." required=""></textarea>
										</fieldset>
									</div>
									<div class="col-md-12">
										<fieldset>
											<button type="submit" id="form-submit" class="btn">Send
												Message</button>
										</fieldset>
									</div>
								</div>
							</form>
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
	
	
<script>

$(document).ready(function(){
	
	var res_codeValue = res_01; 
	showList();
	function showList(){
		reviewService.getList({res_code:res_codeValue}, function(reviewList){
			var str="";
			for(var i=0, len=reviewList.length || 0; i<len; ++i){
				
			}
		});
	}
	

	var reviewService(function(){
		
		function getList(param, callback, error){
			
			var res_code=param.res_code;
			$.getJSON("/test/reviewList/" + res_code + ".json",
				function(data){
					if(callback){
						callback(data);
					}			
				}).fail(function(xhr, status, err){
			  if(error){
				error();
			  }
			});		
		}
		
		
		return{
			getList : getList
		};
		
	})();


});

</script>
</body>
</html>
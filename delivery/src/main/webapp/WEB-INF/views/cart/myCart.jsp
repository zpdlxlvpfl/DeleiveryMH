<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>장바구니</title>
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>


<body>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<sec:authorize access="isAnonymous()"><li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li></sec:authorize>
			<sec:authorize access="isAnonymous()"><li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li></sec:authorize>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')"><li class="nav-item"><a class="nav-link" href="/admin/memberList?auth=ROLE_MEMBER"><span>#관리자페이지</span></a></li></sec:authorize>
		</ul>
	</div>




	<div class="service-content" id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
				
					<div class="left-text">
						<h4>장바구니</h4>
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
						
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
					<c:forEach items="${cartList }" var="list" varStatus="status">
						<div class="col-md-6">
							<div class="service-item">
								<span style="color:white;" class="close" data-id=@item.RecordId>X</span>
								<h4><c:out value="${list.res_menu_name }" /></h4>
								<div class="line-dec"></div>
								<p style="color:grey;"><c:out value="${list.res_menu_price }" />원</p>
								<p><c:out value="${list.sum }" />원</p>
								<p><button><b>-</b></button> <c:out value="${list.amount }" />개 <button><b>+</b></button></p>
								<input type="hidden" id="cart_no" name="cart_no" value='<c:out value="${list.cart_no }" />'>
								<input type="hidden" id="${status.count}" disabled>
							</div>
						</div>
					</c:forEach>		
					</div>
				</div>
			</div>
		</div>
		<div style="color:white;" align="center">
			<h4>총 주문금액 <b>${sumTotal }원</b></h4>
		</div>
		<br />
		<div class="primary-button"  align="center">
			<a href="#">주문하기</a>
		</div>
	</div>



	<div class="parallax-content projects-content" id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="owl-testimonials" class="owl-carousel owl-theme">
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/1st-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/1st-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/2nd-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/2nd-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/3rd-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/3rd-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/4th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/4th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/5th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/5th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/6th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/6th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
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


<!-- 
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
	<script>
		window.jQuery
				|| document
						.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
	</script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>


<script>
$(document).ready(function(){
	
	
	$(".close").on("click",function(){
		
		
	});
	
function removeMenu(){
		
		var sendData = { cart_no : $("#cart_no").val() };
		
		$.ajax({
			type : "post",
			url : "/cart/RemoveMenu",
			data : JSON.stringify(sendData),
			beforeSend : function(xhr)
            { xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
 			dataType : "text json",
 			contentType : "application/json; charset=UTF-8",
			success : function(result){
				console.log("성공");
			},
			error : function(error){
				console.log("실패");
			}
		})
			
	}	
	
});


</script>


</body>
</html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
var ResInfo = $("#ResInfo");
	$(document)
			.ready(
					function(ResInfo) {
						$.ajax({
									url : "/restaurant/ResInfo",
									beforeSend : function(xhr)
									{ xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
									type : "POST",
									contentType : "application/json; charset=utf-8;",
									dataType : "json",
									data : JSON.stringify({
										RES_CODE : "RES_CODE",
										ID : "ID",
										EMail : "EMail",
										M_NAME : "M_NAME",
										TEL : "TEL",
										ADDRESS : "ADDRESS",
										MEMBER_DATE : "MEMBER_DATE"
									}),
									error : function(error,xhr) {
										alert('error' + data);
										console.log("error " + data);

									},
									success : function(data,xhr) {
										alert('success' + data);
										console.log("success" + data);
									}
								});
							});

</script>


</head>


<body>



	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="15px";>Restaurant Info</font>
		</h1>
		<span><font color="orange" size="5px";>Restaurant Info </font></span>

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





			
			
			
			
	<div class="parallax-content contact-content " id="contact-us">
 <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">RES NAME :</th>
                     <th scope="col">OWNER NAME :</th>
                    <th scope="col">RES ADDR :</th>
                    <th scope="col">OWNER Email :</th>
                    <th scope="col">RES TEL : </th>
                     <th scope="col">RES DATE : </th>
                   </tr>
                </thead>
                <c:forEach items="${ResInfo }" var="RES_CODE">
                <tbody>
                  <tr class="table-light">
                    <th scope="row">
                    <c:out value="${RES_CODE.RES_CODE }" /></th>
                    <td><c:out value="${RES_CODE.RES_NAME }" /></td>
                     <td><c:out value="${RES_CODE.M_NAME }" /></td>
                    <td><c:out value="${RES_CODE.RES_ADDRESS }" /></td>
                    <td><c:out value="${RES_CODE.RES_Email }" /></td>
                    <td><c:out value="${RES_CODE.RES_TEL}" /> </td>
                    <td id="ResInfo"><c:out value="${ResInfo }" /></td>
                  </tr> 
                  </c:forEach>                     
                </tbody>
              </table>       
          

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
</html>
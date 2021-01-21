<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page
	import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
	window.jQuery
			|| document
					.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
</script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>
	
	
	



<body>
<div class="parallax-content contact-content " id="contact-us">
<div class="contact-form">
               <div class="form-group">
               
               <div style="margin: 0 auto; width: 300px;">
    	<form id = "frm" method="get">
        <label> <font color="white"> food Name : </font> </label><input name = "res_menu_name" type = "text" value = "${vo.res_menu_code}">
        <label> <font color="white"> food Name : </font> </label><input name = "res_menu_name" type = "text" value = "${vo.res_menu_name}">
        <br>
        <label><font color="white"> food explan : </font> </label> <input name = "res_menu_explan" type = "text" value = "${vo.res_menu_explan}">
        <br>
        <label><font color="white"> food price : </font> </label><input name = "res_menu_price" type = "text" value = "${vo.res_menu_price}">
    </form>
    <div class="primary-button">
    <button type="button" id="update_btn" class="btn" name="update_btn"
   style="font-family: inherit; color:white; background-color:#FE9A2E; width: 50px; height: 50px;" >Update</button>
</div>
</div>
</div>
</div>
	</div>
	
<script>
  $("#update_btn").click(function(){
	        var frm = $("#frm").serialize(); 
	        var res_menu_code = $("#res_menu_code").val(); 
	        $.ajax({
	            type : "get", 
	            url : "/restaurant/updateMenu", 
	            data : frm, 
	            async : false, 
	            dataType : "json", 
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	            success : function(data){
	                $(opener.document).find("<h4 id=" + res_menu_name + ">").text(data.res_menu_name); 
	                $(opener.document).find("<p id=" + res_menu_explan + ">").text(data.res_menu_explan);
	                $(opener.document).find("<span id=" + res_menu_price + ">").text(data.res_menu_price); 
	                self.close(); 
	            },
	            error: function(error){
	            	console.log("error" + data);
	            }
	        });
	    });

  </script>





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
</body>
</html>
</html>



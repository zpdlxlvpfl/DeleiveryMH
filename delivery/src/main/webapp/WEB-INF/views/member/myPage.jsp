<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>#MyPage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/fontAwesome.css">
        <link rel="stylesheet" href="../resources/css/hero-slider.css">
        <link rel="stylesheet" href="../resources/css/templatemo-main.css">
        <link rel="stylesheet" href="../resources/css/owl-carousel.css">



        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

        <script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>


<body>

    <div class="fixed-side-navbar">
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link" href="#home"><span>Delivery</span></a></li>
            <li class="nav-item"><a class="nav-link" href="#services"><span>Services</span></a></li>
            <li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
            <li class="nav-item"><a class="nav-link" href="join.html"><span>JOIN</span></a></li>
            <li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
            <li class="nav-item"><a class="nav-link" href="#AAA"><span>MyPage</span></a></li>
        </ul>
    </div>

    <div class="parallax-content baner-content" id="home">
        <div class="container">
            <div class="first-content">
                <h1>#MyPgae</h1>
                <span><em>##</em>####</span>
                <div class="primary-button"> <br>
                    <a href="#services">More</a>
                </div>
                
                <div class="primary-button"> <br>
                <sec:authorize access="isAuthenticated()">
                <a href="/member/myInfo">내정보보기</a>
                </sec:authorize>
                </div>
                         
              	
                <form action="/logout" method="post">				
                <div class="primary-button"> <br>
                <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />  
				<sec:authorize access="isAuthenticated()">
				<button type="submit">로그아웃</button>
				</sec:authorize>           		          
                </div>
                </form>
                
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



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
    <script src="../resources/js/vendor/bootstrap.min.js"></script>
    <script src="../resources/js/plugins.js"></script>
    <script src="../resources/js/main.js"></script>


</body>
</html>
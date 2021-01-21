<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="kr">

  <head>
    <meta charset="utf-8">
    <title>#배달웹서비스</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../resources/docs/4/minty/bootstrap.css">
    <link rel="stylesheet" href="../resources/docs/_assets/css/custom.min.css">
    <!-- Global Site Tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23019901-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];
      function gtag(){dataLayer.push(arguments);}
      gtag('js', new Date());

      gtag('config', 'UA-23019901-1');
    </script>
  </head>
  <body>
  <div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
      <div class="container">
        <a href="../" class="navbar-brand">#배달웹서비스</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/">Main</a>
            </li>          
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">더보기 <span class="caret"></span></a>
              <form name="Logout" action="/logout" method="post">
              <div class="dropdown-menu" aria-labelledby="download">
              <sec:authorize access="hasRole('ROLE_MEMBER')">
                <a class="dropdown-item" rel="noopener" href="/cart/myCart">장바구니</a>
              </sec:authorize>
              <sec:authorize access="hasRole('ROLE_MEMBER')">
                <a class="dropdown-item" href="#">주문내역</a>
              </sec:authorize>
              <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a class="dropdown-item" href="/admin/memberList?pageNum=1&amount=10&auth=ROLE_MEMBER">회원목록</a>
                <div class="dropdown-divider"></div>
              </sec:authorize>
              	<a class="dropdown-item" href="/member/myInfo">회원정보</a>
                <a class="dropdown-item" href="#" onclick="javascript:document.Logout.submit();">로그아웃</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/member/withdrawal">회원탈퇴</a>
              </div>
              <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />  
   			 </form>
            </li>
          </ul>
        </div>
      </div>
    </div>
    
    

<!--     <div class="container"> -->
<!--       <div class="page-header" id="banner"> -->
<!--         <div class="row"> -->
<!--           <div class="col-lg-8 col-md-7 col-sm-6"> -->
<!--             <h1>Minty</h1> -->
<!--             <p class="lead">A fresh feel</p> -->
<!--           </div> -->
<!--           <div class="col-lg-4 col-md-5 col-sm-6"> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
  
<!--     <div class="container"> -->
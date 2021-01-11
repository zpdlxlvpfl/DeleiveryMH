<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<div class="container">
      <div class="page-header" id="banner">
        <div class="row">
          <div class="col-lg-8 col-md-7 col-sm-6">
            <h2>관리자페이지</h2>
            <p class="lead">#####</p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>

      <!-- Tables
      ================================================== -->
      <div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
              <h2 id="tables">회원목록</h2>
            </div>
              
           
              <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <div class="collapse navbar-collapse" id="navbarColor01">
                  <ul class="navbar-nav mr-auto">              
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">권한</a>
                      <div class="dropdown-menu">
                        <a class="dropdown-item" href="/admin/memberList?auth=ROLE_MEMBER">일반회원</a>
                        <a class="dropdown-item" href="/admin/memberList?auth=ROLE_RES">매장</a>
                        <a class="dropdown-item" href="/admin/memberList?auth=ROLE_ADMIN">관리자</a>
                      </div>
                    </li>
                  </ul>
                  <form class="form-inline my-2 my-lg-0" action="/admin/search" method="get">
                    <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="Search">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                  </form>
                </div>
              </nav>
       

              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">아이디</th>
                    <th scope="col">이름</th>
                    <th scope="col">이메일</th>
                    <th scope="col">전화번호</th>
                    <th scope="col">권한</th>
                  </tr>
                </thead>
                <c:forEach items="${memberList }" var="member">
                <tbody>
                  <tr class="table-light">
                    <th scope="row"><a href="/admin/memberInfo?id=${member.id }"><c:out value="${member.id }" /></a></th>
                    <td><c:out value="${member.m_name }" /></td>
                    <td><c:out value="${member.email }" /></td>
                    <td><c:out value="${member.tel }" /></td>
                    <td id="authT"><c:out value="${member.auth }" /></td>
                  </tr> 
                  </c:forEach>                     
                </tbody>
              </table>       
          </div>
        </div>
      </div>
 
 
<!--   modal  -->
<!-- <div id="d_Modal" class="modal"> -->
<!--   <div class="modal-dialog" role="document"> -->
<!--     <div class="modal-content"> -->
<!--       <div class="modal-header"> -->
<!--         <h5 class="modal-title">회원삭제</h5> -->
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--           <span aria-hidden="true">&times;</span> -->
<!--         </button> -->
<!--       </div> -->
<!--       <div class="modal-body"> -->
<%--         <p><c:out value="${deleteId }"/> 회원을 삭제했습니다.</p> --%>
<!--       </div> -->
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-primary" data-dismiss="modal">#확인?</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->

      
<script>


//첫줄만 바뀌는거 고치기!
$(document).ready(function(){
	 var auth=$("#authT").val();
	 if(auth == "ROLE_MEMBER"){
	  $("#authT").text("일반회원");		 
	 }else if(auth == "ROLE_RES"){
	  $("#authT").text("매장");
	 }else{
	  $("#authT").text("관리자");
	 }
	
// 	 var auth='<c:out value="${member.auth}" />';
// 	 if(auth == "ROLE_MEMBER"){
// 	  $("#authT").html("일반회원");		 
// 	 }else if(auth == "ROLE_RES"){
// 	  $("#authT").html("매장");
// 	 }else{
// 	  $("#authT").html("관리자");
// 	 }
 	  
});  
  
</script>
  
  
<%@include file="../includes/footer.jsp" %>

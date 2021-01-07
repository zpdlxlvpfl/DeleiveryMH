<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="../includes/header.jsp" %>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<div class="container">
      <div class="page-header" id="banner">
        <div class="row">
          <div class="col-lg-8 col-md-7 col-sm-6">
            <h2>비밀번호 확인</h2>
            <p class="lead">#####</p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>
 

<form action="checkPw" method="post">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">비밀번호 입력 부탁???</label>
	    <input name="pw" class="form-control" id="readOnlyInput" type="text">
	  </fieldset>
	  <p></p>
	  <button type="submit" class="btn btn-warning">확인??</button>
	  <button type="button" id="cancel" class="btn btn-info">취소???</button>
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</div>
</form>


<script>




$("#cancel").on("click", function(){ //취소누르면 내정보로 이동
	self.location="/member/myInfo";
});
	
</script>

<%@include file="../includes/footer.jsp" %>
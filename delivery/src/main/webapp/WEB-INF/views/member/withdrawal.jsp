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
            <h2>회원 탈퇴</h2>
            <p class="lead"><font color="red"><c:out value="${result}" /></font></p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>
 

<form name="withdrawal">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">비밀번호를 입력해주세요</label>
	    <input name="pw" maxlength="20" class="form-control" id="pw" type="password">
	  </fieldset>
	  <p></p>
	  <button type="button" id="withdrawalC" class="btn btn-warning">탈퇴</button>
	  <button type="button" id="cancel" class="btn btn-info">취소</button>
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</div>
</form>


<!-- modal -->
<div id="w_Modal" class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">회원탈퇴</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>탈퇴하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="AAA">탈퇴</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>

<script>


$(document).ready(function(){	
	
	function clickwithdrawal(formName) {
		formName.action = "/member/withdrawal";
		formName.method = "post";
		formName.submit();
	}
	

	$("#withdrawalC").on("click", function(){ //탈퇴 누르면 모달창 띄우기
		$("#w_Modal").modal("show");
		
	});
	
	$(document).on("click","#AAA",function(e){ //모달창에서 탈퇴 누르면 탈퇴 진행
		clickwithdrawal(withdrawal);
	});
	

	$("#cancel").on("click", function(){ //취소누르면 내정보로 이동
		self.location="/member/myInfo";
	});	
});

	
</script>

<%@include file="../includes/footer.jsp" %>
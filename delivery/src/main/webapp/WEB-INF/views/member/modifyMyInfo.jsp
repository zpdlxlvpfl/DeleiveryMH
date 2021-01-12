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
            <h2>회원정보 수정</h2>
            <p class="lead">#####</p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>

<form name="updatemyInfo">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">아이디</label>
	    <input name="id" class="form-control" id="readOnlyInput" type="text" value='<c:out value="${myInfo.id }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">이름</label>
	    <input id="m_name" name="m_name" maxlength="20" class="form-control" type="text" value='<c:out value="${myInfo.m_name }"/>'>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">이메일</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${myInfo.email }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">주소</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${myInfo.address }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">전화번호</label>
	    <input id="tel" name="tel" class="form-control" type="text" value='<c:out value="${myInfo.tel }"/>'>
	  </fieldset>
	  <p></p>
	  <button type="button" id="m_Info" class="btn btn-warning">수정하기</button>
	  <button type="button" id="myInfo" class="btn btn-info">취소</button>
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</div>
</form>

<!-- modal -->
<div id="m_Modal" class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">내정보수정</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>수정사항을 저장하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="clickModi(updatemyInfo)">저장</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>

<script>

function clickModi(formName) {
	formName.action = "/member/modifyMyInfo";
	formName.method = "post";
	formName.submit();
}

$("#m_Info").on("click", function(){
	var m_name = $("#m_name").val();
	var tel = $("#tel").val();
	if(m_name=="" || tel==""){
		alert("정보를 입력해주세요");
	}else{
		$("#m_Modal").modal("show");
	}
	
});


$("#myInfo").on("click", function(){ //취소누르면 내정보로 이동
	self.location="/member/myInfo";
});
	
</script>

<%@include file="../includes/footer.jsp" %>
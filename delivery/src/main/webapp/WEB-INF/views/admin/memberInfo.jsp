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
            <h2>회원정보</h2>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>

<form name="removeMember">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">아이디</label>
	    <input name="id" class="form-control" id="readOnlyInput" type="text" value='<c:out value="${memberInfo.id }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">이름</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${memberInfo.m_name }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">이메일</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${memberInfo.email }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">주소</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${memberInfo.address }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">전화번호</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${memberInfo.tel }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">가입날짜</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<c:out value="${member_date }"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">권한</label>
	    <input class="form-control" id="auth" type="text" value='<c:out value="${memberInfo.auth }"/>' readonly>
	  </fieldset>
	  <p></p>
	  <button type="button" id="d_member" class="btn btn-outline-danger">회원삭제</button>
	  <button type="button" id="mList" class="btn btn-outline-info">목록보기</button>
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</div>
</form>

<!-- modal -->
<div id="d_Modal" class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">회원삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p><c:out value="${memberInfo.id }"/> 회원을 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="clickDel(removeMember)">삭제</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>


<script>

function clickDel(formName) {
	formName.action = "/admin/deleteMember";
	formName.method = "post";
	formName.submit();
}

$("#d_member").on("click", function(){
	$("#d_Modal").modal("show");
});

$("#mList").on("click", function(){ 
	history.back(); //목록보기 누르면 이전으로
	//self.location="/admin/memberList?auth=<c:out value="${memberInfo.auth}"/>"; //목록보기 누르면 멤버리스트로 이동
});

if($("#auth").val()=="ROLE_MEMBER"){
	$("#auth").val("일반회원");
}else if($("#auth").val()=="ROLE_RES"){
	$("#auth").val("매장");
}else if($("#auth").val()=="ROLE_ADMIN"){
	$("#auth").val("관리자");
}



</script>


<%@include file="../includes/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="../includes/header.jsp" %>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<form name="updatemyInfo">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#아이디</label>
	    <input name="id" class="form-control" id="readOnlyInput" type="text" value='<sec:authentication property="principal.memberVO.id"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#이름</label>
	    <input name="m_name" maxlength="20" class="form-control" id="readOnlyInput" type="text" value='<sec:authentication property="principal.memberVO.m_name"/>'>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#Email address</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#">
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#주소</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#">
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#전화번호</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#">
	  </fieldset>
	  <p></p>
	  <button type="button" id="m_Info" class="btn btn-warning">수정하기</button>
	  <button type="button" id="myInfo" class="btn btn-info">#취소</button>
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
        <p>#변경?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="clickDel(updatemyInfo)">Save Changes</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script>

function clickDel(formName) {
	formName.action = "/member/modifyMyInfo";
	formName.method = "post";
	formName.submit();
}

$("#m_Info").on("click", function(){
	$("#m_Modal").modal("show");
});


$("#myInfo").on("click", function(){ //취소누르면 내정보로 이동
	self.location="/member/myInfo";
});
	
</script>

<%@include file="../includes/footer.jsp" %>
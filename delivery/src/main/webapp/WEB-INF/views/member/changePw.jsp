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
            <h2>비밀번호 변경</h2>
            <p class="lead"><h6>비밀번호는 영문자, 숫자, 특수문자 조합으로 최소 12자리 이상 20자리 이내로 등록하셔야 합니다.</h6><p>
            <p class="lead"><font color="red"><c:out value="${result}" /></font></p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
          </div>
        </div>
      </div>
 

<form name="changePw">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">현재 비밀번호</label>
	    <input name="pw" maxlength="20" class="form-control" id="pw" type="password">
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">새로운 비밀번호</label>
	    <input name="newPw" maxlength="20" class="form-control" id="newPw" type="password">
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">새로운 비밀번호 확인</label>
	    <input maxlength="20" class="form-control" id="check" type="password">
	  </fieldset>
	  <p></p>
	  <button type="button" id="change" class="btn btn-warning">변경</button>
	  <button type="button" id="cancel" class="btn btn-info">취소</button>
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</div>
</form>


<!-- modal -->
<div id="c_Modal" class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">비밀번호 변경</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>비밀번호를 변경하시겠습니까?</p>
      </div>
      <div class="modal-footer">
<!--         <button type="button" class="btn btn-secondary" id="update">변경</button> -->
<!--         <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button> -->
      </div>
    </div>
  </div>
</div>

<script>


$(document).ready(function(){	
	
	function clickChange(formName) {
		formName.action = "/member/changePw";
		formName.method = "post";
		formName.submit();
	}
	

	$("#change").on("click", function(){
		
		if($("#newPw").val()==$("#check").val()){ //새로운 비밀번호와 비밀번호확인이 일치할 때
			if(checkPw()==true){ //영문자,숫자,특수문자 조합으로 12자~20자로 비번이 입력됐다면 
				$(".modal-body").html("비밀번호를 변경하시겠습니까?");
				$(".modal-footer").html('<button type="button" class="btn btn-secondary" id="update">변경</button><button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>');
				$("#c_Modal").modal("show");
			}		
		}else{
			$(".modal-body").html("새로운 비밀번호가 일치하지 않습니다.");
			$(".modal-footer").html('<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>');
			$("#c_Modal").modal("show");
		}	
	});
	
	$(document).on("click","#update",function(e){ //모달창에서 변경버튼 누르면 비밀번호 변경실행
		clickChange(changePw);
	});
	
	
	
	
	$("#cancel").on("click", function(){ //취소누르면 내정보로 이동
		self.location="/member/myInfo";
	});
	
		
	function checkPw(){ //비밀번호 체크 
		var password = $("#newPw").val();
		var num = password.search(/[0-9]/g);
		var eng = password.search(/[a-z]/ig);
		var spe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
		$(".modal-footer").html('<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>');
		
		if(password.length < 12 || password.length > 20){
			$(".modal-body").html("비밀번호는 최소 12자리 이상 20자리 이내로 입력해야 합니다.");
			$("#c_Modal").modal("show");
			return false;
		}else if(password.search(/\s/) != -1){
			$(".modal-body").html("비밀번호는 공백 없이 입력해야 합니다.");
			$("#c_Modal").modal("show");
			return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
			$(".modal-body").html("비밀번호는 영문자, 숫자, 특수문자 조합으로 입력해야 합니다.");
			$("#c_Modal").modal("show");
			return false;
		}else {
			return true;
		}		
	}
		
	
});

	
</script>

<%@include file="../includes/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="../includes/header.jsp" %>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<form action="modifyMyInfo" method="get">
	<div class="form-group">
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#아이디</label>
	    <input name="id" class="form-control" id="readOnlyInput" type="text" value='<sec:authentication property="principal.CustomerVO.id"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#이름</label>
	    <input class="form-control" id="readOnlyInput" type="text" value='<sec:authentication property="principal.CustomerVO.m_name"/>' readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#Email address</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#" readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#주소</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#" readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#전화번호</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#" readonly>
	  </fieldset>
	  <fieldset>
	    <label class="control-label" for="readOnlyInput">#가입날짜</label>
	    <input class="form-control" id="readOnlyInput" type="text" value="#" readonly>
	  </fieldset>
	  <p></p>
	  <button type="submit" class="btn btn-warning">정보수정</button>
	  <button type="button" id="mList" class="btn btn-info">#####</button>
	
	</div>
</form>



<%@include file="../includes/footer.jsp" %>
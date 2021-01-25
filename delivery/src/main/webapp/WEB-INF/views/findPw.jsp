<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>


  .form-inline label {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: center;
    justify-content: center;
    margin-bottom: 0
  }
  .form-inline .form-group {
    display: -ms-flexbox;
    display: flex;
    -ms-flex: 0 0 auto;
    flex: 0 0 auto;
    -ms-flex-flow: row wrap;
    flex-flow: row wrap;
    -ms-flex-align: center;
    align-items: center;
    margin-bottom: 0
  }
  .form-inline .form-control {
    display: inline-block;
    width: auto;
    vertical-align: middle
  }
  .form-inline .form-control-plaintext {
    display: inline-block
  }
  .form-inline .custom-select, .form-inline .input-group {
    width: auto
  }
  .form-inline .custom-control {
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: center;
    justify-content: center
  }
  .form-inline .custom-control-label {
    margin-bottom: 0
  }
}

</style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>비밀번호 찾기</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
			<li class="nav-item"><a class="nav-link" href="/"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="/foodmaptest"><span>Search</span></a></li>
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="/login"><span>LOGIN</span></a></li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="/join"><span>JOIN</span></a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_MEMBER')">
				<li class="nav-item"><a class="nav-link" href="/cart/myCart"><span>CART</span></a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item"><a class="nav-link" href="/member/myInfo"><span>MYPAGE</span></a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="/admin/memberList?pageNum=1&amount=10&auth=ROLE_MEMBER"><span>ADMINPAGE</span></a></li>
			</sec:authorize>
		</ul>
	</div>


        <div class="parallax-content baner-content" id="home">
            <div class="container">
                <div class="first-content">

                    <p> <span><em>비밀번호</em> 찾기</span> </p> <br>
      



                    <div class="form-group">
                    	<div style="margin: 0 auto; width: 300px;">
                        <form id="contact" method="post"> 
                            <fieldset>
                                    <input name="email" class="group" type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요" style=" font-family:inherit; width:300px; height:40px;">
                            </fieldset>
                            <fieldset>
                                    <input name="m_name" type="text" class="form-control" id="m_name" placeholder="이름을 입력해주세요" style=" font-family:inherit; width:300px; height:40px;">
                            </fieldset>
                            
                            <fieldset>
                                    <input name="id" type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요" style=" font-family:inherit; width:300px; height:40px;">
                            </fieldset>                                               
                                
                                <input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }" id="csrf" />
                                        <a href="/findId" style="color:white; text-decoration:none; text-shadow: 1px 1px 5px #000;">아이디 찾기</a>   
                                        <p></p>      
                                    <p> <button type="button" id="find" class="btn" style=" font-family:inherit; width:300px; height:50px;">비밀번호 찾기</button></p>                                
                                </form>
                    </div>
                    </div>
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


<!-- modal -->
<div id="d_Modal" class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">비밀번호 찾기</h5>
      </div>
      <div class="modal-body">
        <p>메일을 발송 중입니다. 창을 닫지 마시고 조금만 기다려주세요.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
      </div>
    </div>
  </div>
</div>



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="../resources/js/vendor/bootstrap.min.js"></script>
        <script src="../resources/js/plugins.js"></script>
        <script src="../resources/js/main.js"></script>
        
        
<script>

$(document).ready(function(){
	
	$("#find").on("click",function(e){
		e.preventDefault();
		findPw();
		$(".modal-body").html("메일을 발송 중입니다. 창을 닫지 마시고 조금만 기다려주세요.");
		$("#d_Modal").modal("show");
	});
	
function findPw(){
		
		var sendData = { email : $("#email").val(), m_name : $("#m_name").val(), id : $("#id").val() };
		
		$.ajax({
			type : "post",
			url : "/email/findPw",
			data : JSON.stringify(sendData),
			beforeSend : function(xhr)
            { xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
 			dataType : "text json",
 			contentType : "application/json; charset=UTF-8",
//  			모달창으로 메세지 뜸(메일발송, 메일발송오류, 없는 회원)
			success : function(result){
				$(".modal-body").html(result);
			},
			error : function(request, error){
				alert(error);
			}
		})
			
	}	
	
});

</script>
    </body>
    </html>
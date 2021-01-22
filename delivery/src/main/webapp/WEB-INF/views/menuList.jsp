<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Delivery TEST Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">



<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">



<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script
	src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<script>
	window.jQuery
			|| document
					.write('<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>


</head>


<body>



	<div class="parallax-content projects-content" id="portfolio">

		<h1>
			<font color="white" size="15px">Restaurant Home</font>
		</h1>
		<span><font color="orange" size="5px">Restaurant Home </font></span>

	</div>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>




	<div class="service-content" id="services">

		<div class="row">
			<div class="col-md-12">
				<div id="owl-testimonials" class="owl-carousel owl-theme">


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/0st-item.jpg" alt="">
										<c:forEach items="${menuList}" var="RES_CODE" begin="0"
										end="0" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
											<input type="hidden" value='<c:out value="${RES_CODE.RES_CODE}"/>'>
										</c:forEach>
									
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/1st-item.jpg" alt="">
										<c:forEach items="${menuList}" var="RES_CODE" begin="1"
										end="1" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
										</c:forEach>
									
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/2nd-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="2"
										end="2" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
									</c:forEach>
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/3rd-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="3"
										end="3" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
									</c:forEach>
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/4th-item.jpg" alt="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="4"
										end="4" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
									</c:forEach>
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
									<img src="../resources/img/5th-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="5"
										end="5" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
									</c:forEach>
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-8">
						<div class="left-text">
							<div class="testimonials-item">
								<div class="service-item">
								<img src="../resources/img/6th-item.jpg" alt="" id="">
									<c:forEach items="${menuList}" var="RES_CODE" begin="6"
										end="6" step="1" varStatus="i">
										<h4>
											<c:out value=" ${RES_CODE.res_menu_name}">
											</c:out>
										</h4>
										<div class="line-dec"></div>
										<p>
											<c:out value=" ${RES_CODE.res_menu_explan}" />
										</p>
										<span><c:out value="${RES_CODE.res_menu_price}"></c:out>
											&#8361;</span>
											<br />
											<input id="amount" type="number" name="amount" min="0" max="20" value="1">
											<input id="rRes_menu_code" type="hidden" value='<c:out value="${RES_CODE.res_menu_code}"/>'>
									</c:forEach>
									<div class="primary-button">
										<a class="btn" id="cartClick">cart</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>




<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username" var="user_id" />
	<input type="hidden" id="user_id" value="${user_id }">
</sec:authorize>


	<div class="parallax-content contact-content" id="contact-us">
		<div class="container" id="AAA">
			<div class="row">
				<div class="col-md-6"> 
					<div id="reviewF" class="contact-form">
					<p style="color:yellow;"><em>평균 별점</em></p>
						<div class="row">						
								<div class="row" >							
									<div id="m_name" class="col-md-12" style="color:white;">
										사용자
									</div>
									<div id="rate" class="col-md-12" style="color:white;">
										별점
									</div>
									<div class="col-md-12">
										<fieldset>
											<textarea name="message" rows="3" cols="40" class="form-control"
												id="content"></textarea>
										</fieldset>
									</div>
								</div>
						</div>
					</div>
				</div>
				
				
				<div class="col-md-6">
					<div class="map">
							<form id="contact">
								<div class="row">
								<div style="color:white; text-align:text-align:justify;"><h4><b>&nbsp;&nbsp;&nbsp;&nbsp;리뷰등록</b></h4></div>
									<div class="col-md-12" style="float:right;">
										
											<select name="rate" id="rRate" style="color:#FFA62F; float:right;">
											  <option value="5" selected="selected">★★★★★</option>
											  <option value="4">★★★★</option>
											  <option value="3">★★★</option>
											  <option value="2">★★</option>
											  <option value="1">★</option>
											</select>
										
									</div>
							
									<div class="col-md-12">
										
											<textarea name="content" rows="6" class="form-control"
												id="rContent" maxlength="200" required=""></textarea>
										
									</div>
									<div class="col-md-12">
										<fieldset>
											<button type="button" id="register" class="btn">리뷰등록</button>
										</fieldset>
									</div>
								</div>
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
        <h5 class="modal-title">리뷰</h5>
      </div>
      <div class="modal-body">
        <p>리뷰를 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="ok">확인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="CModal">취소</button>
      </div>
    </div>
  </div>
</div>


	<script type="text/javascript">
	var RES_CODE = $(RES_CODE);
	var res_menu_code = $(res_menu_code);
	
	function menuList() {

		restaurantService.menuList(function(menuList) {
				$.ajax({
				url : "/restaurant/menuList",
				type : "GET",
				contentType : "application/json; charset=utf-8;",
				dataType : "json",
				data : {
					RES_CODE : "${RES_CODE}",
					res_menu_code : "${res_menu_code}",
					res_menu_name : "${res_menu_name}",
					res_menu_explan : "${res_menu_explan}",
					res_menu_price : "${res_menu_price}"
				},
				error : function(error) {
					console.log("error " + data);

				},
				success : function(data) {
					alert('success' + data);
					console.log("success" + data);
				}
			});
		});
	}
	</script>


	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>
	
	
<script>
//리뷰 관련 + 장바구니 담기
$(document).ready(function(){
	//~~~장바구니~~~
	var cartService=(function(){
		//장바구니 담기
		function put(menu, callback, error){
			$.ajax({
				type : "post",
				url : "/cart/insert",
				data : JSON.stringify(menu),
				beforeSend : function(xhr)
				{ xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr){
					alert("장바구니에 메뉴를 추가했습니다.");
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){	
					alert("장바구니에는 같은 가게의 메뉴만 담을 수 있습니다. 장바구니를 비워주세요");
					if(error){
						error(er);
					}
				}
			})
		}
		return {
			put : put
		}
	})();
	

	$(document).on("click","#cartClick",function(){
		
		if($("#user_id").val()!=undefined){ //로그인한 상태일 때만 장바구니 담기 가능				
			var menu={ res_code:res_codeValue,
					   res_menu_code:$(this).parent().parent().find("#rRes_menu_code").val(),
					   amount:$(this).parent().parent().find("#amount").val() };
		
			cartService.put(menu,function(result){
				
			});	
		}else{ //로그인하지 않고 cart 눌렀을 때 경고창 띄우기
			alert("로그인 후 장바구니를 담을 수 있습니다.");	
		}			
	});
	
	
	//~~~리뷰~~~
	var reviewService=(function() {
		
		//리뷰보기
		function getList(res_code, callback, error){			
			
			$.getJSON("/review/reviewList/" + res_code + ".json",
				function(data){
					if(callback){
						callback(data);
					}			
				}).fail(function(xhr, status, err){
			  if(error){
				error();
			  }
			});		
		}
		
		//리뷰 삭제
		function remove(review_no, callback, error){		
			$.ajax({
				type : "delete",
				url : "/review/" + review_no,
				beforeSend : function(xhr)
				{ xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
				success : function(deleteResult, status, xhr){
					if(callback){
						callback(deleteResult);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
				
			});
		}
		
		//리뷰 수정
		function modify(review, callback, error){
			$.ajax({
				type : "put",
				url : "/review/" + review.review_no,
				data : JSON.stringify(review),
				contentType : "application/json; charset=utf-8",
				beforeSend : function(xhr)
				{ xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
				success : function(result, status, xhr){
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
			});			
		}
		
		//리뷰 등록
		function insert(review, callback, error){
			$.ajax({
				type : "post",
				url : "/review/register",
				data : JSON.stringify(review),
				contentType : "application/json; charset=utf-8",
				beforeSend : function(xhr)
				{ xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}"); },
				success : function(result, status, xhr){
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){
					alert("주문내역이 있어야만 리뷰등록이 가능합니다.");
					if(error){
						error(er);					
					}
				}
			})
		}
		
		return{
			getList : getList,
			remove : remove,
			modify : modify,
			insert : insert
		};
		
	})();
	
	
	var res_codeValue = "${menuList[0].RES_CODE}";
	var reviewF=$("#reviewF");
	console.log("어디가게"+res_codeValue);
	showList(res_codeValue);
	//리뷰 목록 불러오기
	function showList(res_code){
		
		reviewService.getList(res_code, function(reviewList){
			var str="";
			
			if(reviewList.length!=0){ //리뷰목록이 있으면
				str='<p style="color:#FFA62F;"><em>평균 별점&nbsp;&nbsp;</em><b>'+reviewList[0].avgRate+'</b></p><div class="row"><div class="row">';
				for(var i=0, len=reviewList.length || 0; i<len; ++i){
					
					var review_id=reviewList[i].id;
					
					str+='<div id="m_name" class="col-md-12" style="color:white;">'+reviewList[i].m_name+' <h6><em style="color:#F0FFF0;">작성일 : '+reviewList[i].s_date+'</em></h6></div>';
					str+='<div id="rate" class="col-md-12" style="color:#FFA62F;">별점 '+reviewList[i].s_rate+'</div>';
					str+='<div id="A'+reviewList[i].review_no+'" class="col-md-12"><fieldset id="B"><textarea maxlength="200" name="content" rows="3" cols="40" class="form-control" id="content" readonly>'+
					reviewList[i].content+'</textarea></fieldset></div>';
					//해당 리뷰를 쓴 아이디와 로그인한 회원의 아이디가 같으면 수정, 삭제 버튼 보이게하기
					if(review_id==$("#user_id").val()){
						str+='&nbsp;&nbsp;&nbsp;&nbsp;<p style="cursor:pointer; color:white;" id="'+reviewList[i].review_no+'" class="update">수정</p>&nbsp;&nbsp;'+
						'<p style="cursor:pointer; color:white;" id="'+reviewList[i].review_no+'" class="delete">삭제</p>';
					}
				}
			}else{ //리뷰가 없으면
				str='<div class="row"><div class="row"><div class="col-md-12" style="color:white;">리뷰가 아직 없습니다.</div>';
			}

			str+='</div></div></div>';
			reviewF.html(str);			
		});
	}
	
	//리뷰 삭제 버튼 클릭(삭제할건지 묻는 모달창 띄우기)
	$(document).on("click",".delete",function(e){
		var review_no= $(this).attr("id");
		$("#d_Modal").modal("show");
		$(document).on("click","#ok",function(e){
			$("#d_Modal").modal("hide");
			reviewService.remove(review_no, function(result){
				showList(res_codeValue);
			});
		});
		$(document).on("click","#CModal",function(e){
			review_no=0;
			showList(res_codeValue);
		});
	});
	
	//리뷰 수정 버튼 클릭
	$(document).on("click",".update",function(e){
		e.preventDefault();
		//리뷰 내용 수정할 수 있게 readonly false
		$(this).prev().children().children().attr("readonly",false);
		//버튼 텍스트랑 class 값 바꾸기
		$(this).text("확인").attr("class","modifyOk");		
		$(this).next().text("취소").attr("class","cancel");
		//별점 부분(1~5점)
		$(this).prev().prev().html('<select name="rate" id="rRate" style="color:#FFA62F; float:right;">'+
		'<option value="5" selected="selected">★★★★★</option><option value="4">★★★★</option>'+
		'<option value="3">★★★</option><option value="2">★★</option><option value="1">★</option></select>');
			
		//확인 버튼 누르면 리뷰 수정되고 다시 리뷰목록 불러오기
		$(document).on("click",".modifyOk",function(e){
			//리뷰번호, 내용, 별점
			var review = { review_no:$(this).attr("id"), content:$(this).prev().children().children().val(), rate:$(this).prev().prev().children().val() };
			reviewService.modify(review, function(result){
				$("#d_Modal").modal("hide");
 				showList(res_codeValue);
 			});			
		});
		// 취소 버튼
		$(document).on("click",".cancel",function(e){			
 			showList(res_codeValue);		
		});
		
	});
	
	//리뷰등록 버튼 클릭
	$(document).on("click","#register",function(e){
		
		if($("#user_id").val()!=undefined){ //로그인한 상태일 때만 등록 가능
			
			var review = {
					res_code : res_codeValue,
					content : $("#rContent").val(),
					rate : $("#rRate").val()
			};
			
			reviewService.insert(review, function(){
				showList(res_codeValue);
			});
			$("#rContent").val("");			
		}else{ //로그인하지 않고 리뷰등록 눌렀을 때 경고창 띄우기
			alert("로그인 후 리뷰를 등록할 수 있습니다.");	
		}		
	});
	

});
</script>
</body>
</html>
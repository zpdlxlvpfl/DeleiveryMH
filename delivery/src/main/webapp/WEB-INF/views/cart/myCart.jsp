<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>장바구니</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/fontAwesome.css">
<link rel="stylesheet" href="../resources/css/hero-slider.css">
<link rel="stylesheet" href="../resources/css/templatemo-main.css">
<link rel="stylesheet" href="../resources/css/owl-carousel.css">



<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>


<body>

	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<sec:authorize access="isAnonymous()"><li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li></sec:authorize>
			<sec:authorize access="isAnonymous()"><li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li></sec:authorize>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')"><li class="nav-item"><a class="nav-link" href="/admin/memberList?auth=ROLE_MEMBER"><span>#관리자페이지</span></a></li></sec:authorize>
		</ul>
	</div>




	<div class="service-content" id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
				
					<div class="left-text">
						<h4><b>장바구니</b></h4>
						<div class="line-dec"></div>
						<div id="removeAll" class="primary-button" style="color:#F8F8FF;">
							<h3><b>전체삭제</b></h3>
						</div>
<!-- 						<ul> -->
<!-- 							<li>- test test test test test test</li> -->
<!-- 							<li>- test test test test test test</li> -->
<!-- 							<li>- test test test test test test</li> -->
<!-- 							<li>- test test test test test test</li> -->
<!-- 						</ul> -->
						
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div id="c_list" class="col-md-6">
							<div class="service-item">
								<span style="color:white;" class="close">X</span>
								<h4></h4>
								<div class="line-dec"></div>
								<p style="color:grey;"></p>
								<p></p>
								<div></div>
								<input type="hidden" id="cart_no" name="cart_no" value='<c:out value="${list.cart_no }" />'>
								<input type="hidden" id="${status.count}" disabled>
							</div>
						</div>		
					</div>
				</div>
			</div>
		</div>
		<div id="sumTotal" style="color:white;" align="center">
			<h4>총 주문금액 <b>${cartList[0].sumTotal }원</b></h4>
		</div>
		<br />
		<div class="primary-button"  align="center">
			<a href="#">주문하기</a>
		</div>
	</div>



	<div class="parallax-content projects-content" id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="owl-testimonials" class="owl-carousel owl-theme">
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/1st-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/1st-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/2nd-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/2nd-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/3rd-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/3rd-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/4th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/4th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/5th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/5th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="../resources/img/6th-big-item.jpg" data-lightbox="image-1"><img
									src="../resources/img/6th-item.jpg" alt=""></a>
								<div class="text-content">
									<h4>foodname</h4>
									<span>123 &#8361; </span>
								</div>
							</div>
						</div>
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
        <h5 class="modal-title">장바구니 전체삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>모두 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="rAll">확인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>



<!-- 
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
	<script>
		window.jQuery
				|| document
						.write('<script src="../resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
	</script>
	<script src="../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../resources/js/plugins.js"></script>
	<script src="../resources/js/main.js"></script>




<script>


$(document).ready(function(){
	
	
	var cartService=(function() {
		
		//장바구니 목록 불러오기
		function getCartList(callback, error){
			
			$.getJSON("/cart/cartList.json",
				function(data){
					if(callback){
						callback(data);
					}
				}).fail(function(xhr,status,err){
				if(error){
					error();
				}
			});
		}
		
		//장바구니 메뉴 수량 수정
		function modify(amount, callback, error){
			$.ajax({
				type : "put",
				url : "/cart/" + amount.cart_no,
				data : JSON.stringify(amount),
				contentType : "application/json; charset=utf-8",
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
		
		//메뉴 삭제
		function remove(cart_no, callback, error){
			$.ajax({
				type : "delete",
				url : "/cart/" + cart_no,
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
		
		//장바구니 전체삭제
		function removeAll(callback, error){
			$.ajax({
				type : "delete",
				url : "/cart/removeAll",
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
		
		return {
			getCartList : getCartList,
			modify : modify,
			remove : remove,
			removeAll : removeAll
		};
		
	})();
	
	

	
	
	
	
	var c_list = $("#c_list");
	var sumTotal = $("#sumTotal");
	
	showCartList();
	
	function showCartList(){
		
		cartService.getCartList(function(cartList){
			var str="";
			var sum_str='<div id="sumTotal" style="color:white;" align="center"><h4>총 주문금액 <b>'+cartList[0].sumTotal+'원</b></h4></div>';
// 			if(cartList==null || cartList.length==0){
// 				c_list.html("");
// 				return;
// 			}
			for(var i=0, len=cartList.length||0; i<len; ++i){
				str+='<div class="service-item">';
				str+='<span style="color:white;" class="close" id="'+cartList[i].cart_no+'">X</span>';
				console.log(str);
				str+='<h4>'+cartList[i].res_menu_name+'</h4>';
				str+='<div class="line-dec"></div><p style="color:grey;">'+cartList[i].res_menu_price+'원</p>';
				str+='<p>'+cartList[i].sum +'원</p>';
				str+='<div id="'+cartList[i].amount+'"><button id="minus"><b>-</b></button>'+cartList[i].amount+'개 <button id="plus"><b>+</b></button></div>';
				str+='<input type="hidden" id="cart_no" name="cart_no" value="{'+cartList[i].cart_no+'}">';
				str+='</div></div>';
			}
			
			c_list.html(str);
			sumTotal.html(sum_str);
			
			if(cartList[0].res_menu_name==null){
				c_list.html('<div style="color:white;" align="center"><h4>장바구니가 비어있습니다.</h4></div>');
			}
			
// 			if(cartList==null || emptyCart != null){
// 				sumTotal.html('<div id="sumTotal" style="color:white;" align="center"><h4>총 주문금액 <b>0원</b></h4></div>');
// 			}
		});
	}
	
	
	
	
	//메뉴 수량 수정 클릭
	$(document).on("click","#plus",function(e){
		var amount = $(this).parent().attr("id");
		amount=parseInt(amount);
		amount+=1;
		//amount 값 +1 한걸 다시 id 값에 넣어야 계속 +1 가능한가???? id값에 다시 넣는 법 고민
		console.log(amount);
	});
// 	$(document).on("click","#minus",function(e){
	
// 		amount-=1;
// 		console.log(amount);
// 	});
	
	
	
	
	
	
	
	//메뉴 삭제 클릭
	$(document).on("click",".close",function(e){
		var cart_no= $(this).attr("id");
		$(this).parent().css("display","none");
		cartService.remove(cart_no, function(result){
			showCartList();
		});				
	});	
	
	//전체삭제 클릭
	$(document).on("click","#removeAll",function(e){
		$("#d_Modal").modal("show");
		$(document).on("click","#rAll",function(e){
			$("#d_Modal").modal("hide");
			cartService.removeAll(function(result){
				showCartList();
			});
		});
	});

	
});


</script>


</body>
</html>
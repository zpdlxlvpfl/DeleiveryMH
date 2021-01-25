<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page
	import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>

<body>
	<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>



	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">test</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					TEST List
					<button id="regBtn" type="button" class="btn btn-xs pull-right">글쓰기</button>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body" >
					<table width="100%" id="getOrderList"
						class="table table-striped table-bordered table-hover">
						<thead id="id">
							<tr>
								<th>주문번호</th>
								<th>메뉴이름</th>
								<th>이름</th>
								<th>주소</th>
								<th>주문일</th>
								<th>전화번호</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd gradeX" >
								<td class="cart_no"></td>
								<td class="res_menu_name"></td>
								<td class="m_name"></td>
								<td class="address"></td>
								<td class="order_date"></td>
								<td class="tel"></td>
							</tr>
						</tbody>
					</table>


					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>




	<script type="text/javascript">

$(document).ready(function(){
	
	
	var getOrderList=$("#getOrderList");
		getOrderList(function(){
							var html ="";
							if (getOrderList.length!=0){
								html += "<tr><th>메뉴이름</th><th>이름</th><th>주소</th><th>주문일</th><th>전화번호</th></tr>"
								for (var i=0, len=HashMapList.length||0; i<len; ++i){
									html +="<td>"+HashMapList[i].cart_no+"</td>"
									html +="<td>"+HashMapList[i].res_menu_name+"</td>"
									html +="<td>"+HashMapList[i].m_name+"</td>"
									html +="<td>"+HashMapList[i].address+"</td>"
									html +="<td>"+HashMapList[i].order_date+"</td>"
									html +="<td>"+HashMapList[i].tel+"</td>"
									html +="<td>"+HashMapList[i].sum+"</td>"
								}	
								html +="</tr>"
							}
							error : function(data){
								console.log("error" + data + getorder);
								}
							});
	};
							});
								
</script>
</body>


<%@include file="../includes/footer.jsp"%>
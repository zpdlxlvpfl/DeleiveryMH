<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<thead>
		<tr>
			<th>RES_CODE</th>
			<th>RES_NAME</th>
			<th>RES_INFO</th>
			<th>DEL_PRICE</th>
			<th>RES_MENU_PRICE</th>
		</tr>

		<table>

			<tbody>
				<c:forEach items="${menuList}" var="restList">
					<tr class="odd gradeX">
						<td><c:out value="${RES_CODE }" /></td>
						<c:out value="${res_menu_code }" />
						<td><c:out value="${res_menu_name}" /></td>
						<td><c:out value="${res_menu_explan}" /></td>
						<td><c:out value="${RES_MENU_PRICE}" /></td>


					</tr>
				</c:forEach>
			</tbody>

		</table>
	</thead>




	<script>
	
	function restList() {
			$.ajax({
				type : "GET",
				url : "/menuList",
				dataType: "json",
				contentType: "application/json; charset=utf-8;"
				data :  JSON.stringify(jsonData)
				{	RES_CODE : "${RES_CODE}",
					RES_NAME : "${res_menu_code}",
					RES_INFO : "${res_menu_name}",
					DEL_PRICE : "${res_menu_explan}",
					RES_MENU_PRICE : "${RES_MENU_PRICE}"
				},
				error : function(error) {
					console.log("error " + data);
				},
				success : function(result) {
					console.log("success"+JSON.stringify(result.data));
		            console.log("msg"+result.msg );
				}
			 });
	 };

				
				
		
	</script>


</body>
</html>
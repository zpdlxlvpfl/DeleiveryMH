<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<thead>
		<tr>
			<th>RES_CODE</th>
			<th>RES_NAME</th>
			<th>ResInfo</th>
			<th>MenuPrice</th>
			<th>DelPrice</th>
		</tr>
	
	<table>

		<tbody>
			<c:forEach items="${restList}" var="restList">
				<tr class="odd gradeX">
					<td><c:out value="${Rescode }" /></td>
					<td><a href="restaurant/restList/get?res_code=${Rescode }">
					<c:out value="${Resname }" /></a></td>
					<td><c:out value="${ResInfo}" /></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
</thead>




	<script>
		function restList() {
			$.ajax({
				type : "get",
				url : "/restList",
				data : {
					Rescode : "${Rescode}",
					Resname : "${Resname}",
					ResInfo : "${ResInfo}",
					MenuPrice : "${MenuPrice}",
					DelPrice : "${DelPrice}"
				},
				error : function(error) {
					console.log("error");
				},
				success : function(data) {
					console.log("success");

				}
			});
		}
	</script>


</body>
</html>
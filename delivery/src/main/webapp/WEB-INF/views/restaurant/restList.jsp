<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	</thead>
	<table>
	<tbody>
			<tr class="odd gradeX">
				<td id="${RES_CODE }" ></td>
				<td><a href="restaurant/restList/get?res_code=${RES_CODE}"></a>
				<td id="${Resname}" />
				<td id="${ResInfo}" />
				<td id="${MenuPrice}" />
				<td id="${DelPrice}" />
			</tr>
	</tbody>
	</table>
	
	
	
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
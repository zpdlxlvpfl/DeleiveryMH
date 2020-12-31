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
			<th>menucode</th>
			<th>resex</th>
			<th>RES_ADDRESS</th>
			<th>RES_TEL</th>
		</tr>
	</thead>
	<table>
	<tbody>
			<tr class="odd gradeX">
				<td id="${menucode }" ></td>
				<td><a href="restaurant/menuList/get?res_code=${menucode}"></a>
				<td id="${resex}" />
				<td id="${Foodname}" />
					<td id="${FoodPrice}" />
			</tr>
	</tbody>
	</table>
		
					<script>
					function menuList() {
						$.ajax({
							type : "get",
							url : "/menuList",
							data : {
								menucode : "${menucode}",
								resex : "${resex}",
								Foodname : "${Foodname}",
								FoodPrice : "${FoodPrice}"
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
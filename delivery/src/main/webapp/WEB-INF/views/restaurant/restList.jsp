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
			<th>RES_ADDRESS</th>
			<th>RES_TEL</th>
		</tr>
	</thead>
	<table>
	<tbody>
			<tr class="odd gradeX">
				<td id="${RES_CODE }" ></td>
				<td><a href="/board/get?res_code=${RES_CODE}"></a>
				<td id="${RES_ADDRESS}" />
				<td id="${RES_TEL}" />
			</tr>
	</tbody>
	</table>
	

</body>
</html>
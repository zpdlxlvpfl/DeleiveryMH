<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/saveImage" enctype="multipart/form-data" method="post">
	<input type="file" name="imgFile" />
	<input type="submit" value="이미지저장"/>
</form>


</body>
</html>
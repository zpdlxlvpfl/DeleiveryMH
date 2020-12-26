<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>이메일 보내기</h2>
<form method="post" action="test"> 
<!-- post방식으로 자료를 컨트롤러로 보냄 -->
 

수신자 이메일 : <input name="receiveMail"><br>

<br>
<input type="submit" value="전송">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<span style="color:red;">${message}</span>
 
</body>
</html>

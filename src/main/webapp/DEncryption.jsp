<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/Encryption" method="post">
	<h1>origin word: <input type="text" name="OriginWord"VALUE="Hello World"></h1>
		 <br> <br>
	<h1>SECRET_KEY: <input type="text" name="SECRET_KEY"VALUE="my_secret_key"></h1>
	<br> <br>
		<input type="submit" value="register">
	</form>
</body>
</html>
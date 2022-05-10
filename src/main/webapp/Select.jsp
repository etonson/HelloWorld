<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="<%= request.getContextPath() %>/SelectLottory" method="get">
  帳號: <input type="text" name="username">
  <br> <br> 
  密碼: <input type="password" name="passwd">
  <br> <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>JSP Actions Example</title>
</head>
<body>

<h1> Hello java web!</h1>

 <form action="<%= request.getContextPath() %>/HelloServlet" method="post">
  第1個數據: <input type="number" name="firstNumber">
  <br> <br> 
  第2個數據: <input type="number" name="secondNumber">
  <br> <br> 
  第3個數據: <input type="number" name="thirdNumber">
  <br> <br>   
  第4個數據: <input type="number" name="forthNumber">
  <br> <br> 
  第5個數據: <input type="number" name="fivethNumber">
  <br> <br> 
  第6個數據: <input type="number" name="sixthNumber">
  <br> <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>
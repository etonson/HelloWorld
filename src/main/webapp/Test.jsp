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
  ��1�Ӽƾ�: <input type="number" name="firstNumber">
  <br> <br> 
  ��2�Ӽƾ�: <input type="number" name="secondNumber">
  <br> <br> 
  ��3�Ӽƾ�: <input type="number" name="thirdNumber">
  <br> <br>   
  ��4�Ӽƾ�: <input type="number" name="forthNumber">
  <br> <br> 
  ��5�Ӽƾ�: <input type="number" name="fivethNumber">
  <br> <br> 
  ��6�Ӽƾ�: <input type="number" name="sixthNumber">
  <br> <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>
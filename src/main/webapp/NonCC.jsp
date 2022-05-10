<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="<%= request.getContextPath() %>/NonCC" method="post">
  商店編號: <input type="text" name="merchantnumber">
  <br> <br> 
  訂單編號: <input type="text" name="ordernumber">
  <br> <br> 
  訂單金額: <input type="number" name="amount">
  <br> <br> 
  付款說明: <input type="text" name="paytitle" value = "Exercise">
  <br> <br> 
  支付工具<select name="paymenttype">
    <option value="mmk">MMK</option>
    <option value="atm">ATM</option>
    <option value="webatm">WEBATM</option>
    <option value="creditcard">creditcard</option>
  </select>
    <br> <br> 
  
  <input type="submit" value="register">
 </form>
</body>
</html>
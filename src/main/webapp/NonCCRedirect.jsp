<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認買單</title>
</head>
<body>
 <form action="https://paydev.1177pay.com.tw/1177payment/paypage/payment" method="post">
 
  merchantnumber: <input type="text" value=<%=request.getAttribute("merchantnumber")%> name="merchantnumber">
  <br> <br> 

  ordernumber: <input type="text" value=<%=request.getAttribute("ordernumber")%> name="ordernumber">
  <br> <br> 
  
  amount: <input type="text" value=<%=request.getAttribute("amount")%> name="amount">
  <br> <br> 
  
  paytitle: <input type="text" value=<%=request.getAttribute("paytitle")%> name="paytitle" >
  <br> <br> 
  
  paymenttype: <input type="text" value=<%=request.getAttribute("paymenttype")%> name="paymenttype" >
  <br> <br>
  
  timestamp: <input type="text" value=<%=request.getAttribute("timestamp")%> name="timestamp" >
  <br> <br> 
  
  checksum: <input type="text" value=<%=(String)request.getAttribute("checksum")%> name="checksum" >
  <br> <br> 

  <input type="submit" value="register">
 </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

 <form action="https://paydev.1177pay.com.tw/1177payment/paypage/payment" method="post">
 
  商店編號: <input type="text" value=<%=(String)request.getAttribute("merchantnumber")%> name="merchantnumber">
  <br> <br> 

  訂單編號: <input type="text" value=<%=(String)request.getAttribute("ordernumber")%> name="ordernumber">
  <br> <br> 
  訂單金額: <input type="text" value=<%=(String)request.getAttribute("amount")%> name="amount">
  <br> <br> 
  付款說明: <input type="text" value=<%=(String)request.getAttribute("paytitle")%> name="paytitle" >
  <br> <br> 
  時間戳記: <input type="text" value=<%=(String)request.getAttribute("timestamp")%> name="timestamp" >
  <br> <br> 
    驗證碼: <input type="text" value=<%=(String)request.getAttribute("checksum")%> name="checksum" >
  <br> <br> 
  <input type="submit" value="register">
 </form>
</body>

</html>
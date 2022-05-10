<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<h1> Welcome to Eton.Lin's Home</h1>
<form action="<%= request.getContextPath() %>/Select.jsp" method="get">
<input type="button" value="大樂透" onclick="this.form.submit()" style="width:120px;height:40px;" style="font-size:20px;">
</form>
<form action="<%= request.getContextPath() %>/NonCC.jsp" method="get">
<input type="button" value="1177 PAY" onclick="this.form.submit()" style="width:120px;height:40px;" style="font-size:20px;">
</form>
<form action="<%= request.getContextPath() %>/DEncryption.jsp" method="get">
<input type="button" value="加密" onclick="this.form.submit()" style="width:120px;height:40px;" style="font-size:20px;">
</form>
</body>
</html>
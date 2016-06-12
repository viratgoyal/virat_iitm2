<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String orderId = request.getParameter("OrderId");
	String url = "http://localhost:8080/virat_iitm/rest/UserService/cutomerSms?order_id="+orderId;
	response.sendRedirect(url);
	%>
SMS sent to customer!
</body>
</html>
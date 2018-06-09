<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.fruit.dao.FruitDAO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%

	String bid = request.getParameter("bid");
	String sid = request.getParameter("sid");
	int appleCount = Integer.parseInt(request.getParameter("appleCount"));
	
	FruitDAO dao = FruitDAO.getInstance();
	
	dao.getApplePrice(sid);
	dao.buyerBuyFruit(bid, appleCount);
	dao.sellerSellFruit(sid, appleCount);
	
//	RequestDispatcher rd = request.getRequestDispatcher("tradeForm.jsp");
//	rd.forward(request, response);

//	pageContext.forward("tradeForm.jsp");

	response.sendRedirect("tradeForm.jsp");
%>
<br>
<br>
<a href="home.jsp">첫페이지로!</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.fruit.dao.FruitDAO" %>
 <%@ page import="com.fruit.vo.SellerVO" %>
 <%@ page import="com.fruit.vo.BuyerVO" %>

 <%@ page import="java.util.List" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>거래하자</title>
</head>
<body>
<div align="center"> 
<h2>거래</h2>
<hr>
<%
	FruitDAO dao = FruitDAO.getInstance();
	List<SellerVO> sellerList = dao.getSellerList();
	List<BuyerVO> buyerList = dao.getBuyerList();
%>
<table>
<tr><th>바이어</th><th>셀러</th></tr>
<tr><th><% 
	for(BuyerVO bvo : buyerList) {
		out.print("id : " + bvo.getId() + "<br>"+"money : "+ bvo.getMoney()+ "<br>"+" 사과갯수 : "+ bvo.getAppleCount() +"<br>"+"<br>");
		
	}
%>
</th><th>
<%
	for(SellerVO svo : sellerList) {
		out.print("id : " + svo.getId() + "<br>"+" 사과갯수 : "+ svo.getAppleCount() +"<br>" + " 개당 가격 : " + svo.getApplePrice() + "<br>"+"<br>");
	}
%></th></tr>

</table>


<form method="post" action="trade.jsp">
구매자id: <input name="bid" type="text" size=20 /><br>
판매자id: <input name="sid" type="text" size=20 /><br>
구매갯수: <input name="appleCount" type="text" size=20 /><br>
<input type="submit" value="구매" />

</form>

</div>


</body>
</html>
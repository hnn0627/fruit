<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@page import="java.sql.*" %>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs =null;

	String sid = request.getParameter("sid");
	String url = "jdbc:mysql://localhost:3306/newfruit";
	String id = "root";
	String pw = "cs1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(url,id,pw);
	
	if(conn != null){
		out.println("connection success");
		out.println("<br>");
	}
	String sql = "select * from seller where id =?";
	//is,passwd,money,apple_count
	pstmt =conn.prepareStatement(sql);
	pstmt.setString(1,sid);
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		
		out.println("id = "+rs.getString(1)+"<br>"+"money ="+ rs.getString(3)+"<br>"+"apple_count ="+rs.getString(4)+"<br>"+"apple_price ="+rs.getString(5));
	}
	rs.close();
	pstmt.close();
	conn.close();
%>
<br>
<br>
<a href="sellerRegisterForm.jsp">Seller 사과 객수&가격 등록하기</a>
</body>
</html>
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

	String sid = request.getParameter("sid");
	int apple_count = Integer.parseInt(request.getParameter("apple_count"));
	int apple_price = Integer.parseInt(request.getParameter("apple_price"));
	String url = "jdbc:mysql://localhost:3306/newfruit";
	String id = "root";
	String pw = "cs1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(url,id,pw);
	
	if(conn != null){
		out.println("connection success");
		out.println("<br>");
	}
	String sql = "update seller set apple_count = ? ,apple_price = ? where id =?";
	//is,passwd,money,apple_count,apple_price
	pstmt =conn.prepareStatement(sql);
	pstmt.setString(3,sid);
	pstmt.setInt(1,apple_count);
	pstmt.setInt(2,apple_price);
	pstmt.executeUpdate();
	pstmt.close();
	conn.close();
%>
<br>
<br>
<a href="home.jsp">첫페이지로!</a>
</body>
</html>
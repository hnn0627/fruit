<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement pstmt = null;
	
	String bid = request.getParameter("bid");
	int bmoney = Integer.parseInt(request.getParameter("bmoney"));
	String url = "jdbc:mysql://localhost:3306/newfruit";
	String id = "root";
	String pw = "cs1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pw);
	if(conn != null) {
		out.print("Connection Success!!");
	}
	String sql = "update buyer set money=money+? where id=?";
//	id, pass, money, apple_count
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(2, bid);
	pstmt.setInt(1, bmoney);
	pstmt.executeUpdate();
	pstmt.close();
	conn.close();
	
%>
<br>
<br>
<a href="home.jsp">첫페이지로!</a>
</body>
</html>
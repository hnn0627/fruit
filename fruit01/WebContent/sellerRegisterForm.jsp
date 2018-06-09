<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>seller 사과 등록</title>
</head>
<body>
	<form method="post" action="sellerRegister.jsp">
	판매자ID : <input type="text" size =20 name = "sid"><br>
	사과 갯수 : <input type="text" size =20 name = "apple_count"><br>
	사과 가격 : <input type="text" size =20 name = "apple_price"><br>
	<input type ="submit" value = "등록" >	
	</form>
</body>
</html>
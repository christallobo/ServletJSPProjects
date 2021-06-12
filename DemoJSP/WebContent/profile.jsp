<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	101<br> 
	Teena<br> 
	92<br>
	<br>
	<%
		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		String query = "select * from student where rollno=11";

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		rs.next();
	%>
	
	RollNo: <%=rs.getString(1) %><br>
	Name: <%=rs.getString(2) %><br>
	
</body>
</html>
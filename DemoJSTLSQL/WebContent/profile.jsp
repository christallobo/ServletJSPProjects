<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/student" user="root" password=""/>
	<sql:query var="rs" dataSource="${db}">select * from student</sql:query>
	
	<c:forEach items="${rs.rows}" var="s">
		<c:out value="${s.rollno}"></c:out> :
		<c:out value="${s.sname}"></c:out><br>
	</c:forEach>
	
</body>
</html>
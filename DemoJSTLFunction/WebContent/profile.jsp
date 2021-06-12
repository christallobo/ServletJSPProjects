<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="str" value="John is a software engineer"></c:set>
	
	<c:forEach items="${fn:split(str,' ')}" var="s">
		${s}<br>
	</c:forEach>
	
	<br>
	index : ${fn:indexOf(str,"is")}
	
	<br>
	is there : ${fn:contains(str,"software")}
	
	<br>
	<c:if test="${fn:contains(str,'java')}">
		Java is not there
	</c:if>
	
	<br>
	<c:if test="${fn:endsWith(str,'engineer')}">
		you are right
	</c:if>
	
	<br>
	Upper Case : ${fn:toUpperCase(str)}
	
	<br>
	Upper Case : ${fn:toLowerCase(str)}
</body>
</html>
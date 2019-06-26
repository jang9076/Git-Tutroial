<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="<%=cp %>/list.action">게시판</a>

</body>
</html>
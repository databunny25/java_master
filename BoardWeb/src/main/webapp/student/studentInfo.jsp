<%@page import="common.*"%> <!--  common 안에 있는 모든것을 import --> 

<%@page import="common.Student"%>
<%@page import="common.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = "Hello";
	
		// 내장객체: request
		String sno = request.getParameter("sno");
		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);
	
	%>
	
	<table border='1'>
		<caption>학생정보</caption>
			<tr>
				<th>학생번호</th><td><%=std.getStudentNumber() %></td>
			</tr>
			<tr>
				<th>학생이름</th><td><%=std.getStudentName() %></td>
			</tr>
			<tr>
				<th>영어</th><td><%=std.getEnglishScore() %></td>
			</tr>
			<tr>
				<th>수학</th><td><%=std.getMathmaticScore() %></td>
			</tr>
	
	</table>
	
</body>
</html>
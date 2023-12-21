<%@page import="common.Student"%>
<%@page import="java.util.List"%>
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

	<table border='1'>
		<thead>
			<tr><th>학번</th><th>이름</th><th>영어</th><th>수학</th></tr>
		</thead>	
		<tbody>

			
	<!-- 지시자: 꺽쇠% 쓰고 그 안에 자바를 쓴다! -->
	<%
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.getStudentList();
		
		for(Student std :list ){
	%>
		
		<tr>
			<td><a href="studentInfo.jsp?sno=<%=std.getStudentNumber() %>"><%=std.getStudentNumber() %></a></td>
			<td><%=std.getStudentName() %></td>  <!-- =적는게....이 값을 읽어오겠습니다 라는 뜻 -->
			<td><%=std.getEnglishScore() %></td>
			<td><%=std.getMathmaticScore() %></td>
		</tr>
		
		
	<%	
		}
	%>
		</tbody>
	</table>


	<p>바뀐값이 적용이 됩니다</p>	
</body>
</html>
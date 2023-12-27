<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/jstl.jsp</title>
</head>
<body>

	<!-- 자바코드 대체하기 (jstl 이용해서 jsp에서 자바코드를 빼고 태그로 대체할수있다!) -->
	
	<c:set var="name" value="홍길동"></c:set>
	<c:out value="${name }"></c:out>
	<c:set var="age" value="20"></c:set>
		
	
	
	<c:if test="${age >= 20 }">
		<p>성인입니다</p>	
	</c:if>
	
	<c:choose>
		<c:when test="${age >= 20 }">
			<p>성인입니다</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다</p>
		</c:otherwise>
	</c:choose>
	
	<!--  for(int i=1; i<10; i++){}  for반복문-->
	<c:forEach begin="1" end="10" step="1" var="i">
		<p>i의 값은 ${i }</p>
	</c:forEach>
	
	<c:forEach begin="1" end="10" step="1" var="i">
		<p>3 * ${i } = ${3*i }</p>
	</c:forEach>
	
	<!-- for(String name: names){} 확장 for반복문 -->
	<c:set var="names" value="Hong,Hwang,Kim"></c:set>
	<c:forEach items="${names } var="n">
		<p>${n }</p>
	</c:forEach>
	
</body>
</html>
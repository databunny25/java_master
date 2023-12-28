<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!-- member/memberList.jsp -->


<h3>회원목록</h3>

<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${memberList }">
		<tr>
			<td><a href="getMember.do?id=${vo.id }">${vo.id }</a></td>
			<td>${vo.pw }</td>
		</tr>
		</c:forEach>
	</tbody>
		

</table>
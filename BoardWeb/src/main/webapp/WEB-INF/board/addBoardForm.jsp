<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<h3>등록화면</h3>
	<form action="addBoard.do" method="post" enctype="multipart/form-data"> <!-- x-www-form-urlencoded '키:값' 형식으로 된 기본형태 -->
        <table class="table">
            <tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content" id="" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer" readonly value="${logName }"></td>
            </tr>
            
            <tr>
            	<th>파일</th>
            	<td><input type="file" name="image"></td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="저장">
                    <input type="reset" value="취소">
                </td>
              </tr>
        </table>
    </form>

    
<jsp:include page="../layout/foot.jsp"></jsp:include>
    
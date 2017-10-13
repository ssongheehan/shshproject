<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table class="table">
	<c:set value="${requestScope.bvo}" var="B"></c:set>
		<tr >
			<td>글번호 ${B.rv_no}</td>
			<td>제목: ${B.title} </td>
			<td>작성자 :  ${B.id}</td>
			<td>조회수 : ${B.hits}</td>
			<td>${B.timePosted}</td>
		</tr>		
		<tr>
			<td colspan="5" class="content">
			<pre>${B.content}</pre>
			</td>
		</tr>
	<!--	<tr>
			<td colspan="5" class="btnArea">
			   <c:if test="${B.id==sessionScope.mvo.id}">
			 <button type="button" class="btn" onclick="deleteBoard()">삭제</button>
			 <button type="button" class="btn" onclick="updateBoard()">수정</button>
			 </c:if>
			 </td>
		</tr> -->
	</table>
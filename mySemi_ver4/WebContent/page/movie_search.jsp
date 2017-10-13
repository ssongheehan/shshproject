<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:forEach items="${requestScope.serchList}" var="s">

	<table class="table table-bordered  table-hover boardlist">
		<tbody>	
				<tr class="success">
					<th>번호: ${s.no}</th>
					<th>				
					제목: 
<a href="DispatcherServlet?command=cmdGetMovieDetail&mv_no=${s.no}">
${s.name}</a>	
					</th>
					<th>개봉일: ${s.openDate}</th>
					<th>info: ${s.info}</th>
					<th>director: ${s.director}</th>
					<th>genre: ${s.genre}</th>
					<th>grade: ${s.grade}</th>
					<th>content: ${s.content}</th>
					<th>hits: ${s.hits}</th>
					<th>runningtime: ${s.runningTime}</th>
					<th>openflag: ${s.openFlag}</th>
				</tr>				
		</tbody>					
	</table>
 	<br><br>	
 	
</c:forEach>

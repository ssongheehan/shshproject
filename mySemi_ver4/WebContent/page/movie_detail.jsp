<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">Contact</a></li>
</ul>
				
		<hr>

	<table class="table table-bordered  table-hover boardlist">
		<thead>
		<tr class="success">
			<th>번호</th>
			<th>제목</th>
			<th>개봉일</th>
			<th>info</th>
			<th>director</th>
			<th>genre</th>
			<th>grade</th>
			<th>content</th>
			<th>hits</th>
			<th>runningtime</th>
			<th>openflag</th>
		</tr>
		</thead>
		<tbody>	
			<c:set value="${requestScope.mvo}" var="m"></c:set>
				<tr class="success">
					<th>${m.no}</th>
					<th>${m.name}</th>
					<th>${m.openDate}</th>
					<th>${m.info}</th>
					<th>${m.director}</th>
					<th>${m.genre}</th>
					<th>${m.grade}</th>
					<th>${m.content}</th>
					<th>${m.hits}</th>
					<th>${m.runningTime}</th>
					<th>${m.openFlag}</th>
				</tr>				

		</tbody>					
	</table>
	
	
 	<br><br>
 	<hr>	
 	
 	<h2>리뷰 게시판</h2>
 	
 	<table class="table table-bordered  table-hover boardlist">
		<thead>
		<tr class="success">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		</thead>
		<tbody>	
			<c:set value="${requestScope.lvo.list}" var="list"></c:set>
			
			<c:forEach items="${list}" var="BL">
				<tr>
					<th>${BL.rv_no}</th>
					<th>
					<a href="DispatcherServlet?command=cmdShowReviewContent&rv_no=${BL.rv_no}">
					${BL.title}</a>
					</th>
					<th>${BL.id}</th>
					<th>${BL.timePosted}</th>
				</tr>				
			</c:forEach>
			
		</tbody>					
	</table>
	
	<!--  페이징 -->
	<div class="pagingInfo">
		<c:set value="${requestScope.lvo.pagingBean}" var="pb"></c:set>
		<ul class="pagination">
			<c:if test="${pb.previousPageGroup}">	
			<li><a href="DispatcherServlet?command=cmdGetMovieDetail&pageNo=${pb.startPageOfPageGroup-1}&mv_no=${m.no}">&laquo;</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li><a href="DispatcherServlet?command=cmdGetMovieDetail&pageNo=${i}&mv_no=${m.no}">${i}</a></li> 
				</c:when>
			<c:otherwise>
				<li class="active"><a href="#" >${i}</a></li>
			</c:otherwise>
			</c:choose>
			&nbsp;
			</c:forEach>	
			<c:if test="${pb.nextPageGroup}">	
			<li><a href="DispatcherServlet?command=cmdGetMovieDetail&pageNo=${pb.endPageOfPageGroup+1}&mv_no=${m.no}">&raquo;</a></li>
			</c:if>		
		</ul>
		
	</div>
	
	
	<!-- 
			step2 1) 이전 페이지 그룹이 있으면 화살표 보여준다
				   		페이징빈의 previousPageGroup 이용 
				   2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
				   	    hint)   startPageOfPageGroup-1 하면 됨 		 
	 -->  
	<!-- step1. 1)현 페이지 그룹의 startPage부터 endPage까지 forEach 를 이용해 출력한다
				   2) 현 페이지가 아니면 링크를 걸어서 서버에 요청할 수 있도록 한다.
				      현 페이지이면 링크를 처리하지 않는다.  
				      PagingBean의 nowPage
				      jstl choose 를 이용  
				      예) <a href="DispatcherServlet?command=list&pageNo=...">				   
	 -->	
	<!-- 
			step3 1) 다음 페이지 그룹이 있으면 화살표 보여준다. 
				   		페이징빈의 nextPageGroup 이용 
				   2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
				   	    hint)   endPageOfPageGroup+1 하면 됨 		 
	 -->   
	
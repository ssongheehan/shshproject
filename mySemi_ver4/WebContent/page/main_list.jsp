<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container setMainImg">
  <h2>Carousel Example</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active imgDiv">
      <div class=""> 
     	 <a href=""><img src="전소민1.jpg" alt="Los Angeles"></a>
      	 <a href=""><img src="전소민1.jpg" alt="Los Angeles"></a>
         <a href=""><img src="전소민1.jpg" alt="Los Angeles"></a>
         <a href=""><img src="전소민1.jpg" alt="Los Angeles"></a>
      </div>
        <div> 
     	 <a href=""><img src="http://img.enews24.cjenm.skcdn.com/News/Contents/20170424/69771590.jpg" alt="Los Angeles"></a>
      	 <a href=""><img src="http://img.enews24.cjenm.skcdn.com/News/Contents/20170424/69771590.jpg" alt="Los Angeles"></a>
         <a href=""><img src="http://img.enews24.cjenm.skcdn.com/News/Contents/20170424/69771590.jpg" alt="Los Angeles" ></a>
          <a href=""><img src="http://img.enews24.cjenm.skcdn.com/News/Contents/20170424/69771590.jpg" alt="Los Angeles" ></a>
      </div>
        
      </div>

    	<div class="item">
        <img src="chicago.jpg" alt="Chicago" style="width:100%;">
      </div>
  
      <div class="item">
        <img src="ny.jpg" alt="New york" style="width:100%;">
      </div>
   
    </div>
    

    <!-- Left and right controls -->
    <div>
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>    
    </div>
	<div>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
    	  <span class="glyphicon glyphicon-chevron-right"></span>
    	  <span class="sr-only">Next</span>
   		</a>
	</div>

  </div>
</div>


 	<br><br>	
 	<hr>




	<table class="table table-bordered  table-hover boardlist">
		<thead>
		<tr class="success">
			<th>번호</th>
			<th>제목</th>
			<th>개봉일</th>
		</tr>
		</thead>
		<tbody>
<c:set value="${requestScope.movieList}" var="mList" ></c:set>						
			
			<c:forEach items="${mList}" var="item">
				<tr class="">
					<th>${item.no}</th>
					<th><a href="DispatcherServlet?command=cmdGetMovieDetail&mv_no=${item.no}">${item.name}</a></th>
					<th>${item.openDate}</th>
				</tr>				
			</c:forEach>
		</tbody>					
	</table>

 	
 	

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">


</script>

<div>

	<ul class="nav navbar-nav navbar-right">
		<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	</ul>
	
    <form class="navbar-form navbar-left" action="DispatcherServlet" >
			<input type="hidden" value="cmdSearchMovie" name="command">
	
	<div class="form-group">
		        <input type="text" class="form-control" placeholder="영화 검색"
		        name="searchWord" required="required">
		      </div>
	  <button type="submit" class="btn btn-default">검색</button>
	</form>


</div>

	
<br>
	 <hr>
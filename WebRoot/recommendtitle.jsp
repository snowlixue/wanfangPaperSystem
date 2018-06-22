<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    
    <title>关键词相似推荐</title>
      
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="/cnki/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- 引入jQuery文件 -->
	<script src="/cnki/js/jquery-1.11.2.min.js" language="javascript"></script>
	<style type="text/css">
		td{text-align: center;}
		div{height: 1.5em;}
	</style>
	
</head>
<body>
<div>${cid }</div>
    <table border="1" width="700" class="table table-bordered">
    <caption>以上是为您推荐的关键词类似结果</caption>
    <thead>
    	<tr>
	    	<th>title</th>
	    	<th>time</th>
	    	<th>source</th>
	    	<th>institution</th>
	    	<th>refer</th>
	    	<th>keywords</th>
	    	<th>abstracts</th>
	    	<th>download</th>
   		</tr>
   		</thead>   		
   		<c:forEach var="po" items="${stid }">
   		<tbody>
  		<tr>
  			<!-- 和po类里的属性名一样 -->			
			<td>${po.title}</td>
			<td>${po.time}</td>
			<td>${po.source}</td>
			<td>${po.institution}</td>
			<td>${po.refer}</td>
			<td>${po.keywords}</td>
			<td>${po.abstracts}</td>
			<td>${po.download}</td>
   		</tr>
   		</tbody>
   		</c:forEach> 
   	</table>
   	
   	<div>
    <a href="/cnki">返回</a>
    </div>
</body>
</html>
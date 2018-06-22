<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>全部论文结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/cnki/css/bootstrap.min.css">  
	<!-- 引入jQuery文件 -->
	<script src="/cnki/js/jquery-1.11.2.min.js" language="javascript"></script>
	<script src="/cnki/js/jquery.min.js"></script>
	<script src="/cnki/js/bootstrap.min.js"></script>
	<style type="text/css">
		td{text-align: center;}
		div{height: 1.5em;}
	</style>
	<script type="text/javascript">
		//定义个方法提醒用户确定要删除吗？方法的参数就是要删除的id名
		function deleteCnki(id){			
					if(confirm("您确认删除吗？")){	
					//如果确定删除就访问servlet，这里超链接传值传的是方法里的参数			
					window.location.href="cnki/uc/delete/"+id;
				}
			}
			
		//重置按钮方法
		function clearForm() {
			//获取uname的id，让它的值等于空字符串
			$("#cnkititle").val("");
			//document.getElementById("title").value = "";			
			//获取upower的id，让它被选中的序号等于0，因为下面有好几项option，第0项就是第一个
			document.getElementById("keywords").selectedIndex = 0;
		}			
	</script>

  </head>
  
  <body>
  <div>论文内容由万方网站爬取</div>
   <hr>
   	<!-- 查询部分，给表单定义个name属性，通过js提交 -->
  <form name="sform" action="uc/select" method="post">  		
  		<div><!-- 如果这里写个value，value值就会显示在页面上，但是我取不出来request作用域里的值，所以查询时，页面上就没有查询的内容了 -->		
  			标题：<input type="text" id="title" name="title"> 
  		</div>
  		<br>
  		<div style="margin-left:16px ">
  			
  			<input type="submit" value="查询">
  			<!-- 重置按钮，调重置方法clearForm -->
  			<input type="button" onclick="clearForm()" value="重置">
  		</div>
  </form>
  <hr>
    &nbsp;<a href="/cnki/insert.jsp">添加数据</a>
    <table border="1" width="700" class="table table-bordered">
    <caption>所有论文内容！！！</caption>
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
	    	<th>operate</th>
	    	<th>search</th>
   		</tr>
   		</thead>   		
   		<c:forEach var="po" items="${clist }">
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
  			<td><!-- 用超链接传值方式把id的值传给控制层 -->
			<a href="/cnki/uc/cid?id=${po.id }">① 修改</a>&nbsp;
			<!-- javascript:void(0)没有返回值，鼠标点击什么也不发生，如果写#号，点击会跳到顶部。
				onclick="deleteCnki(${po.id})：调javascript里的方法，并把要删除的id值传进来
			 -->
			<a href="uc/delete/${po.id }" onclick="deleteCnki(${po.id })">② 删除</a>	
			</td>
			<td><a href="/cnki/uc/selecttitle?id=${po.id }">关键词</a>
   		</tr>
   		</tbody>
   		</c:forEach> 
   	</table>
  </body>
</html>

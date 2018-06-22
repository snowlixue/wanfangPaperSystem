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
    
    <title>修改论文信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="/cnki/js/jquery.min.js"></script>
	<script src="/cnki/js/bootstrap.min.js"></script>
	<!-- 引入jQuery文件 -->
	<script type="text/javascript">
	// 控制onsubmit提交的方法，方法名是vform()
		function vform(){
			var tilte = $("#title").val();
			var time = $("#time").val();
			var source = $("#source").val();
			var institution = $("#institution").val();
			var refer = $("#refer").val();
			var keywords = $(keywords).val();
			var abstracts = $(abstracts).val();
			var download = $(download).val();
			//判断上面的变量，如果为空字符串不能提交
			if(title == ""){
				alert("请输入标题！");
				return false;
			}
			if(time == ""){
				alert("请输入时间！");
				return false;
			}
			if(source == ""){
				alert("请输入引用！");
				return false;
			}		
			//除以上结果的可以提交，返回true
			return true;
		}
	</script>
  </head>
  
  <body>
  	<!-- 用onsubmit调用上面的方法 -->
    <form action="uc/update" method="post" onsubmit="return vform()">    
    <c:forEach var="po" items="${cid }">    
        <input type="hidden"  name="id" value="${po.id}"/><br/>   
    	<table width="1000" border="1" class="table table-bordered">
    	<caption>请填写要求改的内容</caption>
    	<thread>
    	<tr>
	    	<th>id</th>
	    	<th>title</th>
	    	<th>time</th>
	    	<th>source</th>
	    	<th>institution</th>
	    	<th>refer</th>
	    	<th>keywords</th>
	    	<th>abstracts</th>
	    	<th>download</th>
   		</tr>
   		</thread>
   		<tbody>   		
  		<tr>
  		 <!--  id,title,time,source,institution,refer,keywords,abstracts,download-->
  		    <td><input type="text" id="id" name="id"/></td>
  			<td><input type="text" id="title" name="title"/></td>
	    	<td><input type="text" id="time" name="time"/></td>
	    	<td><input type="text" id="source" name="source"/></td>	    	
		    <td><input type="text" id="institution" name="institution"/></td>
	   		<td><input type="text" id="refer" name="refer"></td>
	   		<td><input type="text" id="keywords" name="keywords"></td>
	   		<td><input type="text" id="abstracts" name="abstracts"></td>
	   		<td><input type="text" id="download" name="download"></td>			   		
            
	   	</tr>
	   	</tbody>
    </table>
    </c:forEach>
    <button type="submit" class="btn btn-default btn-sm">提交</button>
    ${updateCnki }<br><!-- 操作提醒 -->
    &nbsp;&nbsp;<a href="uc/cnki">返回</a>
    </form>
  </body>
</html>

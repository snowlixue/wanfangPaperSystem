<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
  </head>
  <!-- 引入jQuery文件 -->
    <script src="/cnki/js/jquery.min.js"></script>
	<script src="/cnki/js/bootstrap.min.js"></script> 
  <body>

   <hr>
   <!-- 用onsubmit调用上面的方法 -->
   <form action="uc/login" method="post" onsubmit="return vform()">
   	<!-- 用po类，这个name值可以随意起，不受mybatis配置文件影响了 -->
   		<button input type="submit" class="btn btn-info btn-lg ">查看所有文献资料</button>
   </form>
   <br>
   <form class="form-horizontal" role="form" action="uc/story" method="post">
   <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">关键字</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="keyvalue" placeholder="请输入关键字" name="keyvalue">
    </div>
   </div>
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">点击生成故事线</button>
    </div>
  </div>
  </form>
  </body>
</html>

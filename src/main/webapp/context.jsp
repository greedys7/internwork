<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@page import="java.util.*,entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>消息详情页</title>
<link rel="stylesheet" 
      href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
   .context{
      margin-left:400px;
      border:1px solid #F00;
   }
   
   .btn{
      margin-left:230px;
   }
</style> 
</head>
<body>
    <div class="header">
		<img src="picture/logo.png">
		<hr>
		<h3 align="center">消息详情</h3>
	</div>

   <div class="context">

      <form action="update" method="post">
          <c:forEach items="${news11}" var="n">
          	      <input type="hidden" name="id" style="width:10px" value="${n.id}"><br><br>
		      消息标题：<input type="text" name="title" style="width:500px" value="${n.title}"><br><br>
		         消息正文：<input type="text" name="context" style="width:500px" value="${n.context}"><br><br>
		         发布日期：<input type="text" name="date" style="width:500px" value="${n.date}"><br><br>
		 </c:forEach>
		 <div class="btn">
			 <input type="submit" value="保存" >&nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="new"><button>取消</button></a>
		 </div>
		 
   </div>

</body>
</html>
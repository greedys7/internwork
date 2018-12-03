<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@page import="java.util.*,entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>消息列表</title>
<link rel="stylesheet" 
      href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"> 
</head>
<body>
   	<div class="header">
		<img src="picture/logo.png">
		<hr>
		<h3 align="center">消息列表</h3>
	</div>
	<div>
	   <table class="table table-striped" >
	       <tr align="center">
	         <td><strong>序号</strong></td>
             <td><strong>消息标题</strong></td>
             <td><strong>消息正文</strong></td>
             <td><strong>发布日期</strong></td>
             <td><strong>操作</strong></td>
           </tr>
	       <c:forEach items="${newss}" var="n" varStatus="ns">
	          <tr align="center" >
	             <td>${n.id}</td>
	             <td>${n.title}</td>
	             <td>${n.context}</td>
	             <td>${n.date}</td>
	             <td>
	                <a href="query?id=${n.id}">编辑</a>&nbsp;
			        <a href="del?id=${n.id}"  onclick="return confirm('消息删除成功！')">删除</a>&nbsp;        
			     </td>		     
	          </tr>
		   </c:forEach>
	   </table>
	</div>
</body>
</html>
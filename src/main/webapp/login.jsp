<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<style type="text/css">
  .content .login1{
    float:left;
    width:400px;
    height:450px;
    margin-top:50px;
    margin-left:80px;
    padding-bottom:20px;
  }

  .picture{
     float:left;
  }
  
  .submit{
     width:150px;
     height:30px;
     margin-left:70px;
  }
  
    .login{
     margin-left:120px;
  }
</style>
</head>
<body>
	<div class="header">
			<img src="picture/logo.png">
			<hr>
		</div>
		<div class="content">
			<div class="picture">
				<img src="picture/picture.PNG">
			</div>
		   <div class="login1">
		        <h2 class="login">登录</h2>
				<form action="login" method="post">
					用户名：<input name="phone" type="text" /><br><br>
					密&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" /><br><br>
					      <a href="register.jsp">快速注册</a>&nbsp;&nbsp;&nbsp;
					      <!-- <a href="register.jsp">忘记密码？</a> -->
					      <br><br>
			              <input type="submit" class="submit" value="登录">
				</form>
		   </div>

</body>
   
</script>
</html>
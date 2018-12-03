<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<style type="text/css">
  .content .repwd1{
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
		   <div class="repwd1">
		        <h2 class="repwd">修改密码</h2>
				<form action="login" method="post">
					原密码：<input name="password" type="password" /><br><br>
					新密码：<input name="newpassword" type="password" /><br><br>
			              <input type="submit" class="submit" value="确认修改">
				</form>
		   </div>

</body>
</html>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<style type="text/css">
  .content .register{
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
     margin-left:10px;
  }
  
  .reg{
     margin-left:50px;
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
	   <div class="register">
	       <h2 class="reg">注册</h2>
		   <form action="reg" method="post">
		      <input type="text" name="phone" id="phone" onblur="check1()"
		             placeholder="请输入手机号"><br><br>
		      <input type="text"  name="code" id="code" placeholder="短信验证码">
		      <button type="button" id="rcbtn" >获取验证码</button><br>
		      <div id="showCode"></div><br>
		      <input type="password" name="password" id="password" onblur="check2()" placeholder="请输入密码"><br><br>
		      <div class="checkbox">
					<label> <input type="checkbox">我已阅读并同意<a href="#">《用户注册协议》</a><br><br>
					</label>
				</div>
				
		      <input type="submit" class="submit" id="submitfn" value="注册"><br><br>
		      完成注册可获得500积分
		   </form> 
	   </div>
   </div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
    //判断手机号码格式
    function check1(){
    	var newphone = document.getElementById("phone").value;
    	console.log(newphone);
		if (!(/^1[34578]\d{9}$/.test(newphone))) {
			alert("手机号码有误，请重填");
		}
    }
    
    //判断密码格式
    function check2(){
    	var pwd = document.getElementById("password").value;  	
		if (!(/[0-9A-Za-z]\d{4}$/.test(pwd))) {
			alert("密码不能小于4位！");
		}
    }
    
	//获取验证码
	var mfbtn=document.getElementById('rcbtn');
	var countdown = 60;
	function settime(obj) {
		if (countdown == 0) {
			obj.disabled=false;
	        obj.innerHTML="获取验证码";
	        countdown = 60;
	        return;
		} else {
			obj.disabled=true;
	        obj.innerHTML="重新发送(" + countdown +"s)";
	        countdown--;
		} 
		setTimeout(function() {
	        settime(obj);
	    }, 1000)
	}
	
	//随机验证码生成
	mfbtn.onclick=function () {
	    settime(mfbtn);
	    alert("手机验证码已成功发送，请注意查收");
	    $.ajax(
	            {
	                url: "code",
	                type: "POST",
	                dataType: "json",
	                success: function (result) {
	                   /*  alert(result); */
	                   document.getElementById('showCode').innerHTML = result;
	                }
	            });
	        }
		
	
		
</script> 

</html>
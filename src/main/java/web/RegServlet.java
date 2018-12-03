package web;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * 注册页面
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("password");
		int code = Integer.parseInt(request.getParameter("code"));
		//从CodeServlet获取验证码
		int showcode = CodeServlet.showcode;	
		System.out.println("phone:"+phone+",pwd:"+pwd+",code:"+code+"showcode:"+showcode);
		System.out.println(code == showcode);
		try {

			    //判断验证码是否失效或错误
			    HttpSession session = request.getSession();
			    if(session.getAttribute("showcode")==null||code!=showcode){
			    	out.print("<script>alert('验证码错误!');window.location.href='register.jsp'</script>");
			    }
			    
			    //按照手机号查询用户信息
			    UserDAO users = new UserDAO();
			    User u =users.findByPhone(phone);
			    //判断用户注册信息是否填写完整
			    if(phone.equals("")||pwd.equals("")||code==0){
			    	out.print("<script>alert('信息填写不完整!');window.location.href='register.jsp'</script>");
			    }
			    //检查用户是否已经注册
				if(u!=null && phone.equals(u.getPhone())){
					out.print("<script>alert('该会员已存在，请立即登录!');window.location.href='login.jsp'</script>");
				}else {
					//注册 保存用户信息
					User user = new User();
					user.setPassword(pwd);
					user.setPhone(phone);
					users.save(user);
					
					out.print("<script>alert('注册成功，恭喜你成为arvato会员!');window.location.href='login.jsp'</script>");
					System.out.println("注册成功");
				}

				
		} catch (Exception e) {
			e.printStackTrace();
			//将异常抛出 交给容器来处理
		} 
       
	}

}

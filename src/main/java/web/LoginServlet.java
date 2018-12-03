package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;


/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDAO dao = new UserDAO();
		int count=0;
		
		try {
			//通过用户手机号码查找用户信息
			User u =dao.findByPhone(phone);
			//手机号输入错误
			if(!phone.equals(u.getPhone())){
				out.print("<script>alert('手机号输入错误!');window.location.href='login.jsp'</script>");
				//密码输入错误
			}else if(!pwd.equals(u.getPassword())){
				out.print("<script>alert('密码输入错误!');window.location.href='login.jsp'</script>");
				//手机号密码正确才能成功登录
			}else if(u!= null && pwd.equals(u.getPassword())){
				//重定向到消息列表页面
				response.sendRedirect("new");
				System.out.println("登录成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			//将异常抛出 交给容器来处理、
			throw new ServletException(e);	
		} 
	
	
}
	}



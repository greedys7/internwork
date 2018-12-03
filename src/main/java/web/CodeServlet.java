package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码的生成
 */
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//设置静态变量以便RegServlet可以获取
	public static int showcode = 0;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		try {
			
			//随机生成验证码
		    showcode = (int)((Math.random()*10000+1));			
			System.out.println("验证码："+showcode);
		    //为验证码设置过期时间
		    HttpSession session = request.getSession();
		    session.setAttribute("showcode", showcode);
		    session.setMaxInactiveInterval(60);
			
		    //传送验证码到前端
		    out.println(showcode);
		    out.flush();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

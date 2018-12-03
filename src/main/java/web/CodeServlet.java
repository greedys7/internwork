package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��֤�������
 */
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//���þ�̬�����Ա�RegServlet���Ի�ȡ
	public static int showcode = 0;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		try {
			
			//���������֤��
		    showcode = (int)((Math.random()*10000+1));			
			System.out.println("��֤�룺"+showcode);
		    //Ϊ��֤�����ù���ʱ��
		    HttpSession session = request.getSession();
		    session.setAttribute("showcode", showcode);
		    session.setMaxInactiveInterval(60);
			
		    //������֤�뵽ǰ��
		    out.println(showcode);
		    out.flush();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

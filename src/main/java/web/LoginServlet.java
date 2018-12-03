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
 * ��¼
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
			//ͨ���û��ֻ���������û���Ϣ
			User u =dao.findByPhone(phone);
			//�ֻ����������
			if(!phone.equals(u.getPhone())){
				out.print("<script>alert('�ֻ����������!');window.location.href='login.jsp'</script>");
				//�����������
			}else if(!pwd.equals(u.getPassword())){
				out.print("<script>alert('�����������!');window.location.href='login.jsp'</script>");
				//�ֻ���������ȷ���ܳɹ���¼
			}else if(u!= null && pwd.equals(u.getPassword())){
				//�ض�����Ϣ�б�ҳ��
				response.sendRedirect("new");
				System.out.println("��¼�ɹ�");
			}

		} catch (Exception e) {
			e.printStackTrace();
			//���쳣�׳� ��������������
			throw new ServletException(e);	
		} 
	
	
}
	}



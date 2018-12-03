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
 * ע��ҳ��
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
		//��CodeServlet��ȡ��֤��
		int showcode = CodeServlet.showcode;	
		System.out.println("phone:"+phone+",pwd:"+pwd+",code:"+code+"showcode:"+showcode);
		System.out.println(code == showcode);
		try {

			    //�ж���֤���Ƿ�ʧЧ�����
			    HttpSession session = request.getSession();
			    if(session.getAttribute("showcode")==null||code!=showcode){
			    	out.print("<script>alert('��֤�����!');window.location.href='register.jsp'</script>");
			    }
			    
			    //�����ֻ��Ų�ѯ�û���Ϣ
			    UserDAO users = new UserDAO();
			    User u =users.findByPhone(phone);
			    //�ж��û�ע����Ϣ�Ƿ���д����
			    if(phone.equals("")||pwd.equals("")||code==0){
			    	out.print("<script>alert('��Ϣ��д������!');window.location.href='register.jsp'</script>");
			    }
			    //����û��Ƿ��Ѿ�ע��
				if(u!=null && phone.equals(u.getPhone())){
					out.print("<script>alert('�û�Ա�Ѵ��ڣ���������¼!');window.location.href='login.jsp'</script>");
				}else {
					//ע�� �����û���Ϣ
					User user = new User();
					user.setPassword(pwd);
					user.setPhone(phone);
					users.save(user);
					
					out.print("<script>alert('ע��ɹ�����ϲ���Ϊarvato��Ա!');window.location.href='login.jsp'</script>");
					System.out.println("ע��ɹ�");
				}

				
		} catch (Exception e) {
			e.printStackTrace();
			//���쳣�׳� ��������������
		} 
       
	}

}

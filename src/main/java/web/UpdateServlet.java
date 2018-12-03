package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;

/**
 *  �༭һ����Ϣ�����ݲ��ɹ����浽���ݿ�
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String date = request.getParameter("date");
		System.out.println("id:"+id+",title:"+title+",context:"+context+",date:"+date);
		
		NewsDAO dao = new NewsDAO();
		try {
			//���޸ĺ����Ϣ���浽���ݿ���
			dao.update(id, title, context, date);
			//�ض��򵽸�����Ϣ�����Ϣ�б�ҳ��
			response.sendRedirect("new");	
			System.out.println("�޸ĳɹ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



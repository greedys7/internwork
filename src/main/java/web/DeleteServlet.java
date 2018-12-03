package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;

/**
 * ɾ��һ����Ϣ
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NewsDAO dao = new NewsDAO();
		try {
			//ͨ����Ϣ��idɾ����Ӧ����Ϣ
			dao.delete(id);
			//�ض�����Ϣ�б�ˢ�¸��º��ҳ��
			response.sendRedirect("new");	
			System.out.println("ɾ���ɹ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import entity.News;

/**
   * ͨ��id�Ѳ�ѯ������Ϣչʾ��Ϣ����ҳ��
 */
public class QueryNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id1 = Integer.parseInt(request.getParameter("id"));
		NewsDAO dao = new NewsDAO();
		try {
			//ͨ��id��ѯ��Ϣ����
			List<News> news1 = dao.query(id1);
			System.out.println("news1:"+news1);
			
		    //���ݲ�ѯ������Ϣ�б���Ϣ��������
			//step1.�����ݵ�request������
			request.setAttribute("news11", news1);
			
			//step2.���һ��ת���� 
			RequestDispatcher rd = request.getRequestDispatcher("context.jsp");

			//step3.ת��
			rd.forward(request, response);
			System.out.println("�༭��Ϣ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	}



package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;
import entity.News;

/**
 * ��ѯ������Ϣ
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDAO dao = new NewsDAO();
		try {
			//����������Ϣ
			List<News> news = dao.findAll();
			System.out.println("news:"+news);
			
		    //���ݲ�ѯ������Ϣ�б���Ϣ�����
			//step1.�����ݵ�request������
			request.setAttribute("newss", news);
			
			//step2.���һ��ת���� 
			RequestDispatcher rd = request.getRequestDispatcher("messagelist.jsp");

			//step3.ת��
			rd.forward(request, response);
			System.out.println("��ѯ��Ϣ");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

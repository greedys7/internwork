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
 * 查询所有消息
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDAO dao = new NewsDAO();
		try {
			//查找所用消息
			List<News> news = dao.findAll();
			System.out.println("news:"+news);
			
		    //依据查询到的消息列表信息，输出
			//step1.绑定数据到request对象上
			request.setAttribute("newss", news);
			
			//step2.获得一个转发器 
			RequestDispatcher rd = request.getRequestDispatcher("messagelist.jsp");

			//step3.转发
			rd.forward(request, response);
			System.out.println("查询消息");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

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
   * 通过id把查询到的消息展示消息详情页面
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
			//通过id查询消息内容
			List<News> news1 = dao.query(id1);
			System.out.println("news1:"+news1);
			
		    //依据查询到的消息列表信息，输出表格
			//step1.绑定数据到request对象上
			request.setAttribute("news11", news1);
			
			//step2.获得一个转发器 
			RequestDispatcher rd = request.getRequestDispatcher("context.jsp");

			//step3.转发
			rd.forward(request, response);
			System.out.println("编辑消息");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	}



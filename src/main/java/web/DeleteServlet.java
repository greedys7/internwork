package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;

/**
 * 删除一条消息
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
			//通过消息的id删除对应的消息
			dao.delete(id);
			//重定向到消息列表并刷新更新后的页面
			response.sendRedirect("new");	
			System.out.println("删除成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

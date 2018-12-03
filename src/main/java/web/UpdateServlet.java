package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;

/**
 *  编辑一条消息的内容并成功保存到数据库
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
			//把修改后的信息保存到数据库中
			dao.update(id, title, context, date);
			//重定向到更新消息后的消息列表页面
			response.sendRedirect("new");	
			System.out.println("修改成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



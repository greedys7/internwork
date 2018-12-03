package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtils.DBUtil;
import entity.News;

public class NewsDAO {
	
	/**
	 * 将所有消息查询出来 
	 * @throws Exception 
	 */
	public List<News> findAll() throws Exception{
		List<News> newss = new ArrayList<News>();	
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		ResultSet rs = null;	
		try {
			//查询消息sql语句
			String sql = "select * from news";
			prep = conn.prepareStatement(sql);
			//执行sql语句
			rs = prep.executeQuery();
			//处理结果集
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String context = rs.getString("context");
				String date = rs.getString("date");
				
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setContext(context);
				news.setDate(date);
				newss.add(news);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			//关闭连接
			DBUtil.closeAll(conn, prep, rs);
		}
		return newss;
	}
	
	
	/**
	 * 将指定的消息删除
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public void delete(int id) throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {
			String sql = "delete from news where id = ?";
		    prep = conn.prepareStatement(sql);
		    
		    prep.setInt(1,id);
		    //执行sql语句
		    prep.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭连接
			DBUtil.closeAll(conn, prep, null);
		}
		
	}

	
	/**
	 * 将指定的消息查询
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public List<News> query(int id1) throws Exception{
		List<News> news11 = new ArrayList<News>();
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {
			//查询信息sql语句
			String sql = "select * from news where id = ?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1,id1);
			//执行sql语句
			rs = prep.executeQuery();
			//处理结果集
			while(rs.next()){
				String title = rs.getString("title");
				String context = rs.getString("context");
				String date = rs.getString("date");
				int id = rs.getInt("id");
						
				
				News news1 = new News();
				
				news1.setTitle(title);
				news1.setContext(context);
				news1.setDate(date);
				news1.setId(id);
				news11.add(news1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭连接
			DBUtil.closeAll(conn, prep, null);
		}
		return news11;
	}
	
	/**
	 * 保存编辑后的信息
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public void update(int id,String title,String context,String date) throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		try {
			//修改信息sql语句
			String sql = "update news set title=?,context=?,date=? where id=?";
			
			prep = conn.prepareStatement(sql);
			prep.setString(1,title);
			prep.setString(2,context);
			prep.setString(3,date);
			prep.setInt(4,id);
			
		    prep.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭连接
			DBUtil.closeAll(conn, prep, null);
		}
	   }
	
	
}

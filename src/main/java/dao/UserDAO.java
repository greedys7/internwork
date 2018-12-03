package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtils.DBUtil;
import entity.News;
import entity.User;

public class UserDAO {
	//保存用户信息
	public void save(User user) throws Exception{
	    //获取数据库连接
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {
			//保存信息sql语句
			String sql = "insert into user values(null,?,?)";
		    prep = conn.prepareStatement(sql);
		    //执行sql语句
		    prep.setString(1, user.getPhone());
		    prep.setString(2, user.getPassword());
		    
		    prep.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, prep, null);
		}
}
	
	//通过手机号查询用户信息
public User findByPhone(String phone) throws Exception{
	    //获取数据库连接
	    Connection conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		ResultSet rs =  null;
		User user = null;
		try {
			//查询信息SQL语句
			String sql = "select * from user where phone = ?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, phone);
			//执行sql语句
			rs = prep.executeQuery();
			
			//处理结果集
			while(rs.next()){
				user = new User();
				String ph = rs.getString("phone");
				String pass = rs.getString("password");
				
				user.setPassword(pass);
				user.setPhone(ph);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			//关闭连接
			DBUtil.closeAll(conn, prep, rs);
		}
		return user;
    }

//查询所有用户信息
public List<User> findAll() throws Exception{
	List<User> users = new ArrayList<User>();
	//获取数据库连接
	Connection conn = DBUtil.getConnection();
	PreparedStatement prep = null;
	ResultSet rs =  null;
	try {
		//查询信息SQL语句
		String sql = "select * from user";
		prep = conn.prepareStatement(sql);
		//执行sql语句
		rs = prep.executeQuery();
		//处理结果集
		while(rs.next()){
			String phone = rs.getString("phone");
			String pwd = rs.getString("password");
			
			User user = new User();
			user.setPhone(phone);
			user.setPassword(pwd);
			users.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw e;
	}finally{
		//关闭连接
		DBUtil.closeAll(conn, prep, rs);
	}
	return users;
}
}

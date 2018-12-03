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
	//�����û���Ϣ
	public void save(User user) throws Exception{
	    //��ȡ���ݿ�����
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {
			//������Ϣsql���
			String sql = "insert into user values(null,?,?)";
		    prep = conn.prepareStatement(sql);
		    //ִ��sql���
		    prep.setString(1, user.getPhone());
		    prep.setString(2, user.getPassword());
		    
		    prep.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, prep, null);
		}
}
	
	//ͨ���ֻ��Ų�ѯ�û���Ϣ
public User findByPhone(String phone) throws Exception{
	    //��ȡ���ݿ�����
	    Connection conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		ResultSet rs =  null;
		User user = null;
		try {
			//��ѯ��ϢSQL���
			String sql = "select * from user where phone = ?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, phone);
			//ִ��sql���
			rs = prep.executeQuery();
			
			//��������
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
			//�ر�����
			DBUtil.closeAll(conn, prep, rs);
		}
		return user;
    }

//��ѯ�����û���Ϣ
public List<User> findAll() throws Exception{
	List<User> users = new ArrayList<User>();
	//��ȡ���ݿ�����
	Connection conn = DBUtil.getConnection();
	PreparedStatement prep = null;
	ResultSet rs =  null;
	try {
		//��ѯ��ϢSQL���
		String sql = "select * from user";
		prep = conn.prepareStatement(sql);
		//ִ��sql���
		rs = prep.executeQuery();
		//��������
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
		//�ر�����
		DBUtil.closeAll(conn, prep, rs);
	}
	return users;
}
}

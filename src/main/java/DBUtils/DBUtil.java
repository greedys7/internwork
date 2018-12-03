package DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//static语句块初始化字段信息
	static{
		try {
			Properties properties = new Properties();
			//加载jdbc文件
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("username");
			pwd = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取与数据库的连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url, user, pwd);
	}
	/**
	 * 关闭连接
	 * @param conn
	 * @param prep
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement prep,ResultSet rs){
		try {
			if (conn != null)
				conn.close();
			if (prep != null)
				prep.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

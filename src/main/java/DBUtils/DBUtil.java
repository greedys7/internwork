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
	//static�����ʼ���ֶ���Ϣ
	static{
		try {
			Properties properties = new Properties();
			//����jdbc�ļ�
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
	 * ��ȡ�����ݿ������
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url, user, pwd);
	}
	/**
	 * �ر�����
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

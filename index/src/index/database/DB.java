package index.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DB {
		Logger logger = Logger.getLogger(DB.class.getName()); 
	public static Connection getConn(){
	 	ResourceBundle bundle = ResourceBundle.getBundle("index.database.ApplicationResources");	
	 	 String IP_address = bundle.getString("ipaddress");	
	 	 String DatabaseName = bundle.getString("databaseName");		
	 	 String DatabaseUserName = bundle.getString("databaseUserName");		
	 	 String DatabaseUserPassword = bundle.getString("databaseUserPassword");		

			Connection conn=null;
 			try {
				Class.forName("com.mysql.jdbc.Driver");
 
				String url="jdbc:mysql://"+IP_address+":3306/"+DatabaseName+"?characterEncoding=utf8"; 
          
				conn=DriverManager.getConnection(url,DatabaseUserName,DatabaseUserPassword);
			 // System.out.printf("数据库连接成功！");
 
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
			return conn;
		}
		
		public static PreparedStatement prepare(Connection conn, String sql) {
			
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ps;
			
		}
		
		public static void close(Connection conn) {
			if(conn==null) return;
			try {
				
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(Statement stmt) {
			try {
				
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(ResultSet rs) {
			try {
				
				rs.close();
			   rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	
}

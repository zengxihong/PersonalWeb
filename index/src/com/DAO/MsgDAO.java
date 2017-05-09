package com.DAO;

import index.database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 
public class MsgDAO {
	private Connection conn;
	public String sql;
	PreparedStatement ps;
	public MsgDAO(){
		conn=DB.getConn();
		
	}
	
//判断重复提交
	public Boolean ReMsgDAO(String name,String msg)
	{
		Boolean result=false;
		String sql=	"select * from msg where name=? and msg=?";
		try {
		ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, msg);
			 
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	 return true;
		    }
			
			
		 //	 DB.close(ps); 
			// DB.close(conn); 
		} catch (Exception e) {
			// TODO: handle exception
			result=false;

		}

		
		return result;
	}
	
	
	public String MsgDAO(String name,String msg)
	{
		String result="";
		//String sql=	"insert into msg (name,msg) values(\""+name+"\",\""+msg+"\")";
		String sql=	"insert into msg (name,msg) values (?,?)";
		try {
		ps=conn.prepareStatement(sql);
		 	ps.setString(1, name);
			ps.setString(2, msg); 
			ps.execute();
			result="提交成功~~";
		 	 DB.close(ps); 
			 DB.close(conn); 
		} catch (Exception e) {
			// TODO: handle exception
			result="哎，服务器出错啦。。。。。";

		}

		
		return result;
	}	
	
	
	
	
	
	
	
}

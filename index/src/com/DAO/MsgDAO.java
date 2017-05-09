package com.DAO;

import index.database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

 
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
	
	//新增记录
	public String MsgDAO(String name,String msg,String time)
	{
		String result="";
		//String sql=	"insert into msg (name,msg) values(\""+name+"\",\""+msg+"\")";
		String sql=	"insert into msg (name,msg,time) values (?,?,?)";
		try {
		ps=conn.prepareStatement(sql);
		 	ps.setString(1,name);
			ps.setString(2,msg); 
			ps.setString(3,time); 
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
	
	//获取建议
	public JSONObject GetMsg(){
		JSONObject re=new JSONObject();
		JSONArray infoArray=new JSONArray();

		String sql=	"select * from msg";

		 try {
				ps=conn.prepareStatement(sql);
		 	    ResultSet rs=ps.executeQuery();
			    while(rs.next()){
				    String id=rs.getString("id");
				    String name=rs.getString("name");
				    String msg=rs.getString("msg");
				    String time=rs.getString("time");
				    JSONObject  info=new JSONObject();
				    info.put("id",id); 
				    info.put("name", name);
				    info.put("msg", msg);
				    info.put("time", time);
			        infoArray.add(info.toString());

			    }
				
			    re.put("re", infoArray.toString());
			    
			    
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		
		
		
		
		
		return re;
	}
	
	
	
	
	
}

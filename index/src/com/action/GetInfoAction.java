package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import index.database.DB;

import com.DAO.MsgDAO;
import com.opensymphony.xwork2.ActionSupport;




public class GetInfoAction extends ActionSupport {
	private Connection conn;
	public String sql;
	PreparedStatement ps;
	String result;
	JSONObject re;
	public JSONObject getRe() {
		return re;
	}
	public void setRe(JSONObject re) {
		this.re = re;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String postInfo(){
		   HttpServletRequest request = ServletActionContext.getRequest();  
	        String name = request.getParameter("name");  
	        String msg = request.getParameter("msg");  
	        String time = request.getParameter("time");  

		
		MsgDAO dao=new MsgDAO();
	Boolean re=dao.ReMsgDAO(name, msg);
		if(re){
			result="你已经提交过该条信息了~";
		}else
		
		{result=dao.MsgDAO(name,msg,time);}
	        
	        
	        
		
		return SUCCESS;
	}
	public String GetMsg(){
 		
		MsgDAO dao=new MsgDAO();
	 re=dao.GetMsg();
	 
	        
		
		return SUCCESS;
	}
	
	
	

}

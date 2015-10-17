//处理与admin表相关的业务逻辑

package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminClBean {
 
	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	/***
	 * 根据管理员名返回管理员的信息
	 * @param ab
	 * @return AdminBean
	 */
	
	public AdminBean getAdminBean(String adminName){
		
		AdminBean ab = new AdminBean();
		try{
			
			ct = new ConnDB().getConn();
			String sql = "select * from administrator where adminName='"+adminName+"'";
			
			st = ct.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				
				ab.setAdminId(rs.getInt(1));
				ab.setAdminName(rs.getString(2));
				ab.setAdminPassWord(rs.getString(3));
				ab.setGrade(rs.getInt(4));
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			//关闭资源
			cr.close(rs, st, ct);
		}
		
		return ab;
	}
	
	/***
	 * 验证管理员是否合法
	 * @param adminName
	 * @param p
	 * @return
	 */
	public boolean checkUser(String adminName, String p){
		
		boolean b = false;
		
		try{
			
			//防止sql注入漏洞       //’ or 1=1#/select * from users where userName='' or 1=1#' and passWord=md5('')
			
			ct = new ConnDB().getConn();
			String sql = "select adminPassWord from administrator where adminName='"+adminName+"'";
			st = ct.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				
				//取出数据库中的密码
				String passWord = rs.getString(1);
				
				if(passWord.equals(p)){
					
					//合法用户
					b = true;
				}
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
	
		return b;
	}

}

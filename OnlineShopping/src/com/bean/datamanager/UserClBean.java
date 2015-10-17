 //处理与user表相关的业务逻辑

package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserClBean {
 
	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	/***
	 * 根据用户名返回用户的信息
	 * @param u
	 * @return UserBean
	 */
	
	public UserBean getUserBean(String u){
		
		UserBean ub = new UserBean();
		try{
			
			ct = new ConnDB().getConn();
			String sql = "select * from user where userName='"+u+"'";
			
			st = ct.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				
				ub.setUserId(rs.getLong(1));
				ub.setUserName(rs.getString(2));
				ub.setTrueName(rs.getString(3));
				ub.setPassWord(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostCode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
				ub.setCount(rs.getFloat(10));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		
		return ub;
	}
	
	//修改个人信息
	public void updateUserBean(long userId, String userName, String trueName, 
			String email, String phone, String address, String postCode){
		
		try{
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			
		    String sql1 = "update user set userName='"+userName+"' where userId="+userId;
		    st.executeUpdate(sql1);
		    String sql2 = "update user set trueName='"+trueName+"' where userId="+userId;
		    st.executeUpdate(sql2);
		    String sql3 = "update user set email='"+email+"' where userId="+userId;
		    st.executeUpdate(sql3);
		    String sql4 = "update user set phone='"+phone+"' where userId="+userId;
		    st.executeUpdate(sql4);
		    String sql5 = "update user set address='"+address+"' where userId="+userId;
		    st.executeUpdate(sql5);
		    String sql6 = "update user set postCode='"+postCode+"' where userId="+userId;
		    st.executeUpdate(sql6);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
	}
	
	/***
	 * 验证用户是否合法
	 * @param u
	 * @param p
	 * @return
	 */
	public boolean checkUser(String u, String p){
		
		boolean b = false;
		
		try{
			
			//防止sql注入漏洞       //’ or 1=1#/select * from users where userName='' or 1=1#' and passWord=md5('')
			
			ct = new ConnDB().getConn();
			String sql = "select passWord from user where userName='"+u+"'";
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

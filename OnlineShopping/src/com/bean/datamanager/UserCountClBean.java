//处理与bookNum_View视图相关的业务逻辑

package com.bean.datamanager;
import java.sql.*;
import java.util.ArrayList;

public class UserCountClBean {

	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	
	//得到所有用户的联系信息
	public ArrayList getUserCount(){
		
		ArrayList a = new ArrayList();
		String sql = null;
		
		try{
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			sql = "select * from usercount_view";
			rs = st.executeQuery(sql);
			 
			while(rs.next()){
				UserCount_ViewBean bb = new UserCount_ViewBean();
				bb.setUserId(rs.getLong(1));
				bb.setUserName(rs.getString(2));
				bb.setPhone(rs.getString(3));
				bb.setAddress(rs.getString(4));
				
				//加入a中
				a.add(bb);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//关闭资源
			cr.close(rs, st, ct);
		}
		return a;
	}
	
	//根据userId,得到用户的联系信息
	public UserCount_ViewBean getUserCount_ViewBean(String id) {
		
		UserCount_ViewBean bb = new UserCount_ViewBean();
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "select * from usercount_view where userId='"+id+"'";
			rs = st.executeQuery(sql);  
			
			if(rs.next()){
				//放入到BookBean
				bb.setUserId(rs.getLong(1));
				bb.setUserName(rs.getString(2));
				bb.setPhone(rs.getString(3));
				bb.setAddress(rs.getString(4));
				
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return bb;
	}
	
}

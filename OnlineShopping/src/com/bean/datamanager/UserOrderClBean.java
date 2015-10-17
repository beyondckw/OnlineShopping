//处理与userorder表相关的业务逻辑

package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserOrderClBean {
 
	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	//得到所有用户订单的信息
		public ArrayList getUserOrder(){
			
			ArrayList a = new ArrayList();
			
			String sql = null;
			
			try{
				ct = new ConnDB().getConn();
				st = ct.createStatement();
					
				sql = "select * from userorder";
				rs = st.executeQuery(sql);
				while(rs.next()){
					UserOrderBean uob = new UserOrderBean();
					uob.setUserOrderId(rs.getInt(1));
					uob.setUserName(rs.getString(2));
					uob.setBookName(rs.getString(3));
					uob.setNumber(rs.getInt(4));
					
					//加入a中
					a.add(uob);
					
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				//关闭资源
				cr.close(rs, st, ct);
			}
			return a;
		}
	
		//根据userOrderId，删除一项order
		public void detUserOrder(int id){
			
			try {
				
				ct = new ConnDB().getConn();
				st = ct.createStatement();
				String sql = "delete from userorder where userOrderId="+id;
				st.executeUpdate(sql);  
				
			} catch (Exception e){
				
				e.printStackTrace();
				
			}finally{
				//关闭资源
				cr.close(rs, st, ct);
			}
		
			
		}
		
		
	//根据orderId, 得到order的具体信息
	public UserOrderBean getUserOrderBean(String id) {
		
		UserOrderBean uob = new UserOrderBean();
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "select * from userorder where orderId='"+id+"'";
			rs = st.executeQuery(sql);  
			
			if(rs.next()){
				//放入到UserOrderBean
				uob.setUserOrderId(rs.getInt(1));
				uob.setUserName(rs.getString(2));
				uob.setBookName(rs.getString(3));
				uob.setNumber(rs.getInt(4));
				
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return uob;
	}
	
}

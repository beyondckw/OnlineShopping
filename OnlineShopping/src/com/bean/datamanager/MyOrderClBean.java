//处理与order表相关的业务逻辑

package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MyOrderClBean {
 
	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	//得到所有订单的信息
	public ArrayList getOrder(){
		
		ArrayList a = new ArrayList();
		
		String sql = null;
		
		try{
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
				
			sql = "select * from myorder";
			rs = st.executeQuery(sql);
			 
			while(rs.next()){
				MyOrderBean ob = new MyOrderBean();
				ob.setOrderId(rs.getInt(1));
				ob.setUserName(rs.getString(2));
				ob.setAllPrice(rs.getFloat(3));
				
				//加入a中
				a.add(ob);
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//关闭资源
			cr.close(rs, st, ct);
		}
		
		return a;
	}

	//根据orderId，删除一项order
	public void detMyOrder(int id){
		
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "delete from myorder where orderId="+id;
			st.executeUpdate(sql);  
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
	
		
	}
	
	//根据orderId, 得到order的具体信息
	public MyOrderBean getOrderBean(String id) {
		
		MyOrderBean ob = new MyOrderBean();
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "select * from myorder where orderId='"+id+"'";
			rs = st.executeQuery(sql);  
			
			if(rs.next()){
				//放入到OrderBean
				ob.setOrderId(rs.getInt(1));
				ob.setUserName(rs.getString(2));
				ob.setAllPrice(rs.getFloat(3));
				
			}
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return ob;
	}
}

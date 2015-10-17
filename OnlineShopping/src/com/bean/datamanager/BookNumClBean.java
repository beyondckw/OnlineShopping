//处理与bookNum_View视图相关的业务逻辑

package com.bean.datamanager;
import java.sql.*;
import java.util.ArrayList;

public class BookNumClBean {

	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	
	//得到所有书的数量信息
	public ArrayList getBookNum(){
		
		ArrayList a = new ArrayList();
		
		String sql = null;
		
		try{
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
				
			sql = "select * from booknum_view";
			rs = st.executeQuery(sql);
			 
			while(rs.next()){
				BookNum_ViewBean bb = new BookNum_ViewBean();
				bb.setBookId(rs.getLong(1));
				bb.setBookName(rs.getString(2));
				bb.setBookNum(rs.getInt(3));
				
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
	
	//根据bookId, 得到书的具体信息
	public BookNum_ViewBean getBookNum_ViewBean(String id) {
		
		BookNum_ViewBean bb = new BookNum_ViewBean();
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "select * from booknum_view where bookId='"+id+"'";
			rs = st.executeQuery(sql);  
			
			if(rs.next()){
				//放入到BookBean
				bb.setBookId(rs.getLong(1));
				bb.setBookName(rs.getString(2));
				bb.setBookNum(rs.getInt(3));
				
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

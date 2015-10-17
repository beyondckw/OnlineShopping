//处理与book表相关的业务逻辑

package com.bean.datamanager;
import java.sql.*;
import java.util.ArrayList;

public class BookClBean {

	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	
	/**
	 * 返回一个有多少页
	 * 
	 */
	
	public int getPageNum(int pageSize){
		
		int count = 0;   //一共有多少记录
		int pageNum = 0;	//一共有多少页
		
		try{
			
			ct = new ConnDB().getConn();
			String sql = "select count(*) from book";
			st = ct.createStatement();
			
			//一共有多少条记录
			rs = st.executeQuery(sql);
			if(rs.next()){
				
				count = rs.getInt(1);
			}
			if(count % pageSize==0){
				pageNum = count / pageSize;
			}else {
				pageNum = count / pageSize + 1;
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return pageNum;
	}
	
	/**
	 * 分页显示图书
	 * @param pageSize:每页显示几条记录
	 * @param pageNow:显示当前页面
	 * @return ArrayList:要显示的图书的集合，即是BookBean集合  //不放在ResultSet
	 */
	
	public ArrayList getBookByPage(int pageSize, int pageNow){
		
		ArrayList a = new ArrayList();
		
		String sql = null;
		
		try{
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
				
			sql = "select * from book limit "+pageSize*(pageNow-1)+","+pageSize+"";
			
			rs = st.executeQuery(sql);
			 
			while(rs.next()){
				BookBean bb = new BookBean();
				bb.setBookId(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setBookIntro(rs.getString(3));
				bb.setBookPrice(rs.getFloat(4));
				bb.setBookNum(rs.getInt(5));
				bb.setPublisher(rs.getString(6));
				bb.setPhoto(rs.getString(7));
				bb.setBookType(rs.getString(8));
				
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
	public BookBean getBookBean(String id) {
		
		BookBean bb = new BookBean();
		try {
			
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			String sql = "select * from book where bookId='"+id+"'";
			rs = st.executeQuery(sql);  
			
			if(rs.next()){
				//放入到BookBean
				bb.setBookId(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setBookIntro(rs.getString(3));
				bb.setBookPrice(rs.getFloat(4));
				bb.setBookNum(rs.getInt(5));
				bb.setPublisher(rs.getString(6));
				bb.setPhoto(rs.getString(7));
				bb.setBookType(rs.getString(8));
				
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

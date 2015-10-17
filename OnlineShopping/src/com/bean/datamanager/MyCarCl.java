//用于处理与购物相关的业务逻辑

package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class MyCarCl {

		
	//定义一个hashmap集合，用于存放书的id和数量
	private HashMap<String, String> hm = new HashMap<String, String>();
	
	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	private float allPrice = 0.0f;
	
	CloseResource cr = new CloseResource();
	
	public void setAllPrice(float allPrice) {
		this.allPrice = allPrice;
	}

	/***
	 * 
	 * @return书的总价
	 */
	public float getAllPrice(){
		
		
		return this.allPrice;
	}
	
	/*
	 *@ 根据Id返回Num用于计算总价
	 */
	public String getBookNumById(String bookId){
		
		return hm.get(bookId);   //HashMap 中放着id与num的键值对
	}
		
	//添加书本
	public void addBook(String bookId, String bookNum){
		
		hm.put(bookId, bookNum);
			
	}
		
	//删除书本
	
	public void delBook(String bookId){
		
		hm.remove(bookId);
	}
		
	//清空书本
		
	public void clear(){
		
		hm.clear();
		//把总价设为0
		this.setAllPrice(0.0f);
		
	}
	//修改数量
	
	public void upDateBook(String bookId, String newNum){
		
		hm.put(bookId, newNum);
	//	System.out.println( hm );
	}

	//显示购物车
	public ArrayList<BookBean> showMyCar(){
		
		ArrayList<BookBean> a = new ArrayList<BookBean>();
		
		try{
			
			//查询所购买的书本的sql语句 ，真正的sql语句是"select * from book where bookId in(1,4)
			String sql = "select * from book where bookId in";
			   
			//使用Iterator完成从HashMap中取出书本的id
			 Iterator it = hm.keySet().iterator();
			String sql2 = "("; 
			
			while(it.hasNext()){
				//取出bookid
				String bookId = (String)it.next();  
				//判断bookId是不是最后一个id
				if(it.hasNext()){
					sql2 += bookId;
					sql2 += ",";
				}else{
					sql2 += bookId;
					sql2 += ")";
				}
				
			}
			
			sql = sql + sql2;
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			rs = st.executeQuery(sql);
			//每次进来之前把总价清空
			this.allPrice = 0.0f;
			
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
				
				//总价=单价*数量,单价为从数据库取rs.getFloat(4),取数量的方法为getBookNumById(String bookId),需转换为int
				this.allPrice = this.allPrice + rs.getFloat(4)*Integer.parseInt(this.getBookNumById(rs.getInt(1)+""));
				
				a.add(bb);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		
		return a;
	}
	
}

//数据库操作类
package com.bean.datamanager;

//import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/***
 *  
 * 更新数据库
 */
public class DBUtil {

	private ResultSet rs = null;
	private Connection ct = null;
	private Statement st = null;
	
	CloseResource cr = new CloseResource();
	
	//更新用户的余额
	public int updateCount(long userId, float y){
		
		int i = 0;
		try{
			
			//String sql = "select count from user where userName='"+userName+"'";
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			
		    String sql = "update user set count="+y+" where userId="+userId;
		    i = st.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return i;
	}
	
	//更新书的数量
	public int updateBookNum(long bookId, int bookNum){
		int i = 0;
		try{
			ct = new ConnDB().getConn();
			st = ct.createStatement();
			
		    String sql = "update book set bookNum="+bookNum+" where bookId="+bookId;
		    i = st.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return i;
	}
	
	//插入订单项
	public int insertOrder(String userName, float allPrice){
		
		String sql = "INSERT INTO myorder(userName, allPrice)VALUES ('"+userName+"', "+allPrice+")";
		int i = 0;
		try{
			ct = new ConnDB().getConn();
			st = ct.createStatement();
		    i = st.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return i;
	}
	
	//插入订单
	public int insertUserOrder(String userName, String bookName, int number){
		
		String sql = "INSERT INTO userorder(userName, bookName, number)VALUES ('"+userName+"', '"+bookName+"', "+number+")";
		int i = 0;
		try{
			ct = new ConnDB().getConn();
			st = ct.createStatement();
		    i = st.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return i;
	}
	
	//插入用户
	public int insertUser(String userName, String trueName, String passWord, String email, String phone, String address, String postCode, int grade,  float count ){
		
		String sql = " INSERT INTO user(userName, trueName, passWord, email, phone, address, postCode, grade, count) VALUES ('"+userName+"', '"+trueName+"', '"+passWord+"', '"+email+"', '"+phone+"', '"+address+"', '"+postCode+"', "+grade+", "+count+")";
		int i = 0;
		try{
			ct = new ConnDB().getConn();
			st = ct.createStatement();
		    i = st.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			cr.close(rs, st, ct);
		}
		return i;
	}
	
	//检查用户是否存在
	public boolean checkUserExsit(String  userName){

		boolean isExsit = false;
		String sql = "select * from user where userName='"+userName+"'";
		ct = new ConnDB().getConn();
		try {
			st = ct.createStatement();
			rs = st.executeQuery(sql);
			 if(rs.next()){
				 //说明已存在该用户名
				 isExsit = true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			//关闭资源
			cr.close(rs, st, ct);
		}
		return isExsit;
	}
} 

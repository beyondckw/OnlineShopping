//数据库连接类

package com.bean.datamanager;
import java.sql.*;  

public class ConnDB {

	private Connection ct = null;
	String url = "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=gbk";
	
	public Connection getConn(){
		
		
		try { 
	          Class.forName("com.mysql.jdbc.Driver"); 
	          ct = DriverManager.getConnection(url, "root", "root");
	      } catch(ClassNotFoundException ex) { 
	          ex.printStackTrace(); 
	      } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ct;
	}

}

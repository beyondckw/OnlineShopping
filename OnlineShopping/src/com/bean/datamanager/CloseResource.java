package com.bean.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CloseResource {

	//关闭资源
	public void close(ResultSet rs,Statement st, Connection ct) {
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs = null;
			}
			if(st!=null){
				
				st.close();
				st = null;
			}
			if(ct!=null){
				
				ct.close();
				ct = null;
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}

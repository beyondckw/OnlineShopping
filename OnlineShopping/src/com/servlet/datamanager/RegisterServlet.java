package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.datamanager.*;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
@WebServlet(name="RegisterServlet",urlPatterns="/book/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 response.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();
		 int row = 0;
		 int grade = 0;
		 float count = 0.0f;
		
		 String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"),"UTF-8");
		 String trueName = new String(request.getParameter("trueName").getBytes("ISO-8859-1"),"UTF-8");
		 String passWord = new String(request.getParameter("passWord").getBytes("ISO-8859-1"),"UTF-8");
		 String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
		 String phone = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
		 String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		 String postCode = new String(request.getParameter("postCode").getBytes("ISO-8859-1"),"UTF-8");
		 
		 
		 DBUtil dbUtil = new DBUtil();
		 try{
		 if(dbUtil.checkUserExsit(userName)){
			 request.getRequestDispatcher("no.jsp?type=exsit").forward(request, response);
		 }else if(userName.length()==0||trueName.length()==0||passWord.length()==0||email.length()==0||phone.length()==0
				 ||address.length()==0||postCode.length()==0||request.getParameter("grade").length()==0||request.getParameter("count").length()==0){
			 request.getRequestDispatcher("no.jsp?type=null").forward(request, response);
		 }else{
			 
			 //先检查int,float类型是否为空,再进行转换，否则会出错
			 try{
				  grade = Integer.parseInt(request.getParameter("grade"));
				  count = Float.parseFloat(request.getParameter("count"));
		 }catch(NumberFormatException n){
			 n.printStackTrace();
		 }
			 row = dbUtil.insertUser(userName, trueName, passWord, email, phone, address, postCode, grade, count);
			 
			 request.getRequestDispatcher("yes.jsp").forward(request, response);
			 
		 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 //System.out.println("sdfsfsdfsffdsf");
		
		 
		/* 
		 if(row != 0){
			 request.getRequestDispatcher("http://localhost:8080/OnlineShopping/main/index.jsp").forward(request, response);
		 }else{
			
		 }*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	

}

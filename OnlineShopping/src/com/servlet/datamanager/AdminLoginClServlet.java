package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.datamanager.*;

/**
 * Servlet implementation class AdminLoginClServlet
 */
//@WebServlet("/AdminLoginClServlet")
@WebServlet(name="AdminLoginClServlet",urlPatterns="/book/AdminLoginClServlet")
public class AdminLoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginClServlet() {
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
		
		//得到用户名和密码,验证用户是否合法
		String u = new String(request.getParameter("userName").getBytes("ISO-8859-1"),"UTF-8");
		
		String p = new String(request.getParameter("passWord").getBytes("ISO-8859-1"),"UTF-8");
		
		AdminClBean acb = new AdminClBean(); 
		
		if(acb.checkUser(u, p)){
			//把成功登陆的用户信息放入session,用于验证
			AdminBean ab = acb.getAdminBean(u);
			request.getSession().setAttribute("adminInfo", ab);
			//request.getSession().setAttribute("ckw", 1);
			
			//把管理员所有要查询的信息准备好
			BookNumClBean bncb = new BookNumClBean();
			ArrayList bnvb = bncb.getBookNum();
			request.getSession().setAttribute("bookNum", bnvb);
			
			UserCountClBean uccb = new UserCountClBean();
			ArrayList ucvb = uccb.getUserCount();
			request.getSession().setAttribute("userCount", ucvb);
			
			MyOrderClBean ocb = new MyOrderClBean();
			ArrayList ob = ocb.getOrder();
			request.getSession().setAttribute("order", ob);
			
			UserOrderClBean uocb = new UserOrderClBean();
			ArrayList uob = uocb.getUserOrder();
			request.getSession().setAttribute("userOrder", uob);
			
			//把购物车放入request
			//request.setAttribute("mycarInfo", a);
		//	request.getSession().setAttribute("mycarInfo", a);
			
			request.getRequestDispatcher("/book/adminsure.jsp").forward(request, response);
			
			
		}else{
			//不合法
			request.getRequestDispatcher("/book/adminLogin.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}

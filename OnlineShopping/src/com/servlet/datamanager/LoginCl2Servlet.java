package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession.*;

import com.bean.datamanager.*;

/**
 * Servlet implementation class LoginClServlet
 */
//@WebServlet("/LoginClServlet")
@WebServlet(name="LoginCl2Servlet",urlPatterns="/main/LoginCl2Servlet")
public class LoginCl2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCl2Servlet() {
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
		
		UserClBean ucb = new UserClBean(); 
		
		
		if(ucb.checkUser(u, p)){
			
			
			//把成功登陆的用户信息放入session,用于验证
			UserBean ub = ucb.getUserBean(u);
			request.getSession().setAttribute("userInfo", ub);
			//request.getSession().setAttribute("ckw", 1);
			
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("../book/login2.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}

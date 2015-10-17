package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.datamanager.*;

/**
 * Servlet implementation class ShoppingCl2Servlet
 */
//@WebServlet("/ShoppingCl2Servlet")
@WebServlet(name="ShoppingCl2Servlet",urlPatterns="/main/ShoppingCl2Servlet")
public class ShoppingCl2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCl2Servlet() {
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
		
		//检查用户是否登录过,如果登录过,进入显示信息界面,如果没,进入登录界面
		
		//通过看session中是否保存登录信息
		UserBean ub = (UserBean)request.getSession().getAttribute("userInfo");
		
		
		if(ub == null){
			
			//未登录
			
			request.getRequestDispatcher("/book/login.jsp").forward(request, response);
		}else {
			//已登录
			/*MyCarCl mcc = new MyCarCl();
			ArrayList a = mcc.showMyCar();*/
			//System.out.print(request);
			
			//把购物车的信息取出,准备在下一个页面显示
			MyCarCl mcc = (MyCarCl)request.getSession().getAttribute("mycar");
			//System.out.println( mcc );
			ArrayList a = mcc.showMyCar();
			
			//把购物车信息放入session,以在下一个页面显示
			request.getSession().setAttribute("mycarInfo", a);
			
			request.getRequestDispatcher("/book/sure.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}

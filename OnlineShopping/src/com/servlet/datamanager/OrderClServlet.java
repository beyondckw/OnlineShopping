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
 * Servlet implementation class OrderClServlet
 */
//@WebServlet("/ShoppingClServlet")
@WebServlet(name="OrderClServlet",urlPatterns="/book/OrderClServlet")
public class OrderClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderClServlet() {
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
		
		boolean flag = true;  //用来标记修改的时候是否数量已为空
		
		
		//得到type值,判断用户要进行什么操作
		String type = request.getParameter("type");
		
		if(type.equals("delMyOrder")){
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		MyOrderClBean ocb = new MyOrderClBean();
		ocb.detMyOrder(orderId);
		
		//更新数据库，重新把数据放入session
		ArrayList ob = ocb.getOrder();
		request.getSession().setAttribute("order", ob);
		request.getRequestDispatcher("/book/showMyOrder.jsp").forward(request, response);
		
	 }else if(type.equals("delUserOrder")){

		 int userOrderId = Integer.parseInt(request.getParameter("userOrderId"));
		 UserOrderClBean ocb = new UserOrderClBean();
			ocb.detUserOrder(userOrderId);
			
			//更新数据库，重新把数据放入session
			ArrayList ob = ocb.getUserOrder();
			request.getSession().setAttribute("userOrder", ob);
			request.getRequestDispatcher("/book/showUserOrder.jsp").forward(request, response);
	  }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
		
	}

}

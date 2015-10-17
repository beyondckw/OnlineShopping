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
 * Servlet implementation class ShoppingClServlet
 */
//@WebServlet("/ShoppingClServlet")
@WebServlet(name="ShoppingClServlet",urlPatterns="/main/ShoppingClServlet")
public class ShoppingClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingClServlet() {
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
		
		//调用MyCarCl 获得书本
		//MyCarCl mcc = new MyCarCl();
		//从session中取出购物车，上一次的
		MyCarCl mcc = null;
	    mcc = (MyCarCl)request.getSession().getAttribute("mycar");
		
		if(mcc == null){
			//说明该用户第一次购物,就创建一个购物车,并放入session
			mcc = new MyCarCl();
			request.getSession().setAttribute("mycar", mcc);
			//System.out.println( request.getSession() );
		}
		//得到type值,判断用户要进行什么操作
		String type = request.getParameter("type");
		
		if(type.equals("addBook")){
		//从bookDetail 中获得bookId
		String bookId = request.getParameter("bookId");
		
		mcc.addBook(bookId, "1"); //默认买一本
		
	 }else if(type.equals("delBook")){
		 //得到要删除书本的id
		 String bookId = request.getParameter("bookId");
		 
		 //从购物车中删除
		 mcc.delBook(bookId);
		  
	 }else if(type.equals("show")){
		 //空语句，直接执行下面的语句,跳转到购物车页面
	 }else if(type.equals("delAll")){
		 
		 mcc.clear();
	 }else if(type.equals("updateBook")){
		 
		 //修改数量
		 
		 //接收bookId,因为购物车中有多个商品，所以接收到的是一个数组
		 String bookId[] = request.getParameterValues("bookId"); //getParameterValues返回一个数组
		 String newNum[] = request.getParameterValues("newNum");
	//	 System.out.println( bookId );
		 
		 //判断是否书的数量已经为空
		 if(bookId == null){
			 flag = false;
			 request.getRequestDispatcher("/book/error.jsp").forward(request, response);
			 
		 }else{
		 
		 for(int i=0; i<bookId.length; i++){
			 
			 mcc.upDateBook(bookId[i], newNum[i]);
		 }
	 }
	 }
	//把购物车的书本取出，准备到下一个页面显示 
	ArrayList a = mcc.showMyCar();
	//放入到request中
	request.setAttribute("mycarinfo", a);
	
	//跳转
	if(flag){
	  request.getRequestDispatcher("/book/showMyCar.jsp").forward(request, response);
	}
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
		
	}

}

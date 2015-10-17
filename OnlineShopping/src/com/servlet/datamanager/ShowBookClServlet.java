package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.datamanager.BookBean;
import com.bean.datamanager.BookClBean;

/**
 * Servlet implementation class ShowBookClServlet
 */
//@WebServlet("/ShowBookClServlet")
@WebServlet(name="ShowBookClServlet",urlPatterns="/main/ShowBookClServlet")
public class ShowBookClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public ShowBookClServlet() {
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
		
		//得到type,判断用户想调用哪个方法
		String type = request.getParameter("type");
		
		if(type.equals("showDetail")){
		//得到要显示的书的id
		String bookId = request.getParameter("id");
		//调用BookClBean
		BookClBean bcb = new BookClBean();
		BookBean bb = bcb.getBookBean(bookId);
		//把bb放入request中
		request.setAttribute("bookInfo", bb);
		//跳转页面
		request.getRequestDispatcher("/book/bookDetail.jsp").forward(request, response);
	  }else if(type.equals("fenye")){
		  
		  //得到pageNow
		  String pageNow = request.getParameter("pageNow");
		  //把pageNow放到request中带回right.jsp
		  request.setAttribute("pageNow", pageNow);
		  
		  //跳回购物大厅
		  request.getRequestDispatcher("index.jsp").forward(request, response);
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}

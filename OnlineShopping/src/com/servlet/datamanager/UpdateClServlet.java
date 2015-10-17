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
@WebServlet(name="UpdateClServlet",urlPatterns="/main/UpdateClServlet")
public class UpdateClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClServlet() {
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
		
		String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"),"UTF-8");
		String trueName = new String(request.getParameter("trueName").getBytes("ISO-8859-1"),"UTF-8");
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
		String phone = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		String postCode = new String(request.getParameter("postCode").getBytes("ISO-8859-1"),"UTF-8");
		
		UserClBean ucb = new UserClBean(); 
		ucb.updateUserBean(ucb.getUserBean(userName).getUserId(), userName, trueName, email, phone, address, postCode);
		
		UserBean ub = ucb.getUserBean(userName);
		request.getSession().setAttribute("userInfo", ub);
		
		//把购物车取出,准备在下一个页面显示
	//	MyCarCl mcc = (MyCarCl)request.getSession().getAttribute("mycar");
		//System.out.println( mcc );
		//ArrayList a = mcc.showMyCar();
		
		//把购物车放入request
		//request.setAttribute("mycarInfo", a);
	//	request.getSession().setAttribute("mycarInfo", a);
		
		request.getRequestDispatcher("/book/sure.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}

package com.servlet.datamanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.datamanager.*;
import com.servlet.datamanager.*;

/**
 * Servlet implementation class SureServlet
 */
//@WebServlet("/SureServlet")
@WebServlet(name="SureServlet",urlPatterns="/main/SureServlet")
public class SureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SureServlet() {
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
		
		// 1.拿到该用户账户钱
		
		
		// 2.对比书总价和账户钱
		
		// 3.
		
		DBUtil dbu = new DBUtil();
		float money = 0.0f;
		float blance = 0.0f;
		float allPrice = 0.0f;
		int row =0;				//更新余额影响的行数
		int bookRow = 0;		//更新书的数量影响的行数
		
		
		MyCarCl mcc = (MyCarCl)request.getSession().getAttribute("mycar");
		
		//更新数据库中书的剩余数量
		long bookId = 0;
		int bookNum = 0;
		int bookStoreNum = 0;     //库存
		int flag = 1;  //用来记录书的存货是否充足
		
		ArrayList<BookBean> bookBean = mcc.showMyCar();
		if(bookBean == null){	//数据库中书的数量已经为空
			flag = 0;
			request.getRequestDispatcher( "/book/fail.jsp?money="+blance+"&sysError="+row+"&flag="+flag).forward(request, response);
			return ;
		}
		
		BookClBean bcb = new BookClBean();
		
		UserBean ub = null;
		ub = (UserBean)request.getSession().getAttribute("userInfo"); 
		
		blance = ub.getCount();
		allPrice = mcc.getAllPrice();
		money = blance - allPrice;
		
		//检查是不是购物车中的所有书其库存都足够
		Iterator<BookBean> it1 = bookBean.iterator();
		while(it1.hasNext()){
			BookBean bb = it1.next();
		    bookId = bb.getBookId();
		    bookNum = Integer.parseInt(mcc.getBookNumById(Long.toString(bookId)));//要买的数量
		    //数据库中书的总量减去要买的数量等于剩余的数量
		    bookStoreNum = bcb.getBookBean(Long.toString(bookId)).getBookNum()-bookNum;
		    if(bookStoreNum < 0){
		    	flag = 0;
		    	break;			//检查是不是购物车中的所有书库存都足够
		    }
		}
		
		if(flag == 1 && money >=0){ //满足所有的购买条件
	    	//把余额回写到数据库中
			row = dbu.updateCount(ub.getUserId(), money);
			
			//更新数据库中书的剩余数量
			Iterator<BookBean> it2 = bookBean.iterator();
			while(it2.hasNext()){
				BookBean bb = it2.next();
			    bookId = bb.getBookId();
			    bookNum = Integer.parseInt(mcc.getBookNumById(Long.toString(bookId)));//要买的数量
			    //数据库中书的总量减去要买的数量等于剩余的数量
			    bookStoreNum = bcb.getBookBean(Long.toString(bookId)).getBookNum()-bookNum;
				bookRow = dbu.updateBookNum(bookId, bookStoreNum);
				
				//生成订单
				dbu.insertUserOrder(ub.getUserName(), bb.getBookName(), bookNum);
			}
			//生成订单项
			dbu.insertOrder(ub.getUserName(), allPrice);
		
	    }
		
		//把本次用户的订单信息放入session中，以便用户查询
		UserOrderClBean uocb = new UserOrderClBean();
		ArrayList uob = uocb.getUserOrder();
		request.getSession().setAttribute("orderMessage", uob);
		
		if(flag == 0){              //书的库存不足
			request.getRequestDispatcher( "/book/fail.jsp?money="+blance+"&sysError="+row+"&flag="+flag).forward(request, response);
		}
		else if(money>=0 && row>0){
			request.getRequestDispatcher("/book/success.jsp?money="+money).forward(request, response);
			ub.setCount(money);
			mcc.clear();
			mcc.setAllPrice(0.0f);
		}else{
			request.getRequestDispatcher( "/book/fail.jsp?money="+blance+"&sysError="+row+"&flag="+flag).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}

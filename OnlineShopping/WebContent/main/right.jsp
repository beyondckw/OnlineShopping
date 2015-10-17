<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	BookClBean bcb = new BookClBean();

	//接收pageNow
	String s_pageNow = (String)request.getAttribute("pageNow");
	
	int pageNow = 1;	//默认显示第一页
	if(s_pageNow!=null){
		
		//String转换为Int
		pageNow = Integer.parseInt(s_pageNow);
	}
	//默认显示第一页
	ArrayList a = bcb.getBookByPage(6, pageNow);
	//得到共有多少页
	int pageNum = bcb.getPageNum(6);
	
%>

<table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3" align="center"><img src="../imgs/14.gif" width="672" height="75" /></td>
  </tr>
  
  <%
        BookBean bb = new BookBean();
  		int num = 0;
  		for(int i=0; i<2; i++){
  			
  			//打印两大行(每行3个)(可能不够显示)
  			%>
  			<tr>
  			<%
  			//取出3个
  			for(int j=0; j<3; j++){
  				
  				if(a!= null && a.size()!=0){
  			    bb = (BookBean)a.get(num);
  				num++;
  				}
  				%>
    <td width="33%" height="199" align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td width="48%" rowspan="3"><img src="../book imgs/<%=bb.getPhoto() %>" width="172" height="172" /></td>
        <td width="52%" height="107">&nbsp;</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top"><a href="ShowBookClServlet?type=showDetail&id=<%=bb.getBookId() %>"><%=bb.getBookName() %></a></td>
      </tr>
      <tr>
        <td height="21" align="left" valign="top">价格：￥<%=bb.getBookPrice() %></td>
      </tr>
      <tr>
        <td height="21" colspan="2">简单介绍：<%=bb.getBookIntro() %></td>
        </tr>
    </table></td>
    <%
  			}
  			%>
  			</tr>
  			<%
  			
  			//判断是否第一大行结束
  			if(i==0){
  				%>
  <tr>
    <td colspan="3" align="center" bgcolor="#FFFF66">&nbsp;</td>
  </tr>
  				<%
  			}
  		}
  		
  		
  %>
  
  <tr>
    <td colspan="3" align="center">
    <%
    	for(int i=1; i<=pageNum; i++ ){
    		
    		%>
    		<a href="ShowBookClServlet?type=fenye&pageNow=<%=i %>">【<%=i %>】</a>
    		<%
    	}
    %>
    
    </td>
  </tr>
</table>
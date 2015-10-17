<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//取出a,购物车中的书
	ArrayList a = (ArrayList)request.getAttribute("mycarinfo");
	//从session中取出购物车
	MyCarCl mcc = (MyCarCl)session.getAttribute("mycar");
%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">

<script type="text/javascript">
<!--
	//响应删除全部书籍
	function delAll(){
	
		window.open("ShoppingClServlet?type=delAll","_self");
}
	
-->
</script>
</head>
<body topmargin="0" bgcolor="FFFFFF">
<center>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" class="example"><span class="example">
    <jsp:include page="../main/head.jsp"></jsp:include>
    </span></td>
  </tr>
  <tr>
    <td height="136" align="center">
    <form action="ShoppingClServlet?type=updateBook" method="post">
    <table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="6">&nbsp;</td>
        </tr>
      <tr align="center">
        <td width="24%"><span class="example">编号</span></td>
        <td width="25%"><span class="example">名称</span></td>
        <td width="25%"><span class="example">单价</span></td>
        <td colspan="3"><span class="example">数量</span></td>
      </tr>
      <%
      	for(int i=0; i<a.size(); i++){
      	//从a中取出BookBean	
      		BookBean bb = (BookBean)a.get(i);	
      %>
      <tr align="center">
        <td><span class="example"><%=bb.getBookId() %></span></td>
        <td><span class="example"><%=bb.getBookName() %></span></td>
        <td><span class="example"><%=bb.getBookPrice() %></span></td>
        <td width="10%"><span class="example">
         <input type="hidden" name="bookId" value="<%=bb.getBookId() %>"> <input name="newNum" type="text" id="textfield" size="7" value="<%=mcc.getBookNumById(bb.getBookId()+"")%>"/>
        </span></td>
        <td width="8%"><span class="example"><a href="ShoppingClServlet?type=delBook&bookId=<%=bb.getBookId()%>">删除</a></span></td>
        <td width="8%"><span class="example"><a href="ShowBookClServlet?type=showDetail&id=<%=bb.getBookId() %>">查看</a></span></td>
      </tr>
      <%
      	}
      %>
      <tr>
        <td>&nbsp;</td>
        <td align="center"><span class="example">
          <input type="button" onclick="delAll();" name="button" id="button" value="删除全部" />
        </span></td>
        <td align="center"><span class="example">
          <input type="submit" name="button2" id="button2" value="修改数量" />
        </span></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="6">&nbsp;</td>
        </tr>
        
    
      <tr>
        <td height="27" colspan="6" align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td width="54%" height="23" align="left"><span class="example">你共选择了￥<%=mcc.getAllPrice() %>的商品，点 <a href="../main/index.jsp">此处</a> 继续购买</span></td>
            <td width="46%" align="right"><span class="example"><a href="ShoppingCl2Servlet"><img src="../imgs/next.gif" width="87" height="34" /></a></span></td>
          </tr>
        </table></td>
        </tr>
    </table>
    </form>
    </td>
  </tr>
  <tr>
    <td align="center"><span class="example">
    <jsp:include page="../main/foot.jsp"></jsp:include>
    </span></td>
  </tr>
</table>

</center>
</body>
</html>
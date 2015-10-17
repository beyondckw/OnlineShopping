<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	//String path = request.getContextPath();
	//取出要显示的信息(bookBean)
	BookBean bb = (BookBean)request.getAttribute("bookInfo");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">
<script type="text/javascript">

<!-- 
	//响应点击返回购物大厅
	function returnHall() {
	
		//默认打开一个新页面， 加入一个   _self 就可以在原页面显示
		window.open("../main/index.jsp","_self");
    }
    //响应点击购买的事件
    function addBook(bookId){
    	//向ShoppingClServlet请求添加书本
    	window.open("ShoppingClServlet?type=addBook&bookId="+bookId,"_self");
    }
-->

</script>
</head>
<body topmargin="0" bgcolor="FFFFFF">
<center>
<table width="80%" class="example" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include page="../main/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="20%" rowspan="8"><img src="../book imgs/<%=bb.getPhoto() %>" width="173" height="200" /></td>
        <td width="80%" align="center"><%=bb.getBookName() %></td>
      </tr>
      <tr>
        <td>价格：￥<%=bb.getBookPrice() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>ISBN：<%=bb.getBookId() %></td>
      </tr>
      <tr>
        <td>类型：<%=bb.getBookType() %></td>
      </tr>
      <tr>
        <td>出版社：<%=bb.getPublisher() %></td>
      </tr>
      <tr>
        <td>书的库存：<%=bb.getBookNum() %>本</td>
      </tr>
      <tr>
        <td valign="top"><%=bb.getBookIntro() %></td>
      </tr>
      <tr>
        <td colspan="2"><input type="button" name="button" id="button" onclick="addBook(<%=bb.getBookId() %>)" value="购买" />
          <input type="button" name="button2" id="button2" onclick="returnHall();" value="返回购物大厅" /></td>
        </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
     <jsp:include page="../main/foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
</body>
</html>
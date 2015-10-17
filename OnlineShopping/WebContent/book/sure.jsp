<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	//得到用户信息
	UserBean ub = (UserBean)session.getAttribute("userInfo");
	//得到购物车信息
	//ArrayList a = (ArrayList)request.getAttribute("mycarInfo");
	ArrayList a = (ArrayList)session.getAttribute("mycarInfo");
	//得到购物车
	MyCarCl mcc = (MyCarCl)session.getAttribute("mycar");
	
	//又把信息放回session中
	//request.getSession().setAttribute("mycarInfo", a);
	//request.getSession().setAttribute("mycar", mcc);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>确认信息</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">

<script type="text/javascript">

	function confirm(){
		alert("修改成功！");
		window.open("UpdateClServlet?type=show","_self");
	}
	
	function returnMyCar() {
	
		//默认打开一个新页面， 加入一个   _self 就可以在原页面显示
		//要想进入showMyCar.jsp,先进入ShoppingClServlet
		window.open("ShoppingClServlet?type=show","_self");
	}
		
	function buy() {
		
		
		window.open("SureServlet","_self");
	}

</script>
</head>
<body topmargin="0" bgcolor="FFFFFF">
<center>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include page="../main/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="2" align="center">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" align="center"><table width="70%" border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" align="center" class="example">购买人信息</td>
            </tr>
          
          <tr class="example">
            <td width="49%" align="right">用 户 名：</td>
         <form id="form1" name="form1" method="post" action="UpdateClServlet">   
            <td width="51%" align="left"><input type="text" name="userName" id="textfield" value="<%=ub.getUserName() %>" /></td>
          </tr>
          <tr class="example">
            <td align="right">真实姓名：</td>
            <td align="left"><input type="text" name="trueName" id="textfield2" value="<%=ub.getTrueName() %>" /></td>
          </tr>
          <tr class="example">
            <td align="right">地 址：</td>
            <td align="left"><input type="text" name="address" id="textfield3" value="<%=ub.getAddress() %>"/></td>
          </tr>
          <tr class="example">
            <td align="right">电 话：</td>
            <td align="left"><input type="text" name="phone" id="textfield4" value="<%=ub.getPhone() %>" /></td>
          </tr>
          <tr class="example">
            <td align="right">邮 件：</td>
            <td align="left"><input type="text" name="email" id="textfield5" value="<%=ub.getEmail() %>" /></td>
          </tr>
          <tr class="example">
            <td align="right">邮 编：</td>
            <td align="left"><input type="text" name="postCode" id="textfield6" value="<%=ub.getPostCode() %>" /></td>
          </tr>
          <tr class="example">
          	 <td>&nbsp;</td>
   			 <td align="right">
  			  
    		    <input type="submit" name="button1" id="button1" onclick="confirm();"  value="修改信息" />
		 </form>   
		    </td>
 		 </tr>
          
        </table></td>
      </tr>
      <tr>
        <td height="94" colspan="2" align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="example">
          <tr>
            <td colspan="4" align="center">我的购物车</td>
            </tr>
          <tr align="center">
            <td width="23%">编号</td>
            <td width="32%">商品名称</td>
            <td width="24%">单价</td>
            <td width="21%">数量</td>
          </tr>
          <%
          //循环显示购物车信息
     		if(a != null){
          	for(int i=0; i<a.size(); i++ ){
          		
          		BookBean bb = (BookBean)a.get(i);
          		%>
          		<tr align="center">
            <td><%=bb.getBookId() %></td>
            <td><%=bb.getBookName() %></td>
            <td><%=bb.getBookPrice() %></td>
            <td><%=mcc.getBookNumById(bb.getBookId()+"") %></td>
          </tr>
          		<%
          	}
     		}
          %>
          <tr>
            <td colspan="4">你一共选择了价值￥<%=mcc.getAllPrice() %>的商品</td>
            </tr>
          <tr>
            <td height="18" colspan="4" align="center">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td width="50%" align="right"><input name="button" type="button" id="button" onclick="returnMyCar();" value="返回修改我的购物车" /></td>
        <td width="50%" align="left"><input type="button" name="button2" id="button2" onclick="buy();" value="确定购买" /></td>
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
<%@ page language="java" import="java.util.* ,com.bean.datamanager.*,com.servlet.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	//得到用户信息
	UserBean ub = (UserBean)session.getAttribute("userInfo");
	//得到数据库中的有用信息
	ArrayList userOrder = (ArrayList)session.getAttribute("orderMessage");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看用户订单</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">

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
        <td height="94" colspan="2" align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="example">
          <tr>
            <td colspan="4" align="center">用户：<%=ub.getUserName() %></td>
            </tr>
          <tr>
            <td colspan="4" align="center">你的当前余额是：<%=ub.getCount()%></td>
            </tr>
          <tr align="center">
            <td width="23%">订单编号</td>
            <td width="21%">书名</td>
             <td width="21%">数量</td>
          </tr>
          <%
          //循环显示
     		if(userOrder != null){
          	for(int i=0; i<userOrder.size(); i++ ){
          		
          		UserOrderBean bb = (UserOrderBean)userOrder.get(i);
          		if(bb.getUserName().equals(ub.getUserName())){
          		%>
          		<tr align="center">
            <td><%=bb.getUserOrderId() %></td>
            <td><%=bb.getBookName() %></td>
            <td><%=bb.getNumber() %></td>
          </tr>
          		<%
          			}
          		}
     		}
          %>
         
          <tr>
            <td height="18" colspan="4" align="center">&nbsp;</td>
            </tr>
        </table></td>
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
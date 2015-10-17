<%@ page language="java" import="java.util.* ,com.bean.datamanager.*,com.servlet.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	//得到管理员信息
	AdminBean ab = (AdminBean)session.getAttribute("adminInfo");
	//得到数据库中的有用信息
	ArrayList bookNum = (ArrayList)session.getAttribute("bookNum");
	ArrayList userCount = (ArrayList)session.getAttribute("userCount");
	ArrayList order = (ArrayList)session.getAttribute("order");
	ArrayList userOrder = (ArrayList)session.getAttribute("userOrder");
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员查看信息</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">

</head>
<body topmargin="0" bgcolor="FFFFFF">
<center>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr >
    <td align="center" width="60">
    <jsp:include page="../main/head.jsp"></jsp:include>
    </td>
  </tr>
  
  <tr>
    <td width="30%" height="71">
    <form id="form1" name="form1" method="post" action="showBookNum.jsp">
      <div align="center">
        <input type="submit" name="button1" id="button1" value="查看书的库存" />
      </div>
    </form></td>
    
  </tr>
  <tr>
    <td  width="30%" height="71"><form id="form2" name="form2" method="post" action="showUserCount.jsp">
      <div align="center">
        <input type="submit" name="button2" id="button2" value="用户联系方式" />
      </div>
    </form></td>
  </tr>
  <tr>
    <td  width="30%" height="71"><form id="form3" name="form3" method="post" action="showMyOrder.jsp">
      <div align="center">
        <input type="submit" name="button3" id="button3" value="查看订单项" />
      </div>
    </form></td>
  </tr>
  <tr>
    <td  width="20%" height="71"><form id="form4" name="form4" method="post" action="showUserOrder.jsp">
      <div align="center">
        <input type="submit" name="button4" id="button4" value="查看订单" />
      </div>
    </form></td>
    
  </tr>
  
  <!-- -- 
   <tr>
    <td width="23%" height="310">
    <table width="80%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td width="50%" align="center"><input type="button" name="button1" id="button1" onclick="buy();" value="查看书的库存" /></td>
      </tr>
      <tr>
        <td width="50%" align="center"><input type="button" name="button2" id="button2" onclick="buy();" value="查看用户余额" /></td>
      </tr>
      <tr>
        <td width="50%" align="center"><input type="button" name="button3" id="button3" onclick="buy();" value="查看订单项" /></td>
      </tr>
      <tr>
        <td width="50%" align="center"><input type="button" name="button4" id="button4" onclick="buy();" value="查看订单" /></td>
      </tr>
    </table></td>
    <td width="77%">
	
		<tr>
        <td colspan="2" align="center"><table width="70%" border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" align="center" class="example">管理员</td>
             <td><%=ab.getAdminName() %></td>
            </tr>
          
          
        </table></td>
      </tr>
	
	</td>
  </tr>
  
 
    </table></td>
  </tr>
  -->
  <tr>
    <td align="center">
    <jsp:include page="../main/foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
</body>
</html>
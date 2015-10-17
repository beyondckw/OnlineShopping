<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作成功</title>
<link rel="stylesheet" type="text/css" href="../table +css/site.css">
</head>
<body topmargin="0" bgcolor="FFFFFF">
<center>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" align="center">
    <jsp:include page="../main/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="51%" rowspan="2" align="center"><img src="../imgs/sucess2.gif" width="205" height="144" /></td>
    <td width="49%" height="117" align="left">恭喜你！购买成功！你还有余额￥<%=request.getParameter("money") %>。点击<a href="../book/orderMessage.jsp">此处</a>查看订单信息。</td>
  </tr>
  <tr>
    <td align="left">货物正在流动中，稍后与你联系......</td>
    <!-- 清空当前用户的session-->

  </tr>
  
  <tr>
    <td colspan="2" align="center">
    <jsp:include page="../main/foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
</body>
</html>
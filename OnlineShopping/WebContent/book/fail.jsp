<%@ page language="java" import="java.util.* ,com.bean.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作失败</title>
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
    <td width="51%" rowspan="2" align="center"><img src="../imgs/fail.gif" width="252" height="148" /></td>
     <%
    	if(request.getParameter("flag").equals("0")){
    %>
    <td width="49%" height="125" align="left">很抱歉，由于你所购买的书库存不足，购买失败！请先查看书的具体库存再进行购买，非常抱歉！</td>
    <%
    	}else if(request.getParameter("sysError").equals("0")){
    %>
    <td width="49%" height="125" align="left">很抱歉，由于你的余额不足，购买失败！你的余额是￥<%=request.getParameter("money")%>。请充值后再购买。</td>
    <%
    	}else if(request.getParameter("sysError").equals("1")){
    %>
    <td width="49%" height="125" align="left">很抱歉，由于系统出错。请稍后再购买。</td>
    <%
    	}
    %>
  </tr>
  <tr>
    <td align="left">点击<a href="../main/index.jsp">此处</a>返回购物大厅。</td>
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
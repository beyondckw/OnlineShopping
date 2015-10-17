<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册失败</title>
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
 	if(request.getParameter("type").equals("null")){
 %>   
    <td width="49%" height="125" align="left">   对不起，不允许有空，注册失败！</td>
  <%
 	}else if(request.getParameter("type").equals("exsit")){
  %>
    <td width="49%" height="125" align="left">   对不起，用户名已存在，注册失败！</td>
  <%
 	}
  %>
  </tr>
  <tr>
    <td align="left">点击<a href="register.jsp">此处</a>返回注册页面。</td>
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
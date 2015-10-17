<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出错页面</title>
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
    <td width="49%" height="125" align="left">噢，出错了！！！！已经没有书可以修改了！！！</td>
  </tr>
  <tr>
    <td align="left">点击<a href="../main/index.jsp">此处</a>购物大厅。</td>
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
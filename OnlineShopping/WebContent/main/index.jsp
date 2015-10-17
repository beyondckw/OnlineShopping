<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物网首页面</title>
<!-- 引入css -->
<link rel="stylesheet" type="text/css" href="../table +css/site.css">
</head>
<body topmargin="0" bgcolor="FFFFFF">
 <table width="80%" border="1" align="center">
  <tr>
    <td height="101" colspan="2" align="center" valign="middle">
    <!-- 引入head.jsp -->
    <jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="22%" height="234" align="center" valign="middle">
    <jsp:include page="left.jsp"></jsp:include>
    </td>
    <td width="78%" align="center" valign="middle">
    <jsp:include page="right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="106" colspan="2" align="center" valign="middle">
    <jsp:include page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>
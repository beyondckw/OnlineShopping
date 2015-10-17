<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
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
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr align="center">
        <td>
        <form action="../main/LoginCl2Servlet" method="post">
        <table width="40%" border="1" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="2" class="example">用户登录</td>
            </tr>
          <tr align="center">
            <td width="44%" align="right" class="example">用户名：</td>
            <td width="56%" align="left"><input name="userName" type="text" id="textfield" size="15" /></td>
          </tr>
          <tr align="center">
            <td align="right" class="example">密 &nbsp;  码：</td>
            <td align="left"><input name="passWord" type="password" id="textfield2" size="15" /></td>
          </tr>
          <tr align="center">
            <td align="right" class="example"><input name="submit" type="submit" id="submit" value="登录" /></td>
            <td align="left" class="example"><input type="submit" name="submit2" id="submit2" value="注册" /></td>
          </tr>
        </table>
        </form>
        </td>
      </tr>
      <tr align="right">
        <td><img src="../imgs/next.gif" width="87" height="34" /></td>
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
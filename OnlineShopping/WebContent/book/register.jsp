<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
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
    <td align="center">
    <form action="RegisterServlet" method="post">
    <table width="40%" border="1" cellspacing="0" cellpadding="0" bgcolor="AAABBB">
      <tr align="center" class="example">
        <td colspan="2" class="example">请填写以下注册信息</td>
        </tr>
      <tr>
        <td width="33%" align="right" class="example">用户名：</td>
        <td width="67%" align="left" class="example"><input name="userName" type="text" id="textfield" maxlength="20" /></td>
      </tr>
     
      <tr>
        <td align="right" class="example">真实名字：</td>
        <td align="left" class="example"><input type="text" name="trueName" id="textfield3" /></td>
      </tr>
      <tr>
        <td align="right" class="example">密 码：</td>
        <td align="left" class="example"><input type="password" name="passWord" id="textfield4" /></td>
      </tr>
      <tr>
        <td align="right" class="example">邮箱：</td>
        <td align="left" class="example"><input type="text" name="email" id="textfield5" /></td>
      </tr>
      <tr>
        <td align="right" class="example">电话：</td>
        <td align="left" class="example"><input type="text" name="phone" id="textfield6" /></td>
      </tr>
      <tr>
        <td align="right" class="example">地址：</td>
        <td align="left" class="example"><input type="text" name="address" id="textfield7" /></td>
      </tr>
      <tr>
        <td align="right" class="example">邮编：</td>
        <td align="left" class="example"><input type="text" name="postCode" id="textfield8" /></td>
      </tr>
      <tr>
        <td align="right" class="example">等级：</td>
        <td align="left" class="example"><input type="text" name="grade" id="textfield9" /></td>
      </tr>
      <tr>
        <td align="right" class="example">金额：</td>
        <td align="left" class="example"><input type="text" name="count" id="textfield10" /></td>
      </tr>
      <tr>
        <td align="right" class="example"><input type="submit" name="button" id="button" value="确定" /></td>
        <td align="left" class="example"><input type="reset" name="button2" id="button2" value="清除" /></td>
        </tr>
    </table>
    </form>
    </td>
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
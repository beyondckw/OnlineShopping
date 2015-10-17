<%@ page language="java" import="java.util.* ,com.bean.datamanager.*,com.servlet.datamanager.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	//得到管理员信息
	AdminBean ab = (AdminBean)session.getAttribute("adminInfo");
	//得到数据库中的有用信息
	ArrayList bookNum = (ArrayList)session.getAttribute("bookNum");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看书的库存</title>
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
            <td colspan="4" align="center">管理员：<%=ab.getAdminName() %></td>
            </tr>
          <tr>
            <td colspan="4" align="center">所有书的库存量</td>
            </tr>
          <tr align="center">
            <td width="23%">编号</td>
            <td width="32%">商品名称</td>
            <td width="21%">数量</td>
          </tr>
          <%
          //循环显示书的数量信息
     		if(bookNum != null){
          	for(int i=0; i<bookNum.size(); i++ ){
          		
          		BookNum_ViewBean bb = (BookNum_ViewBean)bookNum.get(i);
          		%>
          		<tr align="center">
            <td><%=bb.getBookId() %></td>
            <td><%=bb.getBookName() %></td>
            <td><%=bb.getBookNum() %></td>
          </tr>
          		<%
          	}
     		}
          %>
         
          <tr>
            <td height="18" colspan="4" align="center">
            <form id="form1" name="form1" method="post" action="adminsure.jsp">
    		  <div align="center">
       		 <input type="submit" name="button1" id="button1" value="返回管理员操作界面" />
      		</div>
    		</form>
            </td>
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
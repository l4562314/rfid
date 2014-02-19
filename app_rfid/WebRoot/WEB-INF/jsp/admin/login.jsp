<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>tfid管理后台</title>
<link href="/styles/admin/base.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login">
  <h1>rfid管理系统登录</h1>
  <s:form action="/admin/login.do" target="_top">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="150" align="right">用户名：</td>
      <td align="left">
        <s:text name="username" type="text" id="textfield" size="30" />
      </td>
    </tr>
    <tr>
      <td align="right">密&nbsp;&nbsp;&nbsp;码：</td>
      <td align="left"><s:password name="password" type="password" id="textfield2" size="30" /></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td align="left">
        <s:submit name="submit" id="button" value="提交" />
      </td>
    </tr>
  </table>
  </s:form>
</div>
</body>
</html>

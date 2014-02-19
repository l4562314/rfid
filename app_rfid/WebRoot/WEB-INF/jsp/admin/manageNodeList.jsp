<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>功能点管理</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 功能点管理 <a href="/admin/manage_node.do?form">添加功能点</a></div>
<div class="user_query">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>所属版块</th>
            <th>功能点名称</th>
            <th>功能点URL</th>
            <th>管理</th>
        </tr>
        <c:forEach items="${actionBean.nodes}" var="item">
            <tr>
                <td>${item.key.id}</td>
                <td>${item.value.name}</td>
                <td>${item.key.name}</td>
                <td>${item.key.url}</td>
                <td><a href="/admin/manage_node.do?form&id=${item.key.id}">【修改】</a></td>
            </tr>
        </c:forEach>
       <%-- <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>--%>
    </table>
</div>
</body>
</html>

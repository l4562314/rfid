<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>管理帐号列表</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 管理帐号 <a href="/admin/manager_user.do?manager_form">添加帐号</a></div>
<div class="user_query">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>帐号名</th>
            <th>状态</th>
            <th>管理</th>
        </tr>
        <%--@elvariable id="actionBean" type="com.juedui100.sns.web.action.admin.ManagerUserAction"--%>
        <c:forEach items="${actionBean.manageUsers}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.username}</td>
                <td>${item.status<0?'已关闭':'开启状态'}</td>
                <td><a href="/admin/manager_user.do?manager_form&manage_id=${item.id}">【修改】</a>
                    <c:choose>
                        <c:when test="${item.status<0}">
                            <a href="/admin/manager_user.do?open&manage_id=${item.id}">【开启】</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/admin/manager_user.do?close&manage_id=${item.id}">【关闭】</a>
                        </c:otherwise>
                    </c:choose>

                </td>
            </tr>
        </c:forEach>
        <%--<tr>
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

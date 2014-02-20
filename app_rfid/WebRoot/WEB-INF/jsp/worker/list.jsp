<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>工人管理</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">监控管理 &#8250;&#8250; 工人管理 <a href="/worker.do?form">添加工人</a></div>
<div class="user_query">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>身份证号码</th>
            <th>性别</th>
            <th>联系电话</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${actionBean.workers}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.idcard}</td>
                <td>
                	<c:if test="${item.sex == 1}">男</c:if>
                	<c:if test="${item.sex == 2}">女</c:if>
                </td>
                <td>${item.phone }</td>
                <td>
                	<c:if test="${item.status == 0 }">正常</c:if>
                </td>
                <td><a href="/worker.do?form&worker.id=${item.id}">【修改】</a>&nbsp;<a href="/worker.do?delete&worker.id=${item.id }">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

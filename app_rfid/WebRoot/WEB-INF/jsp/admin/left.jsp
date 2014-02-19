<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>导航</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>

<body class="frame_left">
<div class="nav">
    <c:forEach items="${actionBean.menus}" var="menu">
        <dl>
            <dt>${menu.key.name}</dt>
            <c:forEach items="${menu.value}" var="item">
                <dd><a href="${item.url}" target="mainFrame">${item.name}</a></dd>
            </c:forEach>
        </dl>
    </c:forEach>
</div>
</body>
</html>

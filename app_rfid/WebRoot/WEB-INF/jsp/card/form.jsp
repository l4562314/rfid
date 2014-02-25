<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加或修改卡</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">监控管理 &#8250;&#8250; 添加或修改卡</div>
<div class="user_query">
    <s:form action="/card.do" method="post">
    	<s:hidden name="card.id"></s:hidden>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>名字：
                    <s:text name="card.name" type="text" size="32"/></td>
            </tr>
            <tr>
                <td>编号：
                    <s:text name="card.code" type="text" size="32"/></td>
            </tr>
        </table>
        <div class="user_query_btn">
            <s:submit name="saveCard" id="button" value="确认提交"/>
        </div>
    </s:form>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加，修改功能点</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 添加，修改功能点</div>
<div class="user_query">
    <s:form action="/admin/manage_node.do">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>功能点名称
                    <s:text name="manageNode.name" type="text" id="textfield" size="30"/></td>
            </tr>
            <tr>
                <td>功能点URL
                    <s:text name="manageNode.url" type="text" id="textfield" size="30"/></td>
            </tr>
            <tr>
                <td>所属版块
                    <s:select name="manageNode.cid">
                        <s:options-collection collection="${actionBean.channels}" value="id" label="name"/>
                    </s:select>
                </td>
            </tr>
        </table>
        <div class="user_query_btn">
            <s:hidden name="manageNode.id"/>
            <s:submit name="submit" id="button" value="确认提交"/>
        </div>
    </s:form>
</div>
</body>
</html>

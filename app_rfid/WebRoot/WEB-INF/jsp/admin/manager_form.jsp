<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加或修改管理帐号</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 添加或修改管理帐号</div>
<div class="user_query">
    <s:form action="/admin/manager_user.do" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>用户名：
                    <s:text name="username" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：
                    <s:text name="password" type="text" size="30"/></td>
            </tr>
                <%--@elvariable id="actionBean" type="com.juedui100.sns.web.action.admin.ManagerUserAction"--%>

            <c:forEach items="${actionBean.menus}" var="menu">
                <tr>
                    <td><b>${menu.key.name}</b></td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${menu.value}" var="node">
                            <label><s:checkbox name="nodes" value="${node.id}"/>${node.name}</label>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <div class="user_query_btn">
            <s:hidden name="manage_id"/>
            <s:submit name="save_manager" id="button" value="确认提交"/>
        </div>
    </s:form>
</div>
</body>
</html>

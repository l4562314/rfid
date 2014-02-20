<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加或修改工人</title>
    <link href="/styles/admin/base.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/calendar.js"></script>
</head>
<body class="frame_right">
<div class="location">监控管理 &#8250;&#8250; 添加或修改工人</div>
<div class="user_query">
    <s:form action="/worker.do" method="post">
    	<s:hidden name="worker.id"></s:hidden>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>姓名：
                    <s:text name="worker.name" type="text" size="10"/></td>
            </tr>
            <tr>
                <td>身份证：
                    <s:text name="worker.idcard" type="text" size="20"/></td>
            </tr>
            <tr>
            	<td>
            		姓别：
            		<s:select name="worker.sex">
            			<s:option value="1" >男</s:option>
            			<s:option value="2">女</s:option>
            		</s:select>
            	</td>
            </tr>
            <tr>
            	<td>
            		<label>
          				生日：
            			<input id="birthday" name="birthday" onclick="fPopCalendar(event,this,this)" onfocus="this.select()" type="text" readonly="readonly"  value="${actionBean.birthday }" maxlength="10"/>
      				</label>
            	</td>
            </tr>
            <tr>
            	<td>
            		联系电话：
            		<s:text name="worker.phone" size="30"></s:text>
            	</td>
            </tr>
            <tr>
            	<td>
            		地址：
            		<s:text name="worker.address" size="128"></s:text>
            	</td>
            </tr>
        </table>
        <div class="user_query_btn">
            <s:submit name="saveWorker" id="button" value="确认提交"/>
        </div>
    </s:form>
</div>
</body>
</html>

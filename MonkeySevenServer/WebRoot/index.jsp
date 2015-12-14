<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>增加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="userAction_save" method="post">
    	<p>用户名：<input type="text" name="user.name"/></p>
    	<p>密码：<input type="text" name="user.password"/></p>
    	<p>角色：
    	<select name="user.role">
    	<option value="1">管理员</option>
    	<option value="2">普通用户</option>
    	</select></p>
    	<p><input type="submit" value="提交"/></p>
    </form>
  </body>
</html>

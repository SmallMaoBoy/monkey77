<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showdataCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body class=""> 
  <!--<![endif]-->
    
     <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Jack Smith
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">猴七七</span> <span class="second">提取点店员管理系统</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>管理总览</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="index1.html">Home主页</a></li>
            <li ><a href="users.html">查看订单信息</a></li>
            <li ><a href="user.html">查看商品信息</a></li>
            <li ><a href="user.html">更改订单状态</a></li>
            
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户管理<span class="label label-info">+3</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="sign-in.html">更换账户</a></li>
            <li ><a href="#">查看个人信息</a></li>
            <li ><a href="reset-password.html">修改密码</a></li>
            <li ><a href="#">添加账户</a></li>
        </ul>
        
    </div>
    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">查看顾客信息</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li class="active">查看顾客信息</li>
        </ul>
        <div>

        <div class="container-fluid">
            <div class="row-fluid">
                    <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">顾客列表</div>

  <!-- Table -->
  <table class="table">
   <tr>
   <td>顾客手机号</td>
   <td>顾客姓名</td>
   <td>顾客性别</td>
</tr>
<c:forEach items="${sessionScope.Customer}" var="cus">
<tr>
   <td>${cus.mobile}</td>
   <td>${cus.name}</td>
   <td>${cus.sex}</td>
   
</tr>
</c:forEach>
  </table>
</div>
<div>
<nav>
  <ul class="pagination112">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
<div>
<div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="搜索顾客信息...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Search!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div>

                    
                    <footer>
                        <hr>

                        
                        <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">alex</a></p>

                        <p>&copy; 2016 <a href="#" target="_blank">Portnine</a></p>
                    </footer>
                    
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>

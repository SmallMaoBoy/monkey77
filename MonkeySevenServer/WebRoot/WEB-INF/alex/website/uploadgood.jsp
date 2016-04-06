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
    
    <title>采购员管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/bootstrap/css/alex.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/font-awesome/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/alexweb/alex/website/stylesheets/theme.css"/>
    <script src="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/bootstrap/js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/bootstrap/js/alex.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/alexweb/alex/website/lib/ajaxfileupload.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/alexweb/alex/website/lib/upload.js" type="text/javascript"></script>
    
    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    
    
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/fot-awsome/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/fot-awsome/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/fot-awsome/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/fot-awsome/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/alexweb/alex/website/lib/lib/fot-awsome/assets/ico/apple-touch-icon-57-precomposed.png">
    
    
    

  </head>
  
  <body class=""> 
  <!--<![endif]-->
  
  <!-- 修改商品价格的Modal  4-->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">商品价格为：</h4>
      </div>
      <div class="modal-body">
       <input type="text" id="shuju4" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary tijiao4">保存修改</button>
      </div>
    </div>
  </div>
</div>
  
  
  <!-- 修改商品数量的Modal  5-->
<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">商品数量为：</h4>
      </div>
      <div class="modal-body">
       <input type="text" id="shuju5" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary tijiao5">保存修改</button>
      </div>
    </div>
  </div>
</div>
  
  
  
  
  
  
  
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${sessionScope.user.account}
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
                <a class="brand" href="index.html"><span class="first">猴七七</span> <span class="second">采购员管理系统</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>商品管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="/MonkeySevenServer/kung/backbuyer">主页</a></li>
            <li ><a href="/MonkeySevenServer/kung/showgooddata?firstIndex=0&num=5">商品上下架</a></li>
            <li ><a href="/MonkeySevenServer/kung/showgooddata?firstIndex=0&num=5">制定价格</a></li>
            <li ><a href="/MonkeySevenServer/kung/showgooddata?firstIndex=0&num=5">管理商品数量</a></li>
            
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>需求订单管理<span class="label label-info">+3</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata">需求订单管理</a></li>
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata">填入买入价格</a></li>
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata">买入所需商品</a></li>
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata">更改订单状态</a></li>
            
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>制定秒杀商品活动<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">新活动</a></li>
            <li ><a href="404.html">已举行活动</a></li>
            <li ><a href="500.html">活动列表</a></li>
            <li ><a href="503.html">活动总览</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>管理商品分类信息</a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.html">商品分类</a></li>
            <li ><a href="terms-and-conditions.html">商品信息</a></li>
            <li ><a href="privacy-policy.html">商品一览</a></li>
            
        </ul>
     
       
        <a href="help.html" class="nav-header" ><i class="icon-question-sign"></i>帮助</a>
        
    </div>
    
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">上传照片</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li class="active">上传商品图片</li>
        </ul>
        <div>

        <div class="container-fluid">
            <div class="row-fluid">
                    <div class="panel panel-default">
  <!-- Default panel contents -->

</div>
<div class="form-group">
    <label for="exampleInputFile">选择商品首页显示的图片</label>
    <input type="file" name="file" id="file">
    <button class="btn btn-default" type="submit"  onclick="FileUpload(${sessionScope.goodId});">上传</button><Br/>
    <img src="" alt="" id="img" width="50%" height="50px" class="img-rounded">
</div>
<div class="form-group">
    <label for="exampleInputFile">选择商品轮播图的图片</label>
    <input type="file" name="file" id="file1">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},1,2);">上传</button><Br/>
    <input type="file" name="file" id="file2">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},2,2);">上传</button><Br/>
    <input type="file" name="file" id="file3">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},3,2);">上传</button><Br/>
    <input type="file" name="file" id="file4">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},4,2);">上传</button><Br/>
    <img src="" alt="" id="img1" width="20%" height="50px" class="img-rounded">
    <img src="" alt="" id="img2" width="20%" height="50px" class="img-rounded">
    <img src="" alt="" id="img3" width="20%" height="50px" class="img-rounded">
    <img src="" alt="" id="img4" width="20%" height="50px" class="img-rounded">
</div>
<div class="form-group">
    <label for="exampleInputFile">选择商品介绍的图片</label>
    <input type="file" name="file" id="file5">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},5,3);">上传</button><Br/>
    <input type="file" name="file" id="file6">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},6,3);">上传</button><Br/>
    <input type="file" name="file" id="file7">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},7,3);">上传</button><Br/>
    <input type="file" name="file" id="file8">
    <button class="btn btn-default" type="submit"  onclick="FileListUpload(${sessionScope.goodId},8,3);">上传</button><Br/>
    <img src="" alt="" id="img5" width="20%" height="50px" class="img-thumbnail">
    <img src="" alt="" id="img6" width="20%" height="50px" class="img-thumbnail">
    <img src="" alt="" id="img7" width="20%" height="50px" class="img-thumbnail">
    <img src="" alt="" id="img8" width="20%" height="50px" class="img-thumbnail">
</div>

                    
                    <footer>
                        <hr>

                        
                        <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="2016alex" target="_blank">alex</a></p>

                        <p>&copy; 2016 <a href="#" target="_blank">Portnine</a></p>
                    </footer>
                    
            </div>
        </div>
    </div>
    

    


    
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


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
            <li ><a href="/MonkeySevenServer/kung/createGoodAction_show">创建新商品</a></li>
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
            <div class="stats">
    <p class="stat"><span class="number">53</span>客户信息</p>
    <p class="stat"><span class="number">27</span>任务</p>
    <p class="stat"><span class="number">15</span>待处理</p>
</div>

            <h1 class="page-title">信息总览</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">管理</li>
        </ul>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>信息:</strong> 欢迎您来到业务员管理系统!
    </div>

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">最新动态</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">2,500</p>
                        <p class="detail">用户总数</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">3,299</p>
                        <p class="detail">订阅者</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">$1,500</p>
                        <p class="detail">待定</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">$12,675</p>
                        <p class="detail">已完成</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">用户总览<span class="label label-warning">+10</span></a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>姓</th>
                  <th>名</th>
                  <th>用户名</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Mark</td>
                  <td>Tompson</td>
                  <td>the_mark7</td>
                </tr>
                <tr>
                  <td>Ashley</td>
                  <td>Jacobs</td>
                  <td>ash11927</td>
                </tr>
                <tr>
                  <td>Audrey</td>
                  <td>Ann</td>
                  <td>audann84</td>
                </tr>
                <tr>
                  <td>John</td>
                  <td>Robinson</td>
                  <td>jr5527</td>
                </tr>
                <tr>
                  <td>Aaron</td>
                  <td>Butler</td>
                  <td>aaron_butler</td>
                </tr>
                <tr>
                  <td>Chris</td>
                  <td>Albert</td>
                  <td>cab79</td>
                </tr>
              </tbody>
            </table>
            <p><a href="users.html">More...</a></p>
        </div>
    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">Collapsible </a>
        <div id="widget1container" class="block-body collapse in">
            <h2>Here's a Tip</h2>
            <p>This template was developed with <a href="http://middlemanapp.com/" target="_blank">Middleman</a> and includes .erb layouts and views.</p>
            <p>All of the views you see here (sign in, sign up, users, etc) are already split up so you don't have to waste your time doing it yourself!</p>
            <p>The layout.erb file includes the header, footer, and side navigation and all of the views are broken out into their own files.</p>
            <p>If you aren't using Ruby, there is also a set of plain HTML files for each page, just like you would expect.</p>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">历史记录</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
              <tbody>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Mark Otto</p>
                      </td>
                      <td>
                          <p>Amount: $1,247</p>
                      </td>
                      <td>
                          <p>Date: 7/19/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Audrey Ann</p>
                      </td>
                      <td>
                          <p>Amount: $2,793</p>
                      </td>
                      <td>
                          <p>Date: 7/12/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Mark Tompson</p>
                      </td>
                      <td>
                          <p>Amount: $2,349</p>
                      </td>
                      <td>
                          <p>Date: 3/10/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Ashley Jacobs</p>
                      </td>
                      <td>
                          <p>Amount: $1,192</p>
                      </td>
                      <td>
                          <p>Date: 1/19/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                    
              </tbody>
            </table>
        </div>
    </div>
    <div class="block span6">
        <p class="block-heading">Not Collapsible</p>
        <div class="block-body">
            <h2>Built with Less</h2>
            <p>The CSS is built with Less. There is a compiled version included if you prefer plain CSS.</p>
            <p>Fava bean jícama seakale beetroot courgette shallot amaranth pea garbanzo carrot radicchio peanut leek pea sprouts arugula brussels sprout green bean. Spring onion broccoli chicory shallot winter purslane pumpkin gumbo cabbage squash beet greens lettuce celery. Gram zucchini swiss chard mustard burdock radish brussels sprout groundnut. Asparagus horseradish beet greens broccoli brussels.</p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
    </div>
</div>


                    
                    <footer>
                        <hr>

                        
                        <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>

                        <p>&copy; 2012 <a href="#" target="_blank">Portnine</a></p>
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

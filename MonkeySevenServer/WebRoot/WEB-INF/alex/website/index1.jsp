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
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata_showToday">今日订单需求</a></li>
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata_showAll">历史订单需求</a></li>
            <li ><a href="/MonkeySevenServer/kung/showbuyorderdata_getBuyingData?index=0">查看未购买订单</a></li>
            
            
        </ul>

        
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
                  <td>梁</td>
                  <td>宇富</td>
                  <td>the_mark7</td>
                </tr>
                <tr>
                  <td>孔</td>
                  <td>祥晟</td>
                  <td>ash11927</td>
                </tr>
                <tr>
                  <td>梁</td>
                  <td>艺灿</td>
                  <td>audann84</td>
                </tr>
                <tr>
                  <td>黄</td>
                  <td>毅麟</td>
                  <td>jr5527</td>
                </tr>
                <tr>
                  <td>王</td>
                  <td>师傅</td>
                  <td>aaron_butler</td>
                </tr>
                <tr>
                  <td>赵</td>
                  <td>日天</td>
                  <td>cab79</td>
                </tr>
              </tbody>
            </table>
            <p><a href="users.html">More...</a></p>
        </div>
    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">水果小知识 </a>
        <div id="widget1container" class="block-body collapse in">
            <h2>适合初夏吃的水果</h2>
            <p>1.梨：有生津止渴、化痰清火、润肺去燥的功能，适宜肺热咳

    嗽、大便燥结、高血压以及肝炎、肝硬化患者。2.香蕉：性甘寒，具有清热止渴、清胃凉血、润肠通便、降压利尿的功效。3.苹果：性平，味甘酸，具有补心养气、生津止渴、健脾胃作
用。
4.
猕猴桃：具有解热、止渴等功效</p>
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
                          <p><i class="icon-user"></i> 赵日天</p>
                      </td>
                      <td>
                          <p>订单总价: $1,247</p>
                      </td>
                      <td>
                          <p>Date: 7/19/2016</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> 叶良辰</p>
                      </td>
                      <td>
                          <p>订单总价: $2,793</p>
                      </td>
                      <td>
                          <p>Date: 7/12/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> 龙傲天</p>
                      </td>
                      <td>
                          <p>订单总价: $2,349</p>
                      </td>
                      <td>
                          <p>Date: 3/10/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> 福尔康</p>
                      </td>
                      <td>
                          <p>订单总价: $1,192</p>
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
        <p class="block-heading">水果小知识</p>
        <div class="block-body">
            <h2>香瓜的营养价值</h2>
            <p>1.含大量碳水化合物及柠檬酸等，可消暑清热、生津解渴、除烦； 2.可将不溶性蛋白质转变成可溶性蛋白质，帮助肾脏病人吸收营养；3.瓜蒂中的葫芦素B能保护肝脏，减轻慢性肝损伤，但瓜蒂有毒，生食过量会中毒；4.有驱杀蛔虫，丝虫等作用；5.
营养丰富，可补充人体所需的能量及营养素
.</p>
        </div>
    </div>
</div>


                    
                    <footer>
                        <hr>

                        
                        <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="alex" target="_blank">alex</a></p>

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

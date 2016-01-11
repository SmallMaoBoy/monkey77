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
    
    <title>猴七七提取点店员管理系统</title>
    
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
                <a class="brand" href="index.html"><span class="first">猴七七</span> <span class="second">提取点店员管理系统</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>管理总览</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="/MonkeySevenServer/kung/backbi">Home主页</a></li>
            <li ><a href="/MonkeySevenServer/kung/showorderdata">查看订单信息</a></li>
            <li ><a href="/MonkeySevenServer/kung/showcustomerdata">查看商品信息</a></li>
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
        <strong>信息:</strong> 欢迎您来到提取点店员管理系统!
    </div>

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">最新动态</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">2,500</p>
                        <p class="detail">客户人数</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">3,299</p>
                        <p class="detail">订单总数</p>
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
        <a href="#widget1container" class="block-heading" data-toggle="collapse">简单谈谈 </a>
        <div id="widget1container" class="block-body collapse in">
            <h2>出师表</h2>
            <p>先帝创业未半而中道崩殂(cú)，今天下三分，益州疲(pí)弊，此诚危急存亡之秋也。然侍卫之臣不懈(xiè)于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗(yí)德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞(sè)忠谏之路也。

宫中府中，俱为一体，陟(zhì )罚臧(zāng)否(pǐ)，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不宜偏私，使内外异法也。

侍中、侍郎郭攸(yōu)之、费祎(yī)、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗(wèi)陛下。愚以为宫中之事，事无大小，悉以咨之，然后施行，必能裨(bì)补阙漏，有所广益。

将军向宠，性行（xíng）淑均，晓畅军事，试用于昔日，先帝称之曰能，是以众议举宠为督。愚以为营中之事，悉以咨之，必能使行(háng )阵和睦，优劣得所。

亲贤臣，远小人，此先汉所以兴隆也;亲小人，远贤臣，此后汉所以倾颓也。先帝在时，每与臣论此事，未尝不叹息痛恨于桓（huán）、灵也。侍中、尚书、长(zhǎng)史、参军，此悉贞良死节之臣，愿陛下亲之信之，则汉室之隆，可计日而待也。

臣本布衣，躬耕于南阳，苟全性命于乱世，不求闻(wén)达于诸侯。先帝不以臣卑（bēi）鄙（bǐ），猥(wěi)自枉屈，三顾臣于草庐之中，咨臣以当世之事，由是感激，遂许先帝以驱驰。后值倾覆，受任于败军之际，奉命于危难之间,尔来二十有(yòu)一年矣! 

先帝知臣谨慎，故临崩寄臣以大事也。受命以来，夙(sù)夜忧叹，恐托付不效，以伤先帝之明，故五月渡（dù）泸，深入不毛。今南方已定，兵甲已足，当奖率三军，北定中原，庶(shù)竭驽(nú)钝，攘(rǎng)除奸凶，兴复汉室，还于旧都。此臣所以报先帝而忠陛下之职分也。至于斟酌损益，进尽忠言，则攸之、祎、允之任也。

愿陛下托臣以讨贼兴复之效，不效,则治臣之罪，以告先帝之灵。若无兴德之言，则责攸之、祎、允等之慢，以彰其咎(jiù)。陛下亦宜自谋，以咨诹(zōu)善道，察纳雅言，深追先帝遗诏。臣不胜受恩感激!

今当远离，临表涕零，不知所云。</p>
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
        <a href="#widget1container" class="block-heading" data-toggle="collapse">简单谈谈 </a>
        <div id="widget1container" class="block-body collapse in">
            <h2>简易管理系统</h2>
            <p>目前管理系统还相对简陋，请多多包涵</p>
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
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>

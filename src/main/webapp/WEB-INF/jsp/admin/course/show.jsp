<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>欢迎来到节点网络学习平台</title>

    <!-- The styles -->
    <link id="bs-css" href="<%= basePath%>/static/css/bootstrap-cerulean.min.css" rel="stylesheet">


    <link href="<%= basePath%>/static/css/charisma-app.css" rel="stylesheet">
    <link href='<%= basePath%>/static/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%= basePath%>/static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/uploadify.css' rel='stylesheet'>
    <link href='<%= basePath%>/static/css/animate.min.css' rel='stylesheet'>
  
    <link href="<%= basePath%>/static/css/style.css" rel='stylesheet' type='text/css'/>

    <!-- jQuery -->
    <script src="<%= basePath%>/static/bower_components/jquery/jquery.min.js"></script>


    <!-- The fav icon -->
    <link rel="shortcut icon" href="<%= basePath%>/static/img/favicon.ico">
    
  <!-- Chang URLs to wherever Video.js files will be hosted -->
  <link href="<%= basePath%>/static/css/video-js.css" rel="stylesheet" type="text/css">
  <!-- video.js must be in the <head> for older IEs to work. -->
  <script src="<%= basePath%>/static/js/video.js"></script>

  <!-- Unless using the CDN hosted version, update the URL to the Flash SWF 
  <script>
    videojs.options.flash.swf = "video-js.swf";
  </script>
-->    
    
    

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="../static/img/logo20.png" class="hidden-xs"/>
                <span>Study</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">个人中心</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">登出</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

        </div>
    </div>
   
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">主菜单</li>
                        
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-wrench"></i><span>系统设置</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <c:forEach items="${allMenu}" var="c">
                                	<li><a href="<%= basePath%>${c.url}">${c.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                         
                        
                        
                         <c:forEach items="${allKinds}" var="c">
                        <li><a class="ajax-link" href="<%=basePath %>${c.url}"><i
                                    class="${c.icon}"></i><span>${c.name}</span></a></li>
                        </c:forEach>
                    </ul>
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    <ul class="breadcrumb">
        <li>
            <a href="#">首页</a>
        </li>
        <li>
            <a href="#">菜单设置</a>
        </li>
    </ul>
</div>
<div class=" row">
    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="6 new members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-user blue"></i>

            <div>Total Members</div>
            <div>507</div>
            <span class="notification">6</span>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="4 new pro members." class="well top-block" href="#">
            <i class="glyphicon glyphicon-star green"></i>

            <div>Pro Members</div>
            <div>228</div>
            <span class="notification green">4</span>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="$34 new sales." class="well top-block" href="#">
            <i class="glyphicon glyphicon-shopping-cart yellow"></i>

            <div>Sales</div>
            <div>$13320</div>
            <span class="notification yellow">$34</span>
        </a>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6">
        <a data-toggle="tooltip" title="12 new messages." class="well top-block" href="#">
            <i class="glyphicon glyphicon-envelope red"></i>

            <div>Messages</div>
            <div>25</div>
            <span class="notification red">12</span>
        </a>
    </div>
</div>


<!-- 视频列表 -->
<div>
                   
                    <c:forEach items="${list}" var="c">
                    	
                  <!--  -->
                      <div class="col-md-3 resent-grid recommended-grid slider-top-grids">
						<div class="resent-grid-img recommended-grid-img">
							<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="239.26" height="222"
						      data-setup="{}">
						    <source src="${c.filesPath}" type='video/mp4' />
						    <source src="${c.filesPath}" type='video/webm' />
						    <source src="${c.filesPath}" type='video/ogg' />
						    <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track>
						    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track>
						  </video>
						</div>
						
						
						<div class="resent-grid-info recommended-grid-info">
							<h3>
								<a href="#" class="title title-info">描述信息</a>
							</h3>
							<ul>
								<li><p class="author author-info"><a href="#" class="author">上传者</a></p></li>
								<li class="right-list"><p class="views views-info">2,114,200 views</p></li>
							</ul>
						</div>
						
						
						
					</div>
				  </c:forEach>
					</div>
                </div>
            </div>
					
					
					
					
					
					<!-- 
					<div class="col-md-3 resent-grid recommended-grid slider-top-grids">
						<div class="resent-grid-img recommended-grid-img">
							 <a href="single.html"><img src="../static/img/t1.jpg" alt="" /></a>
							<div class="time">
								<p>3:04</p>
							</div>
							<div class="clck">
								<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
							</div>
						</div>
						<div class="resent-grid-info recommended-grid-info">
							<h3>
								<a href="single.html" class="title title-info">Pellentesque vitae pulvinar tortor nullam interdum metus a imperdiet</a>
							</h3>
							<ul>
								<li><p class="author author-info"><a href="#" class="author">John Maniya</a></p></li>
								<li class="right-list"><p class="views views-info">2,114,200 views</p></li>
							</ul>
						</div>
					</div>
					 -->
					


</div>
 









<!-- content ends -->


<!-- external javascript -->

<script src="<%= basePath%>/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>

<!-- library for cookie management -->
<script src="<%= basePath%>/static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%= basePath%>/static/bower_components/moment/min/moment.min.js'></script>
<script src='<%= basePath%>/static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%= basePath%>/static/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<%= basePath%>/static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%= basePath%>/static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%= basePath%>/static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%= basePath%>/static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%= basePath%>/static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<%= basePath%>/static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<!-- autogrowing textarea plugin -->
<script src="<%= basePath%>/static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="<%= basePath%>/static/js/jquery.uploadify-3.1.min.js"></script>

<script src="<%= basePath%>/static/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="<%= basePath%>/static/js/charisma.js"></script>






</body>
</html>

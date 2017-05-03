<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script src="<%= basePath%>/static/bower_components/jquery/jquery.js"></script>


    <!-- The fav icon -->
    <link rel="shortcut icon" href="<%= basePath%>/static/img/favicon.ico">
    
    
    <!-- stylesheet css -->
	<link rel="stylesheet" href="<%= basePath%>/static/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%= basePath%>/static/css/templatemo-blue.css">
   
    

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
            <a class="navbar-brand" href="index.html"> <img alt="Study Logo" src="../static/img/feasibility_study.png" class="hidden-xs"/>
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
                        class="hidden-sm hidden-xs">主题 /皮肤切换</span>
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
                <a href="<%= basePath%>/message">个人中心</a>
            </li>
            <li>
                <a href="<%= basePath%>/message/add">设置个人信息</a>
            </li>
        </ul>
    </div>
    
    
<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<img src="<%= basePath%>/static/img/tm-easy-profile.jpg" class="img-responsive img-circle tm-border" alt="templatemo easy profile">
				<h1 class="tm-title bold shadow">Hi, I am Julia</h1>
				<h1 class="white bold shadow">Creative Director</h1>
			</div>
		</div>
	</div>
</header>


<!-- about and skills section -->
<section class="container">
	<div class="row">
		<div class="col-md-6 col-sm-12">
			<div class="about">
				<h3 class="accent">Easy Profile</h3>
				<h2>Bootstrap v3.3.5</h2>
				<p>This easy HTML profile is brought to you by templatemo website. There are 4 color themes, <a href="index-green.html">Green</a>, <a href="index.html">Blue</a>, <a href="index-gray.html">Gray</a>, and <a href="index-orange.html">Orange</a>. Sed vitae dui in neque elementum tempor eu id risus. Phasellus sed facilisis lacus, et venenatis augue.</p>
			</div>
		</div>
		<div class="col-md-6 col-sm-12">
			<div class="skills">
				<h2 class="white">Skills</h2>
				<strong>PHP MySQL</strong>
				<span class="pull-right">70%</span>
					<div class="progress">
						<div class="progress-bar progress-bar-primary" role="progressbar" 
                        aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;"></div>
					</div>
				<strong>UI/UX Design</strong>
				<span class="pull-right">85%</span>
					<div class="progress">
						<div class="progress-bar progress-bar-primary" role="progressbar" 
                        aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%;"></div>
					</div>
				<strong>Bootstrap</strong>
				<span class="pull-right">95%</span>
					<div class="progress">
						<div class="progress-bar progress-bar-primary" role="progressbar" 
                        aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;"></div>
					</div>
			</div>
		</div>
	</div>
</section>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
<!-- education and languages -->
<section class="container">
	<div class="row">
		<div class="col-md-8 col-sm-12">
			<div class="education">
				<h2 class="white">Education</h2>
					<div class="education-content">
						<h4 class="education-title accent">New Web Design</h4>
							<div class="education-school">
								<h5>School of Media</h5><span></span>
								<h5>2030 January - 2034 December</h5>
							</div>
						<p class="education-description">In lacinia leo sed quam feugiat, ac efficitur dui tristique. Ut venenatis, odio quis cursus egestas, nulla sem volutpat diam, ac dapibus nisl ipsum ut ipsum. Nunc tincidunt libero non magna placerat elementum.</p>
					</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<div class="languages">
				<h2>Languages</h2>
					<ul>
						<li>Myanmar / Thai</li>
						<li>English / Spanish</li>
						<li>Chinese / Japanese</li>
						<li>Arabic / Hebrew</li>
					</ul>
			</div>
		</div>
	</div>
</section>

<!-- contact and experience -->
<section class="container">
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="contact">
				<h2>Contact</h2>
					<p><i class="fa fa-map-marker"></i> 123 Rama IX Road, Bangkok</p>
					<p><i class="fa fa-phone"></i> 010-020-0890</p>
					<p><i class="fa fa-envelope"></i> easy@company.com</p>
					<p><i class="fa fa-globe"></i> www.company.com</p>
			</div>
		</div>
		<div class="col-md-8 col-sm-12">
			<div class="experience">
				<h2 class="white">Experiences</h2>
					<div class="experience-content">
						<h4 class="experience-title accent">Website Development</h4>
						<h5>New Media Company</h5><span></span>
						<h5>2035 January - 2036 April</h5>
						<p class="education-description">Cras porta tincidunt sem, in sollicitudin lorem efficitur ut. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.</p>
					</div>
			</div>
		</div>
	</div>
</section>
<!--/row-->

    
    </div><!--/span-->

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>
            <script>
                (adsbygoogle = window.adsbygoogle || []).push({});
            </script>
        </div>
        
        <div class="col-md-2 col-lg-3 col-sm-12 col-xs-12 email-subscription-footer">
            <div class="mc_embed_signup">
                
            </div>

            <!--End mc_embed_signup-->
        </div>

    </div>
    <!-- Ad ends -->

   

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
    
    </footer>

</div><!--/.fluid-container-->



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
<script src="<%= basePath%>/static/js/jquery.iphone.toggle.js"></script>

<!-- javascript js -->	
<script src="<%= basePath%>/static/js/bootstrap.min.js"></script>	
<script src="<%= basePath%>/static/js/jquery.backstretch.min.js"></script>
<script src="<%= basePath%>/static/js/custom.js"></script>



</body>
</html>

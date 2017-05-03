<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>

     <!-- The styles -->
    <link id="bs-css" href="<%= basePath%>static/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%= basePath%>static/css/charisma-app.css" rel="stylesheet">
    <link href='<%= basePath%>static/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%= basePath%>static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%= basePath%>static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%= basePath%>static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%= basePath%>static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%= basePath%>static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/uploadify.css' rel='stylesheet'>
    <link href='<%= basePath%>static/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="<%= basePath%>static/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="<%= basePath%>static/img/favicon.ico">

</head>

<body>
<div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>节点学习系统</h2>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info"> 用户登录</div>${message}
            <form class="form-horizontal" action="<%=basePath %>user/login.do" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" value="${username}" name="username" class="form-control" placeholder="用户名">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" name="password" class="form-control" placeholder="密码">
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend">
                        <label class="remember" for="remember"><input type="checkbox" id="remember"> Remember me</label>
                    </div>
                    <div class="clearfix"></div>
                    <p class="center col-md-5">
                        <a href="<%= basePath%>user/register.do">
	                        <button type="button" class="btn btn-primary">注册</button>
	                     </a>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="<%= basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<%= basePath%>static/js/jquery.cookie.js"></script>
<!-- calender plugin 
<script src='<%= basePath%>static/bower_components/moment/min/moment.min.js'></script>
-->
<script src='<%= basePath%>static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%= basePath%>static/js/jquery.dataTables.min.js'></script>

</body>
</html>

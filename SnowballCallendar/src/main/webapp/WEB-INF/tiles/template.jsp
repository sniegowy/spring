<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<title>Snowball Callendar</title>
    <style type="text/css">
    body {
        margin:0px;
        padding:0px;
        height:100%;
        overflow:hidden;
    }
 
    .page {
        min-height:100%;
        margin: auto 10%;
        width: 80%;
        position:relative;
    }
     
    .menu {
        width:100%;
        height:100px;
    }
    
    .menu .navbar-default .navbar-brand {
    	color: #333;
    }
    
    .menu .navbar-default .navbar-nav>.active>a {
    	color: #ffffff;
    	background-color: #5cb85c;
    	border-color: #4cae4c;
    }
    
    .menu .navbar-default .navbar-nav>.active>a:focus, .navbar-default .navbar-nav>.active>a:hover {
        color: #fff;
	    background-color: #449d44;
	    border-color: #398439;
    }
    
    .menu .navbar-default .navbar-nav>li>a {
    	color: #333;	
    }
    
    .menu .navbar-default .navbar-nav>li>a:focus, .navbar-default .navbar-nav>li>a:hover {
    	color: #333;
    	background-color: #e6e6e6;
    	border-color: #adadad;	
    }
    
    .menu .navbar-default {
    	border-color: #f8f8f8;
    	background-color: #ffffff;
    }
    
    .content {
    	width:100%;
        padding-bottom:20px;
        overflow:hidden;
    }
     
    .footer {
        clear:both;
        position:relative;
        bottom:0;
        left:0;
        width:100%;
        height:20px;
        padding-top: 50px;
    }
     
    </style>
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>
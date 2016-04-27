<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link href="../resources/css/main.css" rel="stylesheet" type="text/css">
	
	<title>Snowball Callendar</title>
    
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>
<!DOCTYPE html>
<html>

<head>
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href=css/home.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
	
		<form action="logout" method="get">
			<button class="btn btn-md btn-danger btn-block" name="registration"
				type="Submit">Logout</button>
		</form>    
		
		<div class="panel-group" style="margin-top:40px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span></span>
				</div>
				<div class="panel-body">
					<img src="images/beer.jpg" class="img-responsive center-block" width="400" height="400" alt="Beer" /> 
				</div>
				<p class="admin-message-text text-center"></p>
			</div>
		</div>
		
	</div>
</body>
</html>
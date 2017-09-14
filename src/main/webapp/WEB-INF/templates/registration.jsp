<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="css/registration.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Go
			To Login Page</button>
	</form>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form autocomplete="off" action="#" action="/registration"
					method="post" class="form-horizontal" role="form">
					<h2>Registration Form</h2>
					<div class="form-group">
						<div class="col-sm-9">
							<label class="validation-message"></label> <input type="text"
								placeholder="Name" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<label class="validation-message"></label> <input type="text"
								placeholder="Last Name" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" placeholder="Email" class="form-control" /> <label
								class="validation-message"></label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="password" placeholder="Password"
								class="form-control" /> <label class="validation-message"></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register
								User</button>
						</div>
					</div>

					<span></span>


				</form>
			</div>
		</div>
	</div>

</body>
</html>
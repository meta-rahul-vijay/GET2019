<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<div align="center">
		<div class="card" style="width: 24rem;">
			<c:if test="${not empty errorMsg}">
				<div class="alert alert-danger alert-dismissible" role="alert"
					align="center">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">x</span>
					</button>
					<strong>${errorMsg}</strong>
				</div>
			</c:if>
			<div class="card-header">
				<h3 class="card-title">Login</h3>
			</div>
			<div class="card-body">
				<form action="/login" method="post">
					<div class="form-group">
						<input type="input" placeholder="username" id="username"
							name="username">
					</div>
					<div class="form-group">
						<input type="password" placeholder="password" id="password"
							name="password">
					</div>
					<div class="form-group">
						<input type="submit" value="login">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
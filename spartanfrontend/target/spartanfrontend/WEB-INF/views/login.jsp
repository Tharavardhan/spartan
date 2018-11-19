<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<div class="container">
	<h4>Login</h4>
	<c:if test="${error}">
		<div class="alert alert-danger">
			<strong>User Name or Password incorrect</strong>
		</div>
	</c:if>
	<form action="perform_login" method="post">
		<input type="text" id="user_Name" name="user_Name"
			class="form-control" placeholder="E-mail Address" />
		</br> <input type="password" id="userPassword" name="userPassword"
			class="form-control" placeholder="password" /> </br>
		<div class="wrapper">
			<span class="group-btn"> <input type="submit"
				class="btn btn-primary btn-md" value="Login"></span>
			</div>
	</form>
</div>

<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400);

body {
	background-color: #fff;
	-webkit-font-smoothing: antialiased;
	font: normal 14px Roboto, arial, sans-serif;
}

#justpushtobottom {
	padding-bottom: 10%;
}

.container {
	padding-top: 1%;
	padding-right: 30%;
	padding-left: 30%;
}

.form-login {
	background-color: #EDEDED;
	padding-top: 10px;
	padding-bottom: 20px;
	padding-left: 20px;
	padding-right: 20px;
	border-radius: 15px;
	border-color: #d2d2d2;
	border-width: 5px;
	box-shadow: 0 1px 0 #cfcfcf;
}

h4 {
	border: 0 solid #fff;
	border-bottom-width: 1px;
	padding-bottom: 10px;
	text-align: center;
}

.form-control {
	border-radius: 10px;
}

.wrapper {
	text-align: center;
}
</style>
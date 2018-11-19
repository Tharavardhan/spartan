<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextroot" value="${pageContext.request.contextPath}"></c:set>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<style>
.navbar-custom {
	background-color: #660066;
}

.collapse.navbar-collapse li a {
	color: #ffff1a;
	font-size: 21px;
	font-family: times new roman;
}

.collapse.navbar-collapse li a:hover {
background-color: transparent;}
#style1 {
	margin-left: -30px;
	margin-bottom: -10px;
	margin-right: 10px;
}
</style>
<nav class="navbar navbar-custom">
	<ul class="navbar-header">
		<img id="style1" src="${contextroot}/resources/navbarlogo.jpg"
			height="60px" width="100px" alt="GNB Logo" />
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#myNavbar" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
	</ul>
	<div class="collapse navbar-collapse" id="myNavbar">
		<c:choose>
			<c:when test="${sessionScope.userlogin==true}">
				<ul class="nav navbar-nav">
					<li><a href="${contextroot}/home">Home</a></li>
					<li><a href="${contextroot}/aboutus">About Us</a></li>
					<li><a href="${contextroot}/contactus">Contact Us</a></li>
					<li><a href="${contextroot}/allproducts">View All products</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
                    
					<li><a href="${contextroot}/user/viewCart"><span class="glyphicon">&#xe116;</span></a></li>
					<li><a href="${contextroot}/user/viewOrders"><span class="glyphicon glyphicon-list-alt "></span> View Orders</a></li>
					<li><a href="${contextroot}/Logout">Logout</a></li>
					<li><a href="">Welcome ${sessionScope.username}</a></li>
				</ul>
			</c:when>
			<c:when test="${sessionScope.userlogin==false}">
				<ul class="nav navbar-nav">

					<li><a href="${contextroot}/home"><span
							class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="${contextroot}/aboutus">About Us</a></li>
					<li><a href="${contextroot}/contactus">Contact Us</a></li>
					<li><a href="${contextroot}/admin/product">Product</a></li>
					<li><a href="${contextroot}/admin/category">Category</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${contextroot}/Logout"><span
							class="glyphicon glyphicon-user"></span> Logout</a></li>
					<li><a href=""><span class="glyphicon glyphicon-log-in"></span>
							Welcome ${sessionScope.username}</a></li>

				</ul>
			</c:when>
			<c:otherwise>
				<ul class="nav navbar-nav">

					<li><a href="${contextroot}/home"><span
							class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="${contextroot}/aboutus">About Us</a></li>
					<li><a href="${contextroot}/contactus">Contact Us</a></li>
					<li><a href="${contextroot}/allproducts">View All products</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${contextroot}/Login"><span
							class="glyphicon glyphicon-user"></span> Login</a></li>
					<li><a href="${contextroot}/register"><span
							class="glyphicon glyphicon-log-in"></span> Register</a></li>				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</nav>




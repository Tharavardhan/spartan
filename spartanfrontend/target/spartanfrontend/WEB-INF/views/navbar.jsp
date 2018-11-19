<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextroot" value="${pageContext.request.contextPath}"></c:set>

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

 <style>
.navbar-custom {
    color: black;
    background-color:#E64C23;
	
}
.collapse.navbar-collapse li a	 {
color : #040400;
font-size : 21px;
font-family : times new roman;
}

#style1{
margin-left : -30px;
margin-bottom : -10px;
margin-right : 10px;


</style>
<nav class="navbar navbar-custom">

    <ul class="navbar-header" >
      
        
        <img id="style1" src="${contextroot}/resources/navbarlogo.jpg" height="60px" width="100px" alt="GNB Logo"/>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </ul>
    
  <c:choose>
    <c:when test="${sessionScope.userlogin==true}">
    
    <div class="collapse navbar-collapse" id="myNavbar">
    
      <ul class="nav navbar-nav">
     
		<li class="active"><a href="${contextroot}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li class="dropdown">
<!--           <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-tasks"></span> Categories </a> -->
<!--           <ul class="dropdown-menu"> -->
<!--             <li><a href="">COMPONENTS</a></li> -->
<!--            </ul> -->
        </li>
        
		<li><a href="${contextroot}/aboutus">About Us</a></li>
        <li><a href="${contextroot}/contactus">Contact Us</a></li>		
<%--         <li><a href="${contextroot}/admin/product">Product</a></li> --%>
<%--           <li><a href="${contextroot}/admin/category">Category</a></li> --%>
            <li><a href="${contextroot}/allproducts">View All products</a></li>
		</ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextroot}/Logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        <li><a href=""><span class="glyphicon glyphicon-log-in"></span> Welcome ${sessionScope.username}</a></li>
        
      </ul>
      </c:when>
      <c:when test="${sessionScope.userlogin==false}">
      <div class="collapse navbar-collapse" id="myNavbar">
    
      <ul class="nav navbar-nav">
     
		<li class="active"><a href="${contextroot}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-tasks"></span> Categories </a>
<!--           <ul class="dropdown-menu"> -->
<!--             <li><a href="">COMPONENTS</a></li> -->
<!--            </ul> -->
        </li>
        
		<li><a href="${contextroot}/aboutus">About Us</a></li>
        <li><a href="${contextroot}/contactus">Contact Us</a></li>		
        <li><a href="${contextroot}/admin/product">Product</a></li>
          <li><a href="${contextroot}/admin/category">Category</a></li>
<%--             <li><a href="${contextroot}/allproducts">View All products</a></li> --%>
		</ul>
       <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextroot}/Logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        <li><a href=""><span class="glyphicon glyphicon-log-in"></span> Welcome ${sessionScope.username}</a></li>
        
      </ul>
      </c:when>
      <c:otherwise>
      <div class="collapse navbar-collapse" id="myNavbar">
    
      <ul class="nav navbar-nav">
     
		<li class="active"><a href="${contextroot}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li class="dropdown">
<!--           <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-tasks"></span> Categories </a> -->
<!--           <ul class="dropdown-menu"> -->
<!--             <li><a href="">COMPONENTS</a></li> -->
<!--            </ul> -->
        </li>
        
		<li><a href="${contextroot}/aboutus">About Us</a></li>
        <li><a href="${contextroot}/contactus">Contact Us</a></li>		
<%--         <li><a href="${contextroot}/admin/product">Product</a></li> --%>
<%--           <li><a href="${contextroot}/admin/category">Category</a></li> --%>
            <li><a href="${contextroot}/allproducts">View All products</a></li>
		</ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextroot}/Login"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><a href="${contextroot}/register"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
        
      </ul>
      
      
      
      </c:otherwise>
      </c:choose>
    </div>
  </div>
</nav>
  

  

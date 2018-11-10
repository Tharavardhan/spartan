<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>${title}</title>
 <link rel ="shortcut icon" href="resources/spartans2.ico"/>
 
 <link rel="stylesheet"

	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

	<script

	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
 
</head>
<body>
<c:import url="navbar.jsp"></c:import>

<c:if test="${sliderpage}">
<c:import url ="slider.jsp"/>
</c:if>

<c:if test="${aboutuspage}">
<c:import url ="aboutus.jsp"/>
</c:if>

<c:if test="${productpage}">
<c:import url ="product.jsp"/>
</c:if>


<c:if test="${categorypage}">
<c:import url ="category.jsp"/>
</c:if>


<c:if test="${contactuspage}">
<c:import url ="contactus.jsp"/>
</c:if>

<c:if test="${loginpage}">
<c:import url ="login.jsp"/>
</c:if>

<c:if test="${registerpage}">
<c:import url ="register.jsp"/>
</c:if>

<c:if test="${viewallproductspage}">
<c:import url ="viewallproducts.jsp"/>
</c:if>

<c:if test="${oneproductpage}">
<c:import url ="viewoneproduct.jsp"/>
</c:if>


<c:import url="footer.jsp"></c:import>
</body>
</html>

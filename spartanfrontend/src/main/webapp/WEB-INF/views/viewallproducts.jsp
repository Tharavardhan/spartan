<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.thumbnail {
	height: 200px;
}

.label-info {
	display: block;
	width: 320px;
	word-break: break-all;
}

.btn btn-info {
	background-color: #15cdc7;
}
</style>
 <div>
 <nav class="navbar navbar-custom">
  <a class="navbar-brand">Shop By Category</a>
  <div>
   <ul class="nav navbar-nav">
    <c:forEach items="${catlist}" var="c">
     <li><a href="products?catname=${c.category_Name}">${c.category_Name}</a>
     </li>
    </c:forEach>
   </ul>
  </div>
 </nav>
</div>





<div class="container">
	<div class="col-md-12">
		<c:forEach var="l" items="${prodlist}">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<h4 class="text-center">
						<span class="label label-info" style="word-wrap: break-word;">${l.product_Name}</span>
					</h4>
					<img src="resources/pimages/${l.product_id}.jpg"
						class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6">
								<h4 class="text-center">&#8377 ${l.price} /-</h4>
							</div>
							<div class="col-md-6">
								<a href='oneproduct?pid=${l.product_id}' class="btn btn-info"><span
									class="glyphicon glyphicon-info-sign"></span> Info</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

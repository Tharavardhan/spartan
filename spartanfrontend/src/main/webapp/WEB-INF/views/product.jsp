<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="CR"
 value="${pageContext.request.contextPath}/resources/pimages" />
<c:set var="cr2" value="${pageContext.request.contextPath}/admin"></c:set>

<!--Pulling Awesome Font -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
#justpushtobottom
{
height: 6%
}

body {
	background-color: #fff;
	-webkit-font-smoothing: antialiased;
	font: normal 14px Roboto, arial, sans-serif;
}

.container {
	padding-top: 1%;
	padding-right:5%;
	padding-left: 5%;
}

.stylingerror {
	color: red;
}

.form-login, .styling {
	background-color: #D7D7D7;
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
<script type="text/javascript">
	$(document).ready(function() {

		$('#table_id').dataTable({

			"pagingType" : "full_numbers",

			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ],

			"ordering" : true,

		});

	});
</script>

<div class="container">
	<c:if test="${edit}">
		<c:url var="url" value="updateproduct"></c:url>
	</c:if>
	<c:if test="${!edit}">
		<c:url var="url" value="addProduct"></c:url>
	</c:if>

	<div class="row">
		<div>
			
				<h4>Product</h4>


				<form:form modelAttribute="product" action="${url}"
					method="post" enctype="multipart/form-data">

					<c:if test="${edit}">
						<form:input type="text" id="product_id"
							class="form-control" path="product_id"
							readonly="true" />
					</c:if>

					<form:input type="text" id="Product_Name"
						class="form-control"
						placeholder="Product_Name" path="product_Name" />
					<form:errors path="product_Name" class="stylingerror" />
					<br />

					<form:input type="text" id="productDesc"
						class="form-control" placeholder="productDesc"
						path="productDesc" />
					<form:errors path="productDesc" class="stylingerror" />
					<br />

					<form:input type="text" id="Quantity"
						class="form-control" placeholder="Quantity"
						path="quantity" />
					<form:errors path="quantity" class="stylingerror" />
					<br />

					<form:input type="text" id="Price"
						class="form-control" placeholder="Price"
						path="price" />
					<form:errors path="price" class="stylingerror"/>
					<br />
					
					<form:input type="file" path="pimage" class="form-control"/>
                     <br/>
					<form:select path="category.category_id"
						class="form-control">
						<c:forEach items="${catlist}" var="c">
							<form:option value="${c.category_id}">${c.category_Name}</form:option>
						</c:forEach>
					</form:select>
					<%-- 			<form:input type="text" id="Category" class="form-control input-sm chat-input" placeholder="Category" path="category"/> --%>
					<%-- 			<form:errors  path="category" class="stylingerror"/> --%>
					<br />

					<div class="wrapper">
						<c:if test="${!edit}">
							<span class="group-btn"> <input type="submit"
								class="btn btn-primary btn-md" value="Add Product"> <i
								class="fa fa-sign-in"></i>
							</span>
						</c:if>
						<c:if test="${edit}">

							<span class="group-btn"> <input type="submit"
								class="btn btn-primary btn-md" value="Update Product"> <i
								class="fa fa-sign-in"></i>
							</span>
						</c:if>

					</div>

				</form:form>

			

		</div>
						<div class="table-responsive" style="padding-top: 20px">

					<table id="table_id" name="table_id" class="display"
						style="padding-top: 20px">

						<thead>

							<tr>
							<th>PRODUCT IMAGE</th>

								<th>PRODUCT ID</th>

								<th>PRODUCT NAME</th>

								<th>PRODUCT Description</th>

								<th>QUANTITY</th>

								<th>PRICE</th>

								<th>CATEGORY</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>

						</thead>

						<tbody>

							<c:forEach items="${prodlist}" var="l">

								<tr>
                                    <td><img src="${CR}/${l.product_id}.jpg" height="50px" width="50px"></td>
                                    
									<td>${l.product_id}</td>

									<td>${l.product_Name}</td>

									<td>${l.productDesc}</td>

									<td>${l.quantity}</td>

									<td>${l.price}</td>

									<td>${l.category.category_Name}</td>

									<td><a class='btn btn-success btn-xs'
										href="${cr2}/editproduct?pid=${l.product_id}"><span
											class="glyphicon glyphicon-edit"></span> Edit</a></td>

									<td><a class='btn btn-danger btn-xs'
										href="${cr2}/deleteproduct?pid=${l.product_id}"><span
											class="glyphicon glyphicon-trash"></span> Delete</a></td>

								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>

		
	</div>
</div>


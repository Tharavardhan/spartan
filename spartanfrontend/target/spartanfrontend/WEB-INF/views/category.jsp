<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cr1" value="${pageContext.request.contextPath}/admin"></c:set>
<link	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400);

body {
	background-color: #fff;
	-webkit-font-smoothing: antialiased;
	font: normal 14px Roboto, arial, sans-serif;
}
#justpushtobottom
{
height: 6%
}

.container {
	padding-top: 1%;
	padding-right:20%;
	padding-left: 20%;
}

.form-login {
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

.stylingerror {
	color: red;
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
		<c:url var="url" value="updatecategory"></c:url>
	</c:if>
	<c:if test="${!edit}">
		<c:url var="url" value="addCategory"></c:url>
	</c:if>
	<div class="row">
		<div>
		
				<h4>Category</h4>
				<form:form modelAttribute="category" action="${url}"
					method="post">
					<c:if test="${edit}">
						<form:input type="text" id="category_id"
							class="form-control" path="category_id"
							readonly="true" />
					</c:if>

					<form:input type="text" id="Category_Name"
						class="form-control"
						placeholder="Category_Name" path="category_Name" />
					<form:errors path="category_Name" class="stylingerror" />
					<br />

					<form:input type="text" id="CategoryDesc"
						class="form-control"
						placeholder="CategoryDesc" path="categoryDesc" />
					<form:errors path="categoryDesc" class="stylingerror" />
					<br />

					<div class="wrapper">
						<c:if test="${!edit}">
							<span class="group-btn"> <input type="submit"
								class="btn btn-primary btn-md" value="Add Category"> <i
								class="fa fa-sign-in"></i>
							</span>
						</c:if>
						<c:if test="${edit}">
							<span class="group-btn"> <input type="submit"
								class="btn btn-primary btn-md" value="Update Category"> <i
								class="fa fa-sign-in"></i>
							</span>
						</c:if>
					</div>
				</form:form>
				<div class="table-responsive" style="padding-top: 20px">

					<table id="table_id" name="table_id" class="display"
						style="padding-top: 20px">

						<thead>

							<tr>

								<th>CATEGORY ID</th>

								<th>CATEGORY NAME</th>

								<th>CATEGORY Description</th>

								<th>EDIT</th>

								<th>DELETE</th>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${catlist}" var="l">

								<tr>

									<td>${l.category_id}</td>

									<td>${l.category_Name}</td>

									<td>${l.categoryDesc}</td>


									<td><a class='btn btn-success btn-xs'
										href="${cr1}/editcategory?cname=${l.category_Name}"><span
											class="glyphicon glyphicon-edit"></span> Edit</a></td>

									<td><a class='btn btn-danger btn-xs'
										href="${cr1}/deletecategory?cname=${l.category_Name}"><span
											class="glyphicon glyphicon-trash"></span> Delete</a></td>

								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>


			</div>

		</div>
	</div>



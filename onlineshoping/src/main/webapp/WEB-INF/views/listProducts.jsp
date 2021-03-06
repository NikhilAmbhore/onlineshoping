<!-- Custom styles for this template -->
<link href="${css}/shop-item.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<div class="row">
				<div class="col-lg-3">
					<c:if test="${ UserClickAllProducts==true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>All Products</li>
						</ol>

					</c:if>
					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">

				<div class="col-xs-12">


					<table id="productListTable"
						class="table table-striped table-borderd">


						<thead>

							<tr>

								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>


							</tr>

						</thead>


						<tfoot>

							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<!-- /.col-lg-9 -->
	</div>
</div>
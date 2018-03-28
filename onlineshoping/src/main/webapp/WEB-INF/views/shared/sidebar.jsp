<h1 class="my-4">Shop Name</h1>
<div class="list-group">
	<c:forEach item="${categories}" var="category">
		<a href="#" class="list-group-item"> ${category.name}</a>
	</c:forEach>
</div>

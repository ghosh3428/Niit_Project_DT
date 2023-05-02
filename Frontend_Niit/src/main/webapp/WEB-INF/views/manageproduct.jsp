<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content">
	<div class="container">
		<div class="row">
			<c:if test="${not empty message}">
				<div class="col-xs-12 offset-md-1 col-md-10">
					<div class="alert alert-success alert-dismissible " role="alert">
						${message}
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</c:if>

			<div class="offset-md-1 col-md-10">
				<div class="card">

					<div class="card-heading bg-success text-white">
						<h1>Product Management</h1>
					</div>

					<div class="card-body">


						<sf:form method="post" 
								 modelAttribute="product"
								 action="${contextRoot}/manage/add/product"
								 enctype="multipart/form-data">

							<div class="form-group row">
								<label class="col-md-4 col-form-label" for="name"> Enter
									Product Name </label>
								<div class="col-md-8">
									<sf:input type="text" path="name" id="name"
										placeholder="Product Name" class="form-control" />
									<sf:errors path="name" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-form-label col-md-4" for="brand">
									Enter Brand Name </label>
								<div class="col-md-8">
									<sf:input type="text" path="brand" id="brand"
										placeholder="Brand Name" class="form-control" />
									<sf:errors path="brand" cssClass="help-block" element="em" />
								</div>

							</div>
							<div class="form-group row">
								<label class="col-md-4 col-form-label" for="quantity">
									Enter Product Quantity </label>
								<div class="col-md-8">
									<sf:input type="text" path="quantity" id="quantity"
										placeholder="Quantity" class="form-control" />
									<sf:errors path="quantity" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-form-label col-md-4" for="unitPrice">
									Enter Unit Price </label>
								<div class="col-md-8">
									<sf:input type="text" path="unitPrice" id="unitPrice"
										placeholder="Unit Price" class="form-control" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-md-4" for="description">
									Enter Product Description </label>
								<div class="col-md-8">
									<sf:textarea class="form-control" path="description" rows="5"
										id="description" placeholder="Enter product description : " />
									<sf:errors path="description" cssClass="help-block"
										element="em" />
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-form-label col-md-4"> Select Supplier
								</label>
								<div class="col-md-8">
									<sf:select id="supplier" path="supplierId"
										items="${supplierList}" itemLabel="firstName" itemValue="id"
										class="form-control">
									</sf:select>
								</div>

							</div>
							<div class="form-group row">
								<label class="col-form-label col-md-4"> Select Category
								</label>
								<div class="col-md-8">
									<sf:select id="category" path="categoryId"
										items="${categoryList}" itemLabel="name" itemValue="id"
										class="form-control">
									</sf:select>
									<br />
									<div class="text-right">
										<c:if test="${product.id == 0 }">
											<button type="button" data-toggle="modal"
												data-target="#myCategoryModal"
												class="btn btn-warning btn-sm">ADD CATEGORY</button>
										</c:if>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />

								<div class="offset-md-4 col-md-8">
									<input type="submit" name="submit" id="submit" value="submit"
										class="btn btn-primary btn-md" />
								</div>

							</div>

						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
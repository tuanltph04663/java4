<!-- import _imports.jsp -->
<%@include file="common/_imports.jsp"%>

<!DOCTYPE html>
<html>

<!-- import _head.jsp -->
<%@include file="common/_head.jsp"%>

<body>
	<!-- import _header.jsp -->
	<%@include file="common/_header.jsp"%>

	<!--slider-->
	<section id="slider">
		<div class="container">
			<div class="row">
				<div class="col-sm-12"></div>
			</div>
		</div>
	</section>
	<!--/slider-->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<!--category-products-->
						<div class="panel-group category-products" id="accordian">
							<c:forEach var="category" items="${categories}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a href="/Assignment/index?categoryId=${category.idCategory}"> <span class="badge pull-right"> </span>
												${category.nameCategory}
											</a>
										</h4>
									</div>
								</div>
							</c:forEach>
						</div>
						<!--/category-products-->

						<div class="price-range">
							<!--price-range-->
							<h2>Price Range</h2>
							<div class="well text-center">
								<input type="text" class="span2" value="" data-slider-min="0"
									data-slider-max="600" data-slider-step="5"
									data-slider-value="[250,450]" id="sl2"><br /> <b
									class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div>
						<!--/price-range-->

						<div class="shipping text-center">
							<!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div>
						<!--/shipping-->

					</div>
				</div>

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Features Items</h2>

						<c:forEach var="sp" items="${products}">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img src="images/home/${sp.image}" alt="" />
											<h2>$ ${sp.price}</h2>
											<p>${sp.nameProduct}</p>
											<a
												href="/Assignment/addtocart?productId=${sp.idProducts}"
												class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<p>Store: ${sp.storge}</p>
												<p>Weight: ${sp.weight}</p>
												<p>Description: ${sp.descrtiption}</p>
												<p>OS: ${sp.os}</p>
												<p>CPU: ${sp.cpu}</p>
												<p>RAM: ${sp.ram}</p>
												<p>Color: ${sp.color}</p>
												<h2>$ ${sp.price}</h2>
												<p>${sp.nameProduct}</p>
												<a
													href="/Assignment/addtocart?productId=${sp.idProducts}"
													class="btn btn-default add-to-cart"><i
													class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
										</div>
									</div>

								</div>
							</div>
						</c:forEach>
					
					</div>
					<!--features_items-->

					<!--/category-tab-->

				</div>
			</div>
		</div>
	</section>

	<!-- import _footer.jsp -->
	<%@include file="common/_footer.jsp"%>

	<!-- import _head.jsp -->
	<%@include file="common/_external_js.jsp"%>

</body>
</html>
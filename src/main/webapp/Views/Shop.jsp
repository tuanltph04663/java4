<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Common.jsp" %>
<jsp:include page="Common.jsp"></jsp:include>
</head>
<!--/head-->

<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<section id="advertisement">
	<div class="container">
		<img src="images/shop/advertisement.jpg" alt="" />
	</div>
	</section>

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">
					<h2>Category</h2>
					<div class="panel-group category-products" id="accordian">
						<!--category-productsr-->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian"
										href="#sportswear"> <span class="badge pull-right"><i
											class="fa fa-plus"></i></span> League of Legends
									</a>
								</h4>
							</div>
							<div id="sportswear" class="panel-collapse collapse">
								<div class="panel-body">
									<ul>
										<li><a href="#">Fnatic</a></li>
										<li><a href="#">Edward Gaming</a></li>
										<li><a href="#">Team Solomid</a></li>
										<li><a href="#">SKT</a></li>
										<li><a href="#">Boba Marines</a></li>
										<li><a href="#">IMMORTALS</a></li>
										<li><a href="#">Snake Esport</a></li>
										<li><a href="#">Samsung Galaxy</a></li>
										<li><a href="#">KT-Roster</a></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian"
										href="#womens"> <span class="badge pull-right"> </span>
										Dota 2
									</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">T-shirts, coats</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">backpack, briefcase</a>

								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">Hat</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="#">Toxic</a>
								</h4>
							</div>
						</div>



					</div>
					<!--/category-productsr-->


					<!--/brands_products-->

					<div class="price-range">
						<!--price-range-->
						<h2>Price Range</h2>
						<div class="well">
							<input type="text" class="span2" value="" data-slider-min="0"
								data-slider-max="600" data-slider-step="5"
								data-slider-value="[250,450]" id="sl2"><br /> <b>$
								0</b> <b class="pull-right">$ 600</b>
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
					<%
						ProductsDAO productsDAO = new ProductsDAO();
						List<Products> list = productsDAO.getAll();
					%>
					<c:forEach var="sp" items="<%=list %>">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/${sp.image}" alt="" />
										<h2>$ ${sp.price}</h2>
										<p>${sp.nameProduct}</p>
										<a href="/Assignment/ControllerGioHang?add=insert&idProducts=${sp.idProducts }"
											class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$ ${sp.price}</h2>
											<p>${sp.nameProduct}</p>
											<a href="/Assignment/ControllerGioHang?add=insert&idProducts=${sp.idProducts }"
												class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add
												to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add
												to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>


					<ul class="pagination">
						<%
							int a, b;
							int limit = list.size() / 6;
							if (limit * 6 < list.size()) {
								limit += 1;
							}
							for (int i = 1; i <= limit; i++) {
								a = (i - 1) * 6;
								b = i * 6;
								if (b > list.size()) {
									b = list.size();
								}
						%>

						<li class="arrow"><a
							href="/Assignment/ControllerPhanTrang?start=<%=a%>&end=<%=b%>"><%=i%></a></li>

						<%
							}
						%>
					</ul>
				</div>
				<!--features_items-->
			</div>
		</div>
	</div>
	</section>


	<jsp:include page="Footer.jsp"></jsp:include>



	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
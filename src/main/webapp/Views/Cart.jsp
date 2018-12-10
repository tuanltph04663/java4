
<%@ page import="java.util.List, vn.edu.poly.tuanltph04663.model.Detail" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="Common.jsp"></jsp:include>
<%@ include file="Common.jsp" %>
</head>
<!--/head-->

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<section id="cart_items">
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li class="active">Shopping Cart</li>
			</ol>
		</div>
		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
					<tr class="cart_menu">
						<td class="image">Item</td>
						<td class="description"></td>
						<td class="price">Price</td>
						<td class="quantity">Quantity</td>
						<td class="total">Total</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<%
						Detail adsfsdf = (Detail) session.getAttribute("Cart");
						List<Detail> list = CartDAO.DanhSach();
						for (Detail gh : list) {		
					%>
					<tr>
						<td class="cart_product"><a href=""><img
								src="images/home/<%=gh.getProducts().getImage() %>" alt=""></a></td>
						<td class="cart_description">
							<h4>
								<a href=""><%=gh.getProducts().getNameProduct() %></a>
							</h4>
				
						</td>
						<td class="cart_price">
							<p><%=gh.getProducts().getPrice() %></p>
						</td>
						<td class="cart_quantity">
							<div class="cart_quantity_button">
								<a class="cart_quantity_up" href="/Assignment/PlusToCartController?add=plus&idProducts=<%=gh.getProducts().getIdProducts()%>&idDetail=<%=gh.getIdDetail()%>"> + </a> <input
									class="cart_quantity_input" type="text" name="quantity"
									value="<%=gh.getQuality() %>" autocomplete="off" size="2"> <a
									class="cart_quantity_down" href="/Assignment/SubToCartController?add=sub&idProducts=<%=gh.getProducts().getIdProducts()%>&idDetail=<%=gh.getIdDetail()%>"> - </a>
							</div>
						</td>
						<td class="cart_total">
							<p class="cart_total_price"><%=gh.getProducts().getPrice()*gh.getQuality() %></p>
						</td>
						<td class="cart_delete"><a class="cart_quantity_delete"
							href=""><i class="fa fa-times"></i></a></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
	</section>
	<!--/#cart_items-->

	<section id="do_action">
	<div class="container">
		<div class="heading">
			<h3>What would you like to do next?</h3>
			<p>Choose if you have a discount code or reward points you want
				to use or would like to estimate your delivery cost.</p>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="chose_area">
					<ul class="user_option">
						<li><input type="checkbox"> <label>Use Coupon
								Code</label></li>
						<li><input type="checkbox"> <label>Use Gift
								Voucher</label></li>
						<li><input type="checkbox"> <label>Estimate
								Shipping & Taxes</label></li>
					</ul>
					<ul class="user_info">
						<li class="single_field"><label>Country:</label> <select>
								<option>United States</option>
								<option>Bangladesh</option>
								<option>UK</option>
								<option>India</option>
								<option>Pakistan</option>
								<option>Ucrane</option>
								<option>Canada</option>
								<option>Dubai</option>
						</select></li>
						<li class="single_field"><label>Region / State:</label> <select>
								<option>Select</option>
								<option>Dhaka</option>
								<option>London</option>
								<option>Dillih</option>
								<option>Lahore</option>
								<option>Alaska</option>
								<option>Canada</option>
								<option>Dubai</option>
						</select></li>
						<li class="single_field zip-field"><label>Zip Code:</label> <input
							type="text"></li>
					</ul>
					<a class="btn btn-default update" href="">Get Quotes</a> <a
						class="btn btn-default check_out" href="">Continue</a>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="total_area">
					<ul>
						<li>Cart Sub Total <span>$59</span></li>
						<li>Eco Tax <span>$2</span></li>
						<li>Shipping Cost <span>Free</span></li>
						<li>Total <span>$61</span></li>
					</ul>
					<a class="btn btn-default update" href="">Update</a> <a
						class="btn btn-default check_out" href="">Check Out</a>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--/#do_action-->

	<jsp:include page="Footer.jsp"></jsp:include>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
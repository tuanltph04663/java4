<%@page import="vn.edu.poly.tuanltph04663.model.Order"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<!-- import _head.jsp -->
<%@include file="common/_head.jsp"%>

<body>
	<!-- import _header.jsp -->
	<%@include file="common/_header.jsp"%>

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
							<td class="image">Image</td>
							<td class="image">Name</td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td>Action</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="o" items="${sessionScope.order.items}">
							<tr>
								<td class="cart_product">
									<img src="images/home/${o.product.image}" alt="">
								</td>
								
								<td class="cart_description">
									<h4>${o.product.nameProduct}</h4>
								</td>
								
								<td class="cart_price">
									<p>${o.product.price}</p>
								</td>
								
								<td class="cart_quantity">
									<p>${o.amount}</p>
								</td>
								
								<td class="cart_total">
									<p class="cart_total_price">${o.getPrice()}</p>
								</td>
								
								<td class="cart_delete">
									<a class="cart_quantity_delete" href="/Assignment/removefromcart?productId=${o.product.idProducts}"><i class="fa fa-times"></i></a>
								</td>
							</tr>
						</c:forEach>
							
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
							<li><input type="checkbox"> <label>Use
									Coupon Code</label></li>
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
							<li class="single_field zip-field"><label>Zip Code:</label>
								<input type="text"></li>
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

	<!-- import _footer.jsp -->
	<%@include file="common/_footer.jsp"%>

	<!-- import _head.jsp -->
	<%@include file="common/_external_js.jsp"%>
</body>
</html>
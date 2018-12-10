package vn.edu.poly.tuanltph04663.model;

public class Test {

	public static void main(String[] args) {
		Products p1 = new Products();
		p1.setIdProducts(1);
		p1.setPrice(Float.parseFloat("20.0"));
		
		Products p2 = new Products();
		p2.setIdProducts(2);
		p2.setPrice(Float.parseFloat("30.0"));
		
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setOrderId(p1.getIdProducts());
		orderItem1.setProduct(p1);
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setOrderId(p2.getIdProducts());
		orderItem2.setProduct(p2);
		
		Order order = new Order();
		order.addToCart(orderItem1);
		order.addToCart(orderItem1);
		order.removeFromCart(1);
		order.removeFromCart(1);
		order.removeFromCart(1);
		order.addToCart(orderItem2);
		
		System.out.println(order.getTotalPrice());
		
	}
}

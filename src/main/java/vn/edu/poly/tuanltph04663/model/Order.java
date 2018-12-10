package vn.edu.poly.tuanltph04663.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {

	private List<OrderItem> items = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(List<OrderItem> items) {
		super();
		this.items = items;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	/**
	 * add to cart
	 * 
	 * @param {OrderItem}
	 */
	public void addToCart(OrderItem item) {
		if (items.isEmpty()) {
			// add first item
			item.setAmount(1);
			items.add(item);
			return;
		}

		Optional<OrderItem> orderItem = items.stream().filter(e -> e.getOrderId() == item.getOrderId()).findFirst();

		if (orderItem.isPresent()) {
			orderItem.get().incrementAmount();
			return;
		}

		// add new item
		item.setAmount(1);
		this.items.add(item);
	}

	/**
	 * remove from cart
	 * 
	 * @param {id}
	 */
	public void removeFromCart(int id) {
		Optional<OrderItem> orderItem = items.stream().filter(e -> e.getOrderId() == id).findFirst();

		if (!orderItem.isPresent()) {
			return;
		}

		if (orderItem.isPresent() && orderItem.get().getAmount() > 1) {
			orderItem.get().decrementAmount();
			return;
		}

		items.remove(orderItem.get());
	}

	/**
	 * get total price
	 * 
	 * @return {total price}
	 */
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (OrderItem orderItem : items) {
			totalPrice += orderItem.getPrice();
		}

		return totalPrice;
	}

}

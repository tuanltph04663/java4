package vn.edu.poly.tuanltph04663.model;

public class OrderItem {

	private int orderId;
	private int amount;
	private Products product;

	public OrderItem() {
		super();
	}

	public OrderItem(int orderId, int amount, Products product) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.product = product;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public void incrementAmount() {
		this.amount += 1;
	}

	public void decrementAmount() {
		this.amount -= 1;
	}

	/**
	 * get price
	 * 
	 * @return {price}
	 */
	public double getPrice() {
		return this.amount * this.getProduct().getPrice();
	}

}

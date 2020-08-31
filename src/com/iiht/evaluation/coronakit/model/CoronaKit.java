package com.iiht.evaluation.coronakit.model;

import java.util.List;

public class CoronaKit {
	
	private int id;
	private String personName;
	private String email;
	private String contactNumber;
	private Double totalAmount;
	private String deliveryAddress;
	private String orderDate;
	private boolean orderFinalized;
	private List<Integer> productId;
	private int quantity;
	
	public CoronaKit() {
		// TODO Auto-generated constructor stub
	}
	
	public CoronaKit(int id, String personName, String email, String contactNumber, Double totalAmount,
			String deliveryAddress, String orderDate, boolean orderFinalized, List<Integer> productId, int quantity) {
		this.id = id;
		this.personName = personName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.totalAmount = totalAmount;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
		this.orderFinalized = orderFinalized;
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isOrderFinalized() {
		return orderFinalized;
	}
	public void setOrderFinalized(boolean orderFinalized) {
		this.orderFinalized = orderFinalized;
	}
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	



}

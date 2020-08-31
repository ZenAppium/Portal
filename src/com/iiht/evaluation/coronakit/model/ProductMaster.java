package com.iiht.evaluation.coronakit.model;

public class ProductMaster {
	
	private boolean isslected;
	private int id;
	private String productName;
	private Double cost;
	private String productDescription;
	
	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMaster(int id, String productName, Double cost, String productDescription) {
		super();
		this.isslected = false;
		this.id = id;
		this.productName = productName;
		this.cost = cost;
		this.productDescription = productDescription;
	}
	
	
	public boolean isIsslected() {
		return isslected;
	}

	public void setIsslected(boolean isslected) {
		this.isslected = isslected;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(double d) {
		this.cost = d;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productName=" + productName + ", cost=" + cost + ", productDescription="
				+ productDescription + "]";
	}

		}

	


package com.barbershop.reports;

public class ReportGetSumDTO {

	private Long client;

	private Double totalSpent;

	private Integer totalServices;

	private Integer totalProducts;

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(Double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public Integer getTotalServices() {
		return totalServices;
	}

	public void setTotalServices(Integer totalServices) {
		this.totalServices = totalServices;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

	
	
}

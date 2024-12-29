package com.barbershop.reports;

import java.time.LocalDateTime;

public class ReportGetSumDTO {

	private Long client;

	private Double totalSpent;

	private Double totalServices;

	private Double totalProducts;

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

	public Double getTotalServices() {
		return totalServices;
	}

	public void setTotalServices(Double totalServices) {
		this.totalServices = totalServices;
	}

	public Double getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Double totalProducts) {
		this.totalProducts = totalProducts;
	}

	
	
}

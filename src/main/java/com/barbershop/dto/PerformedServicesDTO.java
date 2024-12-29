package com.barbershop.dto;

import java.time.LocalDateTime;

public class PerformedServicesDTO {

	private Long id;

	private Long client;

	private Long services;

	private Long products;

	private Double price;

	private LocalDateTime localDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Long getServices() {
		return services;
	}

	public void setServices(Long services) {
		this.services = services;
	}

	public Long getProducts() {
		return products;
	}

	public void setProducts(Long products) {
		this.products = products;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getDateCreate() {
		return localDateTime;
	}

	public void setDateCreate(LocalDateTime setDateCreate) {
		this.localDateTime = setDateCreate;
	}

}

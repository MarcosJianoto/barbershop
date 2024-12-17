package com.barbershop.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "performed_services")
public class PerformedServices {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "performed_services_sequence")
	@SequenceGenerator(name = "performed_services_sequence", sequenceName = "performed_services_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services services;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products products;

	@Column(name = "price")
	private Double price;

	@Column(name = "date_time")
	private LocalDateTime localDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClients() {
		return client;
	}

	public void setClients(Client client) {
		this.client = client;
	}

	public Services getService() {
		return services;
	}

	public void setService(Services service) {
		this.services = service;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

}

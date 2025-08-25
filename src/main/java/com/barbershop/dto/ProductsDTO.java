package com.barbershop.dto;

import com.barbershop.entities.StatusProduct;

public class ProductsDTO {

	private Long id;

	private String name;

	private Double price;

	private Integer quantity;

	private String description;

	private StatusProduct status;

	private Long barcode;

	public ProductsDTO(Long id, String name, Double price, Integer quantity, String description, StatusProduct status, Long barcode) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
		this.barcode = barcode;
	}
	public ProductsDTO(String name, Double price, Integer quantity, String description, StatusProduct status, Long barcode) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
		this.barcode = barcode;
	}
	public ProductsDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusProduct getStatus() {
		return status;
	}

	public void setStatus(StatusProduct status) {
		this.status = status;
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

}

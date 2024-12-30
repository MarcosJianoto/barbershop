package com.barbershop.dto;

public class FidelityConfigDTO {

	private Long id;

	private Boolean fidelityIsActive;

	private Integer quantityServiceForFidelity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getFidelityIsActive() {
		return fidelityIsActive;
	}

	public void setFidelityIsActive(Boolean fidelityIsActive) {
		this.fidelityIsActive = fidelityIsActive;
	}

	public Integer getQuantityServiceForFidelity() {
		return quantityServiceForFidelity;
	}

	public void setQuantityServiceForFidelity(Integer quantityServiceForFidelity) {
		this.quantityServiceForFidelity = quantityServiceForFidelity;
	}

}

package com.barbershop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fidelity_config")
public class FidelityConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fidelity_sequence")
	@SequenceGenerator(name = "fidelity_sequence", sequenceName = "fidelity_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "fidelity_active")
	private Boolean fidelityIsActive;

	@Column(name = "services_required_for_fidelity")
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

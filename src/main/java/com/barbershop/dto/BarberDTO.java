package com.barbershop.dto;

public class BarberDTO {

	private Long id;

	private String name;

	private String phone;

	private Boolean isActive;

	public BarberDTO() {
	}

	public BarberDTO(Long id, String name, String phone, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.isActive = isActive;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}

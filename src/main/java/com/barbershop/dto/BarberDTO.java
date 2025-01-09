package com.barbershop.dto;

import java.util.List;

public class BarberDTO {

	private Long id;

	private String name;

	private String phone;

	private Boolean isActive;

	private List<WorkingHoursAsWeekListDTO> workingHours;

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

	public List<WorkingHoursAsWeekListDTO> getWorkingHoursAsWeekListDTOs() {
		return workingHours;
	}

	public void setWorkingHoursAsWeekListDTOs(List<WorkingHoursAsWeekListDTO> workingHours) {
		this.workingHours = workingHours;
	}

}

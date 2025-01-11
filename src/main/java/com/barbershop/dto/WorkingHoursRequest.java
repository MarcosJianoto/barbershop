package com.barbershop.dto;

public class WorkingHoursRequest {

	private WorkingHoursDTO workingHoursDTO;
	private WorkingHoursDifferentDTO workingHoursDifferentDTO;

	public WorkingHoursDTO getWorkingHoursDTO() {
		return workingHoursDTO;
	}

	public void setWorkingHoursDTO(WorkingHoursDTO workingHoursDTO) {
		this.workingHoursDTO = workingHoursDTO;
	}

	public WorkingHoursDifferentDTO getWorkingHoursDifferentDTO() {
		return workingHoursDifferentDTO;
	}

	public void setWorkingHoursDifferentDTO(WorkingHoursDifferentDTO workingHoursDifferentDTO) {
		this.workingHoursDifferentDTO = workingHoursDifferentDTO;
	}

}

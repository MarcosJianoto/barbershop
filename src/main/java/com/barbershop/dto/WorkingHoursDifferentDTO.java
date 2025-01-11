package com.barbershop.dto;

import java.util.List;

import com.barbershop.entities.DayOfWeekEnum;

public class WorkingHoursDifferentDTO {

	private Long id;

	private Long idBarber;

	private List<DayOfWeekEnum> days;

	private List<String> startTime;

	private List<String> finishTime;

	private Boolean workInDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdBarber() {
		return idBarber;
	}

	public void setIdBarber(Long idBarber) {
		this.idBarber = idBarber;
	}

	public List<DayOfWeekEnum> getDays() {
		return days;
	}

	public void setDays(List<DayOfWeekEnum> days) {
		this.days = days;
	}

	public List<String> getStartTime() {
		return startTime;
	}

	public void setStartTime(List<String> startTime) {
		this.startTime = startTime;
	}

	public List<String> getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(List<String> finishTime) {
		this.finishTime = finishTime;
	}

	public Boolean getWorkInDay() {
		return workInDay;
	}

	public void setWorkInDay(Boolean workInDay) {
		this.workInDay = workInDay;
	}

}

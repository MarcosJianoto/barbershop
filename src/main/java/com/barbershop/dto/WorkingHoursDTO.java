package com.barbershop.dto;

public class WorkingHoursDTO {

	private Long id;

	private Long idBarber;

	private String dayOfWeek;

	private String startTime;

	private String finishTime;

	private Boolean workInDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBarber() {
		return idBarber;
	}

	public void setBarber(Long barber) {
		this.idBarber = barber;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Boolean getWorkInDay() {
		return workInDay;
	}

	public void setWorkInDay(Boolean workInDay) {
		this.workInDay = workInDay;
	}

}

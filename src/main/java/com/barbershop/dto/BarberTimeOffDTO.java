package com.barbershop.dto;

public class BarberTimeOffDTO {

	private Long id;

	private Long barberId;

	private String startTime;

	private String endTime;

	private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBarberId() {
		return barberId;
	}

	public void setBarberId(Long barberId) {
		this.barberId = barberId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}

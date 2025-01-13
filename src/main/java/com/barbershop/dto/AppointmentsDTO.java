package com.barbershop.dto;

import com.barbershop.entities.AppointmentsStatusEnum;

public class AppointmentsDTO {

	private Long id;

	private Long barberId;

	private String clientfone;

	private Long serviceId;

	private String appointmentDate;

	private String appointmentTime;

	private AppointmentsStatusEnum appointmentsStatusEnum;

	private String createdAt;

	private String updatedAt;

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

	public String getClientFone() {
		return clientfone;
	}

	public void setClientId(String clientFone) {
		this.clientfone = clientFone;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentsStatusEnum getAppointmentsStatusEnum() {
		return appointmentsStatusEnum;
	}

	public void setAppointmentsStatusEnum(AppointmentsStatusEnum appointmentsStatusEnum) {
		this.appointmentsStatusEnum = appointmentsStatusEnum;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}

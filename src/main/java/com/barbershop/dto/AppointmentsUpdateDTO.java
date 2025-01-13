package com.barbershop.dto;

import com.barbershop.entities.AppointmentsStatusEnum;

public class AppointmentsUpdateDTO {

	private Long id;

	private Long barberId;

	private String clientfone;

	private Long serviceId;

	private AppointmentsStatusEnum appointmentsStatusEnum;

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

	public AppointmentsStatusEnum getAppointmentsStatusEnum() {
		return appointmentsStatusEnum;
	}

	public void setAppointmentsStatusEnum(AppointmentsStatusEnum appointmentsStatusEnum) {
		this.appointmentsStatusEnum = appointmentsStatusEnum;
	}

}

package com.barbershop.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointments {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointments_sequence")
	@SequenceGenerator(name = "appointments_sequence", sequenceName = "appointments_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barberId;

	@ManyToOne
	@JoinColumn(name = "client_fone")
	private Client clientFone;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services serviceId;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "time")
	private LocalTime appointmentTime;

	@Column(name = "status")
	private AppointmentsStatusEnum appointmentsStatusEnum;

	@Column(name = "time")
	private LocalDateTime createdAt;

	@Column(name = "time")
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Barber getBarberId() {
		return barberId;
	}

	public void setBarberId(Barber barberId) {
		this.barberId = barberId;
	}

	public Client getClientId() {
		return clientFone;
	}

	public void setClientId(Client clientId) {
		this.clientFone = clientId;
	}

	public Services getServiceId() {
		return serviceId;
	}

	public void setServiceId(Services serviceId) {
		this.serviceId = serviceId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentsStatusEnum getAppointmentsStatusEnum() {
		return appointmentsStatusEnum;
	}

	public void setAppointmentsStatusEnum(AppointmentsStatusEnum appointmentsStatusEnum) {
		this.appointmentsStatusEnum = appointmentsStatusEnum;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}

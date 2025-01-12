package com.barbershop.entities;

import java.time.LocalDate;
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
	@JoinColumn(name = "client_id")
	private Client clientId;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services serviceId;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "time")
	private LocalTime appointmentTime;

}

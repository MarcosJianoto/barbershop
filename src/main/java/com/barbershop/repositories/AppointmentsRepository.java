package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

}

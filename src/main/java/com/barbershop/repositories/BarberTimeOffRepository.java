package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.BarberTimeOff;

public interface BarberTimeOffRepository extends JpaRepository<BarberTimeOff, Long> {

}

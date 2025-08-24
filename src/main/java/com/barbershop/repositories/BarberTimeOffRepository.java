package com.barbershop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.BarberTimeOff;

public interface BarberTimeOffRepository extends JpaRepository<BarberTimeOff, Long> {

	List<BarberTimeOff> findByBarber_Id(Long barberId);

}

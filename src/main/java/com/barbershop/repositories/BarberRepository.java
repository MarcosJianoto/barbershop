package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Barber;

public interface BarberRepository extends JpaRepository<Barber, Long> {

}

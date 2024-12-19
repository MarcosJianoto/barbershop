package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {

}

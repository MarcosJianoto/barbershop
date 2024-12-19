package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.PerformedServices;

public interface PerformedServicesRepository extends JpaRepository<Long, PerformedServices> {

}

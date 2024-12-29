package com.barbershop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.PerformedServices;

public interface PerformedServicesRepository extends JpaRepository<PerformedServices, Long> {

	List<PerformedServices> findByClient_Id(Long idClient);

}

package com.barbershop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Fidelity;

public interface FidelityRepository extends JpaRepository<Fidelity, Long> {

	Optional<Fidelity> findByClient_Id(Long idClient);

}

package com.barbershop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByFone(String fone);
}

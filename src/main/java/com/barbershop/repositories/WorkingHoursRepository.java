package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.WorkingHours;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

}

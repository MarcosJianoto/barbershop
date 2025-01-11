package com.barbershop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.WorkingHours;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

	List<WorkingHours> findByBarber_Id(Long idBarber);

}

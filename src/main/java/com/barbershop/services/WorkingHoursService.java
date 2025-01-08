package com.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.BarberDTO;
import com.barbershop.dto.WorkingHoursDTO;
import com.barbershop.entities.Barber;
import com.barbershop.entities.WorkingHours;
import com.barbershop.repositories.BarberRepository;
import com.barbershop.repositories.WorkingHoursRepository;

@Service
public class WorkingHoursService {

	@Autowired
	private WorkingHoursRepository workingHoursRepository;

	@Autowired
	private BarberRepository barberRepository;

	public void saveWorkingHours(WorkingHoursDTO workingHoursDTO) {

		Optional<Barber> barber = barberRepository.findById(workingHoursDTO.getBarber());
		WorkingHours workingHours = new WorkingHours();

		if (barber.isPresent()) {
			workingHours.setBarber(barber.get());
			workingHours.setDayOfWeek(workingHoursDTO.getDayOfWeek());
			workingHours.setStartTime(workingHours.getStartTime());
			workingHours.setFinishTime(workingHours.getFinishTime());
			workingHoursRepository.save(workingHours);
		}

	}

	public WorkingHoursDTO getWorkingHours(Long id) {

		Optional<WorkingHours> workingHours = workingHoursRepository.findById(id);
		WorkingHoursDTO workingHoursDTO = new WorkingHoursDTO();

		if (workingHours.isPresent()) {
			WorkingHours work = workingHours.get();

			workingHoursDTO.setId(id);
			workingHoursDTO.setBarber(work.getBarber().getId());
			workingHoursDTO.setDayOfWeek(work.getDayOfWeek());
			workingHoursDTO.setStartTime(work.getStartTime().toString());
			workingHoursDTO.setFinishTime(work.getFinishTime().toString());

		}
		return workingHoursDTO;

	}

	public void editWorkingHours(Long id, WorkingHoursDTO workingHoursDTO) {

		Optional<WorkingHours> workingHoursFindById = workingHoursRepository.findById(id);
		Optional<Barber> barber = barberRepository.findById(workingHoursDTO.getBarber());

		if (workingHoursFindById.isPresent() && barber.isPresent()) {
			WorkingHours work = workingHoursFindById.get();

			work.setBarber(work.getBarber());
			work.setDayOfWeek(work.getDayOfWeek());
			work.setStartTime(work.getStartTime());
			work.setFinishTime(work.getFinishTime());

			workingHoursRepository.save(work);
		}
	}

	public void deleteWorkingHours(Long id) {
		workingHoursRepository.deleteById(id);
		;
	}

}

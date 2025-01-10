package com.barbershop.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.WorkingHoursDTO;
import com.barbershop.entities.Barber;
import com.barbershop.entities.DayOfWeekEnum;
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

	public void saveWorkingHoursWeek(WorkingHoursDTO workingHoursDTO, Boolean checkbox) {

		DayOfWeekEnum[] dayOfWeekEnum = DayOfWeekEnum.values();

		Optional<Barber> barberFindById = barberRepository.findById(workingHoursDTO.getBarber());

		if (barberFindById.isPresent()) {

			for (DayOfWeekEnum day : dayOfWeekEnum) {

				WorkingHours workingHours = new WorkingHours();
				workingHours.setBarber(barberFindById.get());
				workingHours.setDayOfWeek(day.name());

				DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("H:mm:ss");
				LocalTime startTime = LocalTime.parse(workingHoursDTO.getStartTime(), dts1);
				LocalTime finishTime = LocalTime.parse(workingHoursDTO.getFinishTime(), dts1);

				workingHours.setStartTime(startTime);
				workingHours.setFinishTime(finishTime);
				workingHours.setWorkInDay(workingHoursDTO.getWorkInDay());
				workingHoursRepository.save(workingHours);
			}

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
			work.setBarber(barber.get());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("H:mm:ss");
			LocalTime startTime = LocalTime.parse(workingHoursDTO.getStartTime(), dts1);
			LocalTime finishTime = LocalTime.parse(workingHoursDTO.getFinishTime(), dts1);

			work.setStartTime(startTime);
			work.setFinishTime(finishTime);

			workingHoursRepository.save(work);
		}
	}

	public void deleteWorkingHours(Long id) {
		workingHoursRepository.deleteById(id);
	}

}

package com.barbershop.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.WorkingHoursDTO;
import com.barbershop.dto.WorkingHoursDifferentDTO;
import com.barbershop.entities.Barber;
import com.barbershop.entities.DayOfWeekEnum;
import com.barbershop.entities.WorkingHours;
import com.barbershop.repositories.BarberRepository;
import com.barbershop.repositories.WorkingHoursRepository;

import jakarta.persistence.EntityNotFoundException;

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

	public void saveWorkingHoursWeekVerifyDifferentOrEquals(WorkingHoursDTO workingHoursDTO,
			WorkingHoursDifferentDTO workingHoursDifferentDTO, Boolean checkbox) throws IllegalAccessException {

		Barber barberFindById = barberRepository.findById(workingHoursDTO.getBarber())
				.orElseThrow(() -> new IllegalAccessException(" BarberID not found"));

		if (barberFindById.getIsActive()) {

			if (checkbox) {
				saveWorkingHoursWeek(workingHoursDTO, barberFindById);
			} else {
				saveWorkingDifferentHoursWeek(workingHoursDifferentDTO, barberFindById);
			}
		}

	}

	public void saveWorkingHoursWeek(WorkingHoursDTO workingHoursDTO, Barber barber) {

		DayOfWeekEnum[] dayOfWeekEnum = DayOfWeekEnum.values();

		if (barber.getIsActive()) {

			for (DayOfWeekEnum day : dayOfWeekEnum) {

				WorkingHours workingHours = new WorkingHours();
				workingHours.setBarber(barber);
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

	public void saveWorkingDifferentHoursWeek(WorkingHoursDifferentDTO workingHoursDifferentDTO, Barber barber) {

		if (barber.getIsActive()) {

			List<DayOfWeekEnum> days = workingHoursDifferentDTO.getDays();
			List<String> startTimes = workingHoursDifferentDTO.getStartTime();
			List<String> finishTimes = workingHoursDifferentDTO.getFinishTime();

			if (days.size() == startTimes.size() && days.size() == finishTimes.size()) {
				for (int i = 0; i < days.size(); i++) {
					WorkingHours workingHours = new WorkingHours();

					workingHours.setBarber(barber);
					workingHours.setDayOfWeek(days.get(i).name());

					DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("H:mm:ss");
					LocalTime startTime = LocalTime.parse(startTimes.get(i), dts1);
					LocalTime finishTime = LocalTime.parse(finishTimes.get(i), dts1);

					workingHours.setStartTime(startTime);
					workingHours.setFinishTime(finishTime);
					workingHours.setWorkInDay(workingHoursDifferentDTO.getWorkInDay());
					workingHoursRepository.save(workingHours);
				}
			} else {
				throw new IllegalArgumentException(
						"O número de dias, horários de início e horários de término deve ser igual.");
			}

		} else {
			throw new EntityNotFoundException("Barbeiro não encontrado.");
		}

	}

	public void updateWorkingHours(Long id, WorkingHoursDTO workingHoursDTO) {

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

	public List<WorkingHoursDTO> getWorkingHoursList(Long idBarber) {

		List<WorkingHours> workingHours = workingHoursRepository.findByBarber_Id(idBarber);

		List<WorkingHoursDTO> workingHoursDTOs = new ArrayList<>();

		if (!workingHours.isEmpty()) {

			for (WorkingHours workingHour : workingHours) {
				WorkingHoursDTO work = new WorkingHoursDTO();

				work.setId(workingHour.getId());
				work.setBarber(workingHour.getBarber().getId());
				work.setDayOfWeek(workingHour.getDayOfWeek());
				work.setStartTime(workingHour.getStartTime().toString());
				work.setFinishTime(workingHour.getFinishTime().toString());
				workingHoursDTOs.add(work);

			}

		}
		return workingHoursDTOs;
	}

	public void deleteWorkingHours(Long id) {
		workingHoursRepository.deleteById(id);
	}

}

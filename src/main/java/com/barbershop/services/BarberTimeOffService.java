package com.barbershop.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.BarberTimeOffDTO;
import com.barbershop.entities.Barber;
import com.barbershop.entities.BarberTimeOff;
import com.barbershop.repositories.BarberRepository;
import com.barbershop.repositories.BarberTimeOffRepository;

@Service
public class BarberTimeOffService {

	@Autowired
	private BarberTimeOffRepository barberTimeOffRepository;

	@Autowired
	private BarberRepository barberRepository;

	public void saveBarberTimeOff(BarberTimeOffDTO barberTimeOffDTO) {

		Optional<Barber> barberFindId = barberRepository.findById(barberTimeOffDTO.getBarberId());

		if (barberFindId.isPresent()) {

			BarberTimeOff barberTimeOff = new BarberTimeOff();
			barberTimeOff.setBarberId(barberFindId.get());
			barberTimeOff.setReason(barberTimeOffDTO.getReason());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime startTime = LocalDateTime.parse(barberTimeOffDTO.getStartTime(), dts1);
			LocalDateTime endTime = LocalDateTime.parse(barberTimeOffDTO.getEndTime(), dts1);

			barberTimeOff.setStartTime(startTime);
			barberTimeOff.setEndTime(endTime);

			barberTimeOffRepository.save(barberTimeOff);
		}

	}

	public void saveBarberTimeOffAllDay(BarberTimeOffDTO barberTimeOffDTO) {

		Optional<Barber> barberFindId = barberRepository.findById(barberTimeOffDTO.getBarberId());

		if (barberFindId.isPresent()) {

			BarberTimeOff barberTimeOff = new BarberTimeOff();
			barberTimeOff.setBarberId(barberFindId.get());
			barberTimeOff.setReason(barberTimeOffDTO.getReason());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
			LocalDate startDate = LocalDate.parse(barberTimeOffDTO.getStartTime(), dts1);
			LocalDate endDate = LocalDate.parse(barberTimeOffDTO.getEndTime(), dts1);

			LocalDateTime startTime = startDate.atTime(0, 0);
			LocalDateTime endTime = endDate.atTime(23, 59);

			barberTimeOff.setStartTime(startTime);
			barberTimeOff.setEndTime(endTime);

			barberTimeOffRepository.save(barberTimeOff);
		}

	}

	public void updateBarberTimeOff(Long id, BarberTimeOffDTO barberTimeOffDTO) {

		Optional<BarberTimeOff> barberTimeOff = barberTimeOffRepository.findById(id);
		Optional<Barber> barberFindId = barberRepository.findById(barberTimeOffDTO.getBarberId());

		if (barberTimeOff.isPresent() && barberFindId.isPresent()) {
			BarberTimeOff barb = barberTimeOff.get();
			barb.setReason(barberTimeOffDTO.getReason());
			barb.setBarberId(barberFindId.get());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime startTime = LocalDateTime.parse(barberTimeOffDTO.getStartTime(), dts1);
			LocalDateTime endTime = LocalDateTime.parse(barberTimeOffDTO.getEndTime(), dts1);

			barb.setStartTime(startTime);
			barb.setEndTime(endTime);

			barberTimeOffRepository.save(barb);

		}

	}

	public BarberTimeOffDTO getBarberTimeOffId(Long id) {

		Optional<BarberTimeOff> barbertimeOff = barberTimeOffRepository.findById(id);
		BarberTimeOffDTO barberTimeOffDTO = new BarberTimeOffDTO();

		if (barbertimeOff.isPresent()) {
			BarberTimeOff barb = barbertimeOff.get();

			barberTimeOffDTO.setId(id);
			barberTimeOffDTO.setBarberId(barb.getBarberId().getId());
			barberTimeOffDTO.setStartTime(barb.getStartTime().toString());
			barberTimeOffDTO.setStartTime(barb.getEndTime().toString());
			barberTimeOffDTO.setReason(barb.getReason());
		}

		return barberTimeOffDTO;

	}

	public List<BarberTimeOffDTO> getListBarberTimeOff() {

		List<BarberTimeOff> barberTimeOff = barberTimeOffRepository.findAll();
		List<BarberTimeOffDTO> barberTimeOffDTOs = new ArrayList<>();
		if (!barberTimeOff.isEmpty()) {

			for (BarberTimeOff barb : barberTimeOff) {
				BarberTimeOffDTO barberTimeOffDTO = new BarberTimeOffDTO();
				barberTimeOffDTO.setId(barb.getId());
				barberTimeOffDTO.setBarberId(barb.getBarberId().getId());
				barberTimeOffDTO.setStartTime(barb.getStartTime().toString());
				barberTimeOffDTO.setStartTime(barb.getEndTime().toString());
				barberTimeOffDTO.setReason(barb.getReason());

				barberTimeOffDTOs.add(barberTimeOffDTO);

			}

		}
		return barberTimeOffDTOs;
	}

	public void deleteBarberTimeOff(Long id) {
		barberRepository.deleteById(id);
	}

}

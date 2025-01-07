package com.barbershop.services;

import java.time.LocalDate;
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

		BarberTimeOff barberTimeOff = new BarberTimeOff();
		barberTimeOff.setBarberId(barberTimeOffDTO.getBarberId());
		barberTimeOff.setReason(barberTimeOffDTO.getReason());

		DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTimeOff = LocalDate.parse(barberTimeOffDTO.getDate(), dts1);

		barberTimeOff.setDate(dateTimeOff);

		barberTimeOffRepository.save(barberTimeOff);
	}

	public void updateBarberTimeOff(Long id, BarberTimeOffDTO barberTimeOffDTO) {

		Optional<BarberTimeOff> barberTimeOff = barberTimeOffRepository.findById(id);
		Optional<Barber> barberFindId = barberRepository.findById(barberTimeOffDTO.getBarberId());

		if (barberTimeOff.isPresent() && barberFindId.isPresent()) {
			BarberTimeOff barb = barberTimeOff.get();
			barb.setReason(barberTimeOffDTO.getReason());
			barb.setBarberId(barberTimeOffDTO.getBarberId());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dateTimeOff = LocalDate.parse(barberTimeOffDTO.getDate(), dts1);

			barb.setDate(dateTimeOff);
			barberTimeOffRepository.save(barb);

		}

	}

	public BarberTimeOffDTO getBarberTimeOffId(Long id) {

		Optional<BarberTimeOff> barbertimeOff = barberTimeOffRepository.findById(id);
		BarberTimeOffDTO barberTimeOffDTO = new BarberTimeOffDTO();

		if (barbertimeOff.isPresent()) {
			BarberTimeOff barb = barbertimeOff.get();

			barberTimeOffDTO.setId(id);
			barberTimeOffDTO.setBarberId(barb.getBarberId());
			barberTimeOffDTO.setDate(barb.getDate().toString());
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
				barberTimeOffDTO.setBarberId(barb.getBarberId());
				barberTimeOffDTO.setDate(barb.getDate().toString());
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

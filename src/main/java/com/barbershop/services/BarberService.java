package com.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.BarberDTO;
import com.barbershop.entities.Barber;
import com.barbershop.repositories.BarberRepository;

@Service
public class BarberService {

	@Autowired
	private BarberRepository barberRepository;

	public void saveBarber(BarberDTO barberDTO) {

		Barber barber = new Barber();
		barber.setName(barberDTO.getName());
		barber.setPhone(barberDTO.getPhone());
		barber.setIsActive(true);
		barberRepository.save(barber);

	}

	public BarberDTO getBarber(Long id) {

		Optional<Barber> barber = barberRepository.findById(id);
		BarberDTO barberDTO = new BarberDTO();

		if (barber.isPresent()) {
			Barber barb = barber.get();

			barberDTO.setId(id);
			barberDTO.setName(barb.getName());
			barberDTO.setPhone(barb.getPhone());
			barberDTO.setIsActive(barb.getIsActive());

		}
		return barberDTO;

	}

	public void editBarber(Long id, BarberDTO barberDTO) {

		Optional<Barber> barber = barberRepository.findById(id);

		if (barber.isPresent()) {
			Barber barb = barber.get();

			barb.setName(barberDTO.getName());
			barb.setPhone(barberDTO.getPhone());
			barb.setIsActive(barberDTO.getIsActive());

			barberRepository.save(barb);
		}
	}

	public void editDisponibilityBarber(Long id, BarberDTO barberDTO) {

		Optional<Barber> barber = barberRepository.findById(id);

		if (barber.isPresent()) {
			Barber barb = barber.get();

			barb.setName(barb.getName());
			barb.setPhone(barb.getPhone());
			barb.setIsActive(barberDTO.getIsActive());

			barberRepository.save(barb);
		}
	}

	public void deleteBarber(Long id) {
		barberRepository.deleteById(id);
	}

}

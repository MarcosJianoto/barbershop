package com.barbershop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barbershop.dto.BarberDTO;
import com.barbershop.entities.Barber;
import com.barbershop.repositories.BarberRepository;

@Service
public class BarberService {

    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public Barber barberFindById(Long id) {
        return barberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Barber not found"));
    }

    public void saveBarber(BarberDTO barberDTO) {
        Barber barber = new Barber(barberDTO.getName(), barberDTO.getPhone(), barberDTO.getIsActive());
        barberRepository.save(barber);
    }

    public BarberDTO getBarber(Long id) {
        Barber barber = barberFindById(id);
        return new BarberDTO(barber.getId(), barber.getName(), barber.getPhone(), barber.getIsActive());
    }

    public List<BarberDTO> getBarbers() {

        List<Barber> listBarber = barberRepository.findAll();
        List<BarberDTO> newListBarber = new ArrayList<>();

        if (!listBarber.isEmpty()) {
            for (Barber barber : listBarber) {
                BarberDTO barberDTO = new BarberDTO(barber.getId(), barber.getName(), barber.getPhone(), barber.getIsActive());
                newListBarber.add(barberDTO);
            }
        }
        return newListBarber;
    }

    public void editBarber(Long id, BarberDTO barberDTO) {
        Barber barber = barberFindById(id);
        barber.setName(barberDTO.getName());
        barber.setPhone(barberDTO.getPhone());
        barber.setIsActive(barberDTO.getIsActive());
        barberRepository.save(barber);
    }

    public void editAvailabilityBarber(Long id, BarberDTO barberDTO) {
        Barber barber = barberFindById(id);
        barber.setName(barber.getName());
        barber.setPhone(barber.getPhone());
        barber.setIsActive(barberDTO.getIsActive());
        barberRepository.save(barber);
    }

    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }

}

package com.barbershop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.ServicesDTO;
import com.barbershop.entities.Services;
import com.barbershop.repositories.ServicesRepository;

@Service
public class ServicesService {

	@Autowired
	private ServicesRepository servicesRepository;

	public void saveService(ServicesDTO servicesDTO) {

		Services services = new Services();
		services.setName(servicesDTO.getName());
		services.setPrice(servicesDTO.getPrice());
		servicesRepository.save(services);

	}

	public List<ServicesDTO> getServices() {

		List<Services> findByServices = servicesRepository.findAll();
		List<ServicesDTO> servicesDTOs = new ArrayList<>();

		if (!findByServices.isEmpty()) {

			for (Services services : findByServices) {

				ServicesDTO servicesDTO = new ServicesDTO();
				servicesDTO.setId(services.getId());
				servicesDTO.setName(services.getName());
				servicesDTO.setPrice(services.getPrice());
				servicesDTOs.add(servicesDTO);

			}

		}

		return servicesDTOs;
	}

	public ServicesDTO getServiceId(Long id) {

		Optional<Services> serviceFindById = servicesRepository.findById(id);
		ServicesDTO servicesDTO = new ServicesDTO();

		if (serviceFindById.isPresent()) {

			servicesDTO.setId(serviceFindById.get().getId());
			servicesDTO.setName(serviceFindById.get().getName());
			servicesDTO.setPrice(serviceFindById.get().getPrice());
		}
		return servicesDTO;

	}

	public void updateService(Long id, ServicesDTO servicesDTO) {

		Optional<Services> findByService = servicesRepository.findById(id);
		if (findByService.isPresent()) {

			Services services = findByService.get();
			services.setName(servicesDTO.getName());
			services.setPrice(servicesDTO.getPrice());
			servicesRepository.save(services);

		}
	}

	public void deleteService(Long id) {
		servicesRepository.deleteById(id);
	}

}

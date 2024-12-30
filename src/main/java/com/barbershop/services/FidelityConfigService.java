package com.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.barbershop.dto.FidelityConfigDTO;
import com.barbershop.entities.FidelityConfig;
import com.barbershop.repositories.FidelityConfigRepository;

@Service
public class FidelityConfigService {

	@Autowired
	private FidelityConfigRepository fidelityConfigRepository;

	@PostMapping("/savefidelityconfig")
	public void saveFidelityConfig(FidelityConfigDTO fidelityConfigDTO) {

		if (fidelityConfigRepository.findAll() == null) {
			FidelityConfig fidelityConfig = new FidelityConfig();
			fidelityConfig.setFidelityIsActive(fidelityConfigDTO.getFidelityIsActive());
			fidelityConfig.setQuantityServiceForFidelity(fidelityConfigDTO.getQuantityServiceForFidelity());
			fidelityConfigRepository.save(fidelityConfig);
		} else {

		}
	}

}

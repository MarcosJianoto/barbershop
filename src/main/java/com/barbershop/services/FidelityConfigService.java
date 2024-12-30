package com.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.FidelityConfigDTO;
import com.barbershop.entities.FidelityConfig;
import com.barbershop.repositories.FidelityConfigRepository;

@Service
public class FidelityConfigService {

	@Autowired
	private FidelityConfigRepository fidelityConfigRepository;

	public void saveFidelityConfig(FidelityConfigDTO fidelityConfigDTO) {

		Optional<FidelityConfig> fidelityConfig = fidelityConfigRepository.findById(1L);

		if (fidelityConfig.isEmpty()) {
			FidelityConfig fidelityConf = new FidelityConfig();
			fidelityConf.setFidelityIsActive(fidelityConfigDTO.getFidelityIsActive());
			fidelityConf.setQuantityServiceForFidelity(fidelityConfigDTO.getQuantityServiceForFidelity());
			fidelityConfigRepository.save(fidelityConf);
		} else {
			throw new IllegalArgumentException("FidelityConfig is existed, impossible create, only update");
		}
	}

	public void updateFidelityConfig(FidelityConfigDTO fidelityConfigDTO) {

		Optional<FidelityConfig> fidelityConfig = fidelityConfigRepository.findById(1L);

		if (fidelityConfig.isPresent()) {
			fidelityConfig.get().setFidelityIsActive(fidelityConfigDTO.getFidelityIsActive());
			fidelityConfig.get().setQuantityServiceForFidelity(fidelityConfigDTO.getQuantityServiceForFidelity());
		} else {
			throw new IllegalArgumentException("FidelityConfig dont exist, create a new");
		}
	}

	public Boolean getFidelityIsActive() {
		Optional<FidelityConfig> fidelityConfigDTO = fidelityConfigRepository.findById(1L);
		if (fidelityConfigDTO.isPresent()) {
			return fidelityConfigDTO.get().getFidelityIsActive();
		}
		return false;

	}

}

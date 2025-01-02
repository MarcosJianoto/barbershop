package com.barbershop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.dto.FidelityConfigDTO;
import com.barbershop.entities.Fidelity;
import com.barbershop.entities.FidelityConfig;
import com.barbershop.repositories.FidelityConfigRepository;
import com.barbershop.repositories.FidelityRepository;

@Service
public class FidelityConfigService {

	@Autowired
	private FidelityConfigRepository fidelityConfigRepository;

	@Autowired
	private FidelityRepository fidelityRepository;

	@Transactional
	public void saveFidelityConfig(FidelityConfigDTO fidelityConfigDTO) {

		Optional<FidelityConfig> fidelityConfig = fidelityConfigRepository.findById(1L);

		if (fidelityConfig.isEmpty()) {
			FidelityConfig fidelityConf = new FidelityConfig();
			fidelityConf.setId(1L);
			fidelityConf.setFidelityIsActive(fidelityConfigDTO.getFidelityIsActive());
			fidelityConf.setQuantityServiceForFidelity(fidelityConfigDTO.getQuantityServiceForFidelity());
			if (fidelityConf.getQuantityServiceForFidelity() >= 5) {
				fidelityConfigRepository.save(fidelityConf);
			}

		} else {
			throw new IllegalArgumentException("FidelityConfig is existed, impossible create, only update");
		}
	}

	public void updateFidelityConfig(FidelityConfigDTO fidelityConfigDTO) {

		isTrueForFalse(fidelityConfigDTO);

		Optional<FidelityConfig> fidelityConfig = fidelityConfigRepository.findById(1L);

		if (fidelityConfig.isPresent()) {
			FidelityConfig fidelityConf = fidelityConfig.get();
			fidelityConf.setFidelityIsActive(fidelityConfigDTO.getFidelityIsActive());
			fidelityConf.setQuantityServiceForFidelity(fidelityConfigDTO.getQuantityServiceForFidelity());
			if (fidelityConf.getQuantityServiceForFidelity() >= 5) {
				fidelityConfigRepository.save(fidelityConf);
			}
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

	public void isTrueForFalse(FidelityConfigDTO fidelityConfigDTO) {

		if (fidelityConfigDTO.getFidelityIsActive().equals(false)) {

			List<Fidelity> fidelity = fidelityRepository.findAll();

			for (int i = 0; i < fidelity.size(); i++) {
				fidelity.get(i).setCutsMade(0);
				fidelity.get(i).setFreeCuts(0);
			}

		} else {
			return;
		}
	}

}

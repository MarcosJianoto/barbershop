package com.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.entities.Client;
import com.barbershop.entities.Fidelity;
import com.barbershop.entities.FidelityConfig;
import com.barbershop.repositories.ClientRepository;
import com.barbershop.repositories.FidelityConfigRepository;
import com.barbershop.repositories.FidelityRepository;
import com.barbershop.repositories.PerformedServicesRepository;

@Service
public class FidelityService {

	@Autowired
	private FidelityRepository fidelityRepository;

	@Autowired
	private FidelityConfigRepository fidelityConfigRepository;

	@Autowired
	private ClientRepository clientRepository;

	public void saveFidelity(Client client) {

		Fidelity fidelity = new Fidelity();
		fidelity.setClient(client);
		fidelity.setCutsMade(1);
		fidelity.setFreeCuts(0);
		fidelityRepository.save(fidelity);
	}

	public void processFidelityForClient(Long clientId) {
		FidelityConfig fidelityConfig = fidelityConfigRepository.findById(1L)
				.orElseThrow(() -> new IllegalArgumentException("FidelityConfig not found"));

		if (!fidelityConfig.getFidelityIsActive()) {
			return; // Fidelity program is inactive
		}

		Fidelity fidelity = fidelityRepository.findByClient_Id(clientId).orElseGet(() -> createNewFidelity(clientId));

		updateFidelity(fidelity, fidelityConfig.getQuantityServiceForFidelity());
	}

	private Fidelity createNewFidelity(Long clientId) {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new IllegalArgumentException("Client not found"));

		Fidelity fidelity = new Fidelity();
		fidelity.setClient(client);
		fidelity.setCutsMade(1); // First service is already made
		fidelity.setFreeCuts(0);
		return fidelityRepository.save(fidelity);
	}

	private void updateFidelity(Fidelity fidelity, int servicesForFreeCut) {
		fidelity.setCutsMade(fidelity.getCutsMade() + 1);

		if (fidelity.getCutsMade() >= servicesForFreeCut) {
			fidelity.setCutsMade(0);
			fidelity.setFreeCuts(fidelity.getFreeCuts() + 1);
		}

		fidelityRepository.save(fidelity);
	}

}

package com.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.entities.Client;
import com.barbershop.entities.Fidelity;
import com.barbershop.repositories.FidelityRepository;
import com.barbershop.repositories.PerformedServicesRepository;

@Service
public class FidelityService {

	@Autowired
	private FidelityRepository fidelityRepository;

	public void saveFidelity(Client client) {

		Fidelity fidelity = new Fidelity();
		fidelity.setClient(client);
		fidelity.setCutsMade(1);
		fidelity.setFreeCuts(0);
		fidelityRepository.save(fidelity);
	}

}

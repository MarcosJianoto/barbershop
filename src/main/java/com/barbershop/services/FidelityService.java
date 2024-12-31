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

		if (!fidelityConfigRepository.findById(1L).get().getFidelityIsActive()) {
			return;
		} else {

			FidelityConfig fidelityConfig = fidelityConfigRepository.findById(1L)
					.orElseThrow(() -> new IllegalArgumentException("FidelityConfig not found"));

			Optional<Fidelity> fidelityFindByIdClient = fidelityRepository.findByClient_Id(clientId);

			if (fidelityFindByIdClient.isPresent()) {

				fidelityFindByIdClient.get().setCutsMade(fidelityFindByIdClient.get().getCutsMade() + 1);
				if (fidelityFindByIdClient.get().getCutsMade().equals(fidelityConfig.getQuantityServiceForFidelity())) {
					fidelityFindByIdClient.get().setFreeCuts(fidelityFindByIdClient.get().getFreeCuts() + 1);
					fidelityFindByIdClient.get().setCutsMade(0);
					fidelityRepository.save(fidelityFindByIdClient.get());

				} else {
					fidelityFindByIdClient.get().setCutsMade(fidelityFindByIdClient.get().getCutsMade());
					fidelityFindByIdClient.get().setFreeCuts(fidelityFindByIdClient.get().getFreeCuts());
					fidelityRepository.save(fidelityFindByIdClient.get());

				}

			} else {
				Fidelity fidelity = new Fidelity();
				Client client = clientRepository.findById(clientId)
						.orElseThrow(() -> new IllegalArgumentException("Client not found"));
				fidelity.setClient(client);
				fidelity.setCutsMade(1);
				fidelity.setFreeCuts(0);
				fidelityRepository.save(fidelity);
			}
		}

	}

}

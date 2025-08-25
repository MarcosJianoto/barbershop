package com.barbershop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.entities.Client;
import com.barbershop.entities.Fidelity;
import com.barbershop.entities.FidelityConfig;
import com.barbershop.repositories.ClientRepository;
import com.barbershop.repositories.FidelityConfigRepository;
import com.barbershop.repositories.FidelityRepository;

@Service
public class FidelityService {

    @Autowired
    private FidelityRepository fidelityRepository;

    @Autowired
    private FidelityConfigRepository fidelityConfigRepository;

    @Autowired
    private ClientRepository clientRepository;

    public FidelityConfig fidelityConfigFindById(Long id) {
        return fidelityConfigRepository.findById(id).orElse(null);
    }

    public Client clientFindById(Long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }

    public Fidelity newFidelity(Client client){
        return new Fidelity(client, 0, 0);
    }

    private Fidelity createNewFidelity(Long clientId) {

        Client client = clientFindById(clientId);
        Fidelity fidelity = newFidelity(client);

        return fidelityRepository.save(fidelity);
    }

    public void processFidelityForClient(Long clientId) {

        FidelityConfig fidelityConfig = fidelityConfigFindById(1L);
        Fidelity fidelity = fidelityRepository.findByClient_Id(clientId).orElseGet(() -> createNewFidelity(clientId));

        updateFidelity(fidelity, fidelityConfig.getQuantityServiceForFidelity());
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

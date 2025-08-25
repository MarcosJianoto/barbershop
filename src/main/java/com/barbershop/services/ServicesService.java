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

    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public void saveService(ServicesDTO servicesDTO) {
        Services service = new Services();
        service.setName(servicesDTO.getName());
        service.setPrice(servicesDTO.getPrice());
        servicesRepository.save(service);
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

    public Services findServiceById(Long id) {
        return servicesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Service not found"));
    }

    public ServicesDTO getServiceId(Long id) {

        Services serviceById = findServiceById(id);

        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setId(serviceById.getId());
        servicesDTO.setName(serviceById.getName());
        servicesDTO.setPrice(serviceById.getPrice());
        return servicesDTO;

    }

    public void updateService(Long id, ServicesDTO servicesDTO) {

        Services serviceById = findServiceById(id);
        serviceById.setName(servicesDTO.getName());
        serviceById.setPrice(servicesDTO.getPrice());
        servicesRepository.save(serviceById);
    }

    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

}

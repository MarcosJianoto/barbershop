package com.barbershop.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.PerformedServicesDTO;
import com.barbershop.entities.Client;
import com.barbershop.entities.PerformedServices;
import com.barbershop.entities.Products;
import com.barbershop.entities.Services;
import com.barbershop.repositories.ClientRepository;
import com.barbershop.repositories.PerformedServicesRepository;
import com.barbershop.repositories.ProductsRepository;
import com.barbershop.repositories.ServicesRepository;

@Service
public class PerformedServicesService {

	@Autowired
	private PerformedServicesRepository performedServicesRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ServicesRepository servicesRepository;

	@Autowired
	private FidelityService fidelityService;

	public void savePerformedServices(PerformedServicesDTO performedServicesDTO) {

		Optional<Client> client = clientRepository.findById(performedServicesDTO.getClient());

		if (client.isPresent()) {

			if (performedServicesDTO.getProducts() != null || performedServicesDTO.getServices() != null) {
				PerformedServices performedServices = new PerformedServices();

				if (performedServicesDTO.getProducts() != null) {
					Optional<Products> products = productsRepository.findById(performedServicesDTO.getProducts());
					if (products.isPresent()) {
						performedServices.setProducts(products.get());
					}
				}

				if (performedServicesDTO.getServices() != null) {
					Optional<Services> services = servicesRepository.findById(performedServicesDTO.getServices());

					services.ifPresent(service -> {

						performedServices.setService(service);
						client.ifPresent(c -> fidelityService.processFidelityForClient(c.getId()));
					});

				}

				performedServices.setClients(client.get());
				performedServices.setPrice(performedServicesDTO.getPrice());

				performedServices.setLocalDateTime(LocalDateTime.now());
				performedServicesRepository.save(performedServices);

			} else {
				throw new IllegalArgumentException(" Product not found and Service not found");
			}

		} else {
			throw new IllegalArgumentException("Client not found");
		}
	}

	public void updatePerformedServices(Long id, PerformedServicesDTO performedServicesDTO) {

		Optional<PerformedServices> performedServicesFindById = performedServicesRepository.findById(id);

		if (performedServicesFindById.isPresent()) {

			Optional<Client> client = clientRepository.findById(performedServicesDTO.getClient());

			if (client.isPresent()) {

				performedServicesFindById.get().setProducts(null);
				performedServicesFindById.get().setService(null);

				if (performedServicesDTO.getProducts() != null || performedServicesDTO.getServices() != null) {

					if (performedServicesDTO.getProducts() != null) {
						Optional<Products> products = productsRepository.findById(performedServicesDTO.getProducts());
						if (products.isPresent()) {
							performedServicesFindById.get().setProducts(products.get());
						}
					}

					if (performedServicesDTO.getServices() != null) {
						Optional<Services> services = servicesRepository.findById(performedServicesDTO.getServices());
						if (services.isPresent()) {
							performedServicesFindById.get().setService(services.get());
						}

					}

				}

				performedServicesFindById.get().setClients(client.get());
				performedServicesFindById.get().setPrice(performedServicesDTO.getPrice());

				performedServicesFindById.get().setLocalDateTime(LocalDateTime.now());
				performedServicesRepository.save(performedServicesFindById.get());
			} else {
				throw new IllegalArgumentException(" Product not found and Service not found");
			}

		} else {
			throw new IllegalArgumentException(" Client id not found");
		}
	}

	public void deletePerformedServices(Long id) {
		performedServicesRepository.deleteById(id);
	}
}

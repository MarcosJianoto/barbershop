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

	public void savePerformedServices(PerformedServicesDTO performedServicesDTO) {

		Optional<Client> client = clientRepository.findById(performedServicesDTO.getClient());
		Optional<Products> products = productsRepository.findById(performedServicesDTO.getProducts());
		Optional<Services> services = servicesRepository.findById(performedServicesDTO.getServices());

		PerformedServices performedServices = new PerformedServices();

		if (client.isPresent() && products.isPresent() || client.isPresent() && services.isPresent()
				|| client.isPresent() && products.isPresent() && services.isPresent()) {

			performedServices.setClients(client.get());
			performedServices.setPrice(performedServicesDTO.getPrice());

			if (products.isPresent()) {
				performedServices.setProducts(products.get());
			}

			if (services.isPresent()) {
				performedServices.setService(services.get());
			}

			performedServices.setLocalDateTime(LocalDateTime.now());
			performedServicesRepository.save(performedServices);
		}

	}

	public void updatePerformedServices(Long id, PerformedServicesDTO performedServicesDTO) {

		Optional<PerformedServices> performedServicesFindById = performedServicesRepository.findById(id);

		if (performedServicesFindById.isPresent()) {

			Optional<Client> client = clientRepository.findById(performedServicesDTO.getClient());
			Optional<Products> products = productsRepository.findById(performedServicesDTO.getProducts());
			Optional<Services> services = servicesRepository.findById(performedServicesDTO.getServices());

			if (client.isPresent() && products.isPresent() || client.isPresent() && services.isPresent()
					|| client.isPresent() && products.isPresent() && services.isPresent()) {

				PerformedServices performedServices = performedServicesFindById.get();

				performedServices.setClients(client.get());
				performedServices.setPrice(performedServicesDTO.getPrice());

				if (products.isPresent()) {
					performedServices.setProducts(products.get());
				}

				if (services.isPresent()) {
					performedServices.setService(services.get());
				}

				performedServices.setLocalDateTime(LocalDateTime.now());
				performedServicesRepository.save(performedServices);
			}
		}
	}

	public void deletePerformedServices(Long id) {
		performedServicesRepository.deleteById(id);
	}

}

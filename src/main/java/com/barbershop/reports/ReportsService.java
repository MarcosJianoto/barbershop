package com.barbershop.reports;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.PerformedServicesDTO;
import com.barbershop.entities.Client;
import com.barbershop.entities.PerformedServices;
import com.barbershop.repositories.ClientRepository;
import com.barbershop.repositories.PerformedServicesRepository;
import com.barbershop.repositories.ProductsRepository;
import com.barbershop.repositories.ServicesRepository;

@Service
public class ReportsService {

	@Autowired
	private PerformedServicesRepository performedServicesRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ServicesRepository servicesRepository;

	// report intern, total value spent for client
	public List<PerformedServicesDTO> getServicesAndProductsForIdClient(Long clientId) {

		List<PerformedServices> performedServicesByIdClient = performedServicesRepository.findByClient_Id(clientId);
		List<PerformedServicesDTO> performedServicesDTO = new ArrayList<>();

		for (PerformedServices performedServices : performedServicesByIdClient) {

			PerformedServicesDTO performed = new PerformedServicesDTO();
			performed.setId(performedServices.getId());
			performed.setClient(performedServices.getClients().getId());
			performed.setDateCreate(performedServices.getLocalDateTime());
			performed.setPrice(performedServices.getPrice());

			if (performedServices.getProducts() != null) {
				performed.setProducts(performedServices.getProducts().getId());
			}

			if (performedServices.getService() != null) {
				performed.setServices(performedServices.getService().getId());
			}

			performedServicesDTO.add(performed);

		}
		return performedServicesDTO;

	}

	public ReportGetSumDTO getSumSpentIdClient(Long clientId) {

		List<PerformedServices> performedServicesByIdClient = performedServicesRepository.findByClient_Id(clientId);
		ReportGetSumDTO reportGetSumDTO = new ReportGetSumDTO();

		Double priceTotalSpent = 0.0;
		Integer totalProducts = 0;
		Integer totalServices = 0;

		for (PerformedServices performedServices : performedServicesByIdClient) {

			reportGetSumDTO.setClient(clientId);

			priceTotalSpent += performedServices.getPrice();

			totalProducts = (performedServices.getProducts() != null ? totalProducts++ : totalProducts);
			totalServices = (performedServices.getService() != null ? totalServices++ : totalServices);

			reportGetSumDTO.setTotalProducts(totalProducts);
			reportGetSumDTO.setTotalServices(totalServices);

			reportGetSumDTO.setTotalSpent(priceTotalSpent);

		}
		return reportGetSumDTO;
	}

	public ReportMonthlyEarningsDTO reportMonthlyEarnings() {

		LocalDateTime firstDayPassMonth = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		LocalDateTime lastDayPassMonth = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

		List<PerformedServices> performedAllPerformedServices = performedServicesRepository
				.findByLocalDateTimeBetween(firstDayPassMonth, lastDayPassMonth);

		Double totalSpent = 0.0;
		Integer totalCuts = 0;
		Integer totalProducts = 0;

		for (PerformedServices x : performedAllPerformedServices) {

			totalSpent += x.getPrice();

			totalProducts = (x.getProducts() != null ? totalProducts++ : totalProducts);
			totalCuts = (x.getService() != null ? totalCuts++ : totalCuts);

		}

		ReportMonthlyEarningsDTO reportMonthlyEarningsDTO = new ReportMonthlyEarningsDTO();
		reportMonthlyEarningsDTO.setTotalProducts(totalProducts);
		reportMonthlyEarningsDTO.setTotalServices(totalCuts);
		reportMonthlyEarningsDTO.setTotalSpent(totalSpent);

		return reportMonthlyEarningsDTO;

	}

}

package com.barbershop.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.PerformedServicesDTO;

@RestController
public class ReportsController {

	@Autowired
	private ReportsService reportsService;

	@GetMapping("/getperformedservicesidclient/{clientId}")
	public ResponseEntity<List<PerformedServicesDTO>> getPerformedServices(@PathVariable Long clientId) {

		List<PerformedServicesDTO> performedServicesDTO = reportsService.getServicesAndProductsForIdClient(clientId);
		return ResponseEntity.ok().body(performedServicesDTO);
	}

	@GetMapping("/getperformedserviceproductsumidclient/{clientId}")
	public ResponseEntity<ReportGetSumDTO> getPerformedServicesAndProductSum(@PathVariable Long clientId) {

		ReportGetSumDTO reportGetSumDTO = reportsService.getSumSpentIdClient(clientId);
		return ResponseEntity.ok().body(reportGetSumDTO);
	}

	@GetMapping("/gettotalmonthspent")
	public ResponseEntity<ReportMonthlyEarningsDTO> getTotalMonthSpent() {

		ReportMonthlyEarningsDTO reportMonthlyEarningsDTO = reportsService.reportMonthlyEarnings();
		return ResponseEntity.ok().body(reportMonthlyEarningsDTO);
	}

}

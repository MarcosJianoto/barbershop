package com.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.PerformedServicesDTO;
import com.barbershop.services.PerformedServicesService;

@RestController
public class PerformedServicesController {

	@Autowired
	private PerformedServicesService performedServicesService;

	@PostMapping("/saveperformedservices")
	public ResponseEntity<Void> savePerformedServices(@RequestBody PerformedServicesDTO performedServicesDTO) {
		performedServicesService.savePerformedServices(performedServicesDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updateperformedservices/{id}")
	public ResponseEntity<Void> updatePerformedServices(@PathVariable Long id,
			@RequestBody PerformedServicesDTO performedServicesDTO) {

		performedServicesService.updatePerformedServices(id, performedServicesDTO);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/deleteperformedservices/{id}")
	public void deletePeformedServices(@PathVariable Long id) {
		performedServicesService.deletePerformedServices(id);
	}

}

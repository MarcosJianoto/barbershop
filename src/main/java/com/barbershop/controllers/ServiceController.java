package com.barbershop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.ServicesDTO;
import com.barbershop.services.ServicesService;

@RestController
public class ServiceController {

	@Autowired
	private ServicesService servicesService;

	@PostMapping("/saveservice")
	public ResponseEntity<Void> saveService(@RequestBody ServicesDTO servicesDTO) {
		servicesService.saveService(servicesDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getservices")
	public ResponseEntity<List<ServicesDTO>> saveService() {
		List<ServicesDTO> getServices = servicesService.getServices();
		return ResponseEntity.ok().body(getServices);
	}

	@GetMapping("/getservices/{id}")
	public ResponseEntity<ServicesDTO> saveService(@PathVariable Long id) {
		ServicesDTO serviceDTO = servicesService.getServiceId(id);
		return ResponseEntity.ok().body(serviceDTO);
	}

	@PutMapping("/updateservice/{id}")
	public ResponseEntity<Void> updateService(@PathVariable Long id, @RequestBody ServicesDTO servicesDTO) {
		servicesService.updateService(id, servicesDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteservice/{id}")
	public void deleteService(@PathVariable Long id) {
		servicesService.deleteService(id);
	}
}

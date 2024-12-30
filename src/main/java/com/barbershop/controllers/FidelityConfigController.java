package com.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.FidelityConfigDTO;
import com.barbershop.services.FidelityConfigService;

@RestController
public class FidelityConfigController {

	@Autowired
	private FidelityConfigService fidelityConfigService;

	@PostMapping("/savefidelityconfig")
	public ResponseEntity<Void> saveFidelityConfig(@RequestBody FidelityConfigDTO fidelityConfigDTO) {
		fidelityConfigService.saveFidelityConfig(fidelityConfigDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/updatefidelityconfig")
	public ResponseEntity<Void> updateFidelityConfig(@RequestBody FidelityConfigDTO fidelityConfigDTO) {

		fidelityConfigService.updateFidelityConfig(fidelityConfigDTO);
		return ResponseEntity.ok().build();

	}

}

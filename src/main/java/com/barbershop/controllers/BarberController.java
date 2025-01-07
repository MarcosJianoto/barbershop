package com.barbershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.BarberDTO;
import com.barbershop.services.BarberService;

@RestController
public class BarberController {

	@Autowired
	private BarberService barberService;

	@PostMapping("/savebarber")
	public ResponseEntity<Void> saveBarber(@RequestBody BarberDTO barberDTO) {

		barberService.saveBarber(barberDTO);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editbarber")
	public ResponseEntity<Void> editBarber(@PathVariable Long id, @RequestBody BarberDTO barberDTO) {

		barberService.editBarber(id, barberDTO);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editdisponibilitybarber")
	public ResponseEntity<Void> editDisponibilityBarber(@PathVariable Long id, @RequestBody BarberDTO barberDTO) {

		barberService.editDisponibilityBarber(id, barberDTO);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/getbarber")
	public ResponseEntity<BarberDTO> getBarber(@PathVariable Long id) {

		BarberDTO barberDTO = barberService.getBarber(id);
		return ResponseEntity.ok().body(barberDTO);
	}

	@DeleteMapping("/deletebarber")
	public void deleteBarber(@PathVariable Long id) {
		barberService.deleteBarber(id);
	}

}

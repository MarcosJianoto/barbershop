package com.barbershop.controllers;

import com.barbershop.entities.Barber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barbershop.dto.BarberDTO;
import com.barbershop.services.BarberService;

import java.util.List;

@RestController
@RequestMapping("/barber")
public class BarberController {

	private final BarberService barberService;

	BarberController(BarberService barberService){
		this.barberService = barberService;
	}

	@PostMapping
	public ResponseEntity<Void> saveBarber(@RequestBody BarberDTO barberDTO) {

		barberService.saveBarber(barberDTO);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editbarber/{id}")
	public ResponseEntity<Void> editBarber(@PathVariable Long id, @RequestBody BarberDTO barberDTO) {

		barberService.editBarber(id, barberDTO);
		return ResponseEntity.noContent().build();

	}

	@PatchMapping("/editavailabilitybarber/{id}")
	public ResponseEntity<Void> editDisponibilityBarber(@PathVariable Long id, @RequestBody BarberDTO barberDTO) {

		barberService.editAvailabilityBarber(id, barberDTO);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<BarberDTO> getBarber(@PathVariable Long id) {
		BarberDTO barberDTO = barberService.getBarber(id);
		return ResponseEntity.ok().body(barberDTO);
	}

	@GetMapping
	public ResponseEntity<List<BarberDTO>> getAllBarbers() {
		List<BarberDTO> barberDTO = barberService.getBarbers();
		return ResponseEntity.ok().body(barberDTO);
	}

	@DeleteMapping("/deletebarber/{id}")
	public void deleteBarber(@PathVariable Long id) {
		barberService.deleteBarber(id);
	}

}

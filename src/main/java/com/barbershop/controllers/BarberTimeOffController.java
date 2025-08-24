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

import com.barbershop.dto.BarberTimeOffDTO;
import com.barbershop.services.BarberTimeOffService;

@RestController
public class BarberTimeOffController {

	@Autowired
	private BarberTimeOffService barberTimeOffService;

	@PostMapping("/savebarbertimeoff")
	public ResponseEntity<Void> saveBarber(@RequestBody BarberTimeOffDTO barberTimeOffDTO) {

		barberTimeOffService.saveBarberTimeOff(barberTimeOffDTO);
		return ResponseEntity.noContent().build();

	}

	@PostMapping("/savebarbertimeoffallday")
	public ResponseEntity<Void> saveBarberTimeOffAllDay(@RequestBody BarberTimeOffDTO barberTimeOffDTO) {

		barberTimeOffService.saveBarberTimeOffAllDay(barberTimeOffDTO);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editbarbertimeoff")
	public ResponseEntity<Void> editBarberTimeOff(@PathVariable Long id,
			@RequestBody BarberTimeOffDTO barberTimeOffDTO) {

		barberTimeOffService.updateBarberTimeOff(id, barberTimeOffDTO);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/getbarbertimeoff/{id}")
	public ResponseEntity<BarberTimeOffDTO> getBarberTimeOffId(@PathVariable Long id) {

		BarberTimeOffDTO barberTimeOffDTO = barberTimeOffService.getBarberTimeOffId(id);
		return ResponseEntity.ok().body(barberTimeOffDTO);
	}

	@GetMapping("/getbarbertimeoff")
	public ResponseEntity<List<BarberTimeOffDTO>> getBarberTimeOff() {
		List<BarberTimeOffDTO> barberTimeOffDTOs = barberTimeOffService.getListBarberTimeOff();
		return ResponseEntity.ok().body(barberTimeOffDTOs);
	}

	@DeleteMapping("/deletebarbertimeoff")
	public void deleteBarber(@PathVariable Long id) {
		barberTimeOffService.deleteBarberTimeOff(id);
	}

}

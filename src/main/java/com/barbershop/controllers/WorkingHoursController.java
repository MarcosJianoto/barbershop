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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.WorkingHoursDTO;
import com.barbershop.dto.WorkingHoursDifferentDTO;
import com.barbershop.dto.WorkingHoursRequest;
import com.barbershop.services.WorkingHoursService;

@RestController
public class WorkingHoursController {

	@Autowired
	private WorkingHoursService workingHoursService;

	@PostMapping("/saveworkinghours")
	public ResponseEntity<Void> saveWorkingHours(@RequestBody WorkingHoursDTO workingHoursDTO) {
		workingHoursService.saveWorkingHours(workingHoursDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/saveworkinghoursweekverifydifferentorequals")
	public ResponseEntity<Void> saveWorkingHoursWeekVerifyDifferentOrEquals(
			@RequestBody WorkingHoursRequest workingHoursRequest, @RequestParam Boolean checkbox)
			throws IllegalAccessException {

		WorkingHoursDTO workingHoursDTO = workingHoursRequest.getWorkingHoursDTO();
		WorkingHoursDifferentDTO workingHoursDifferentDTO = workingHoursRequest.getWorkingHoursDifferentDTO();

		workingHoursService.saveWorkingHoursWeekVerifyDifferentOrEquals(workingHoursDTO, workingHoursDifferentDTO,
				checkbox);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updateworkinghours/{id}")
	public ResponseEntity<Void> updateWorkingHours(@PathVariable Long id,
			@RequestBody WorkingHoursDTO workingHoursDTO) {

		workingHoursService.updateWorkingHours(id, workingHoursDTO);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/getlistworkinghoursfindbarberid/{barberId}")
	public ResponseEntity<List<WorkingHoursDTO>> getListWorkingHoursFindBarberId(@PathVariable Long barberId) {

		List<WorkingHoursDTO> workingHoursDTO = workingHoursService.getWorkingHoursList(barberId);
		return ResponseEntity.ok().body(workingHoursDTO);
	}

	@GetMapping("/getworkinghours/{id}")
	public ResponseEntity<WorkingHoursDTO> getWorkingHours(@PathVariable Long id) {

		WorkingHoursDTO workingHoursDTO = workingHoursService.getWorkingHours(id);
		return ResponseEntity.ok().body(workingHoursDTO);
	}

	@DeleteMapping("/deleteWorkinghours/{id}")
	public void deleteBarber(@PathVariable Long id) {
		workingHoursService.deleteWorkingHours(id);
	}
}

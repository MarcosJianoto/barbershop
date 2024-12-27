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

import com.barbershop.dto.ClientDTO;
import com.barbershop.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/saveclient")
	public ResponseEntity<Void> saveClient(@RequestBody ClientDTO clientDTO) {

		clientService.saveClient(clientDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getclient/{id}")
	public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {

		ClientDTO clientDTO = clientService.getClient(id);
		return ResponseEntity.ok().body(clientDTO);
	}

	@PutMapping("/editclient")
	public ResponseEntity<Void> editClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
		clientService.editClient(id, clientDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteclient/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
	}
}

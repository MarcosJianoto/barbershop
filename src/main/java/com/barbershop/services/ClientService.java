package com.barbershop.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.ClientDTO;
import com.barbershop.entities.Client;
import com.barbershop.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public void saveClient(ClientDTO clientDTO) {
		Client client = new Client();
		client.setName(clientDTO.getName());
		client.setDateTime(LocalDateTime.now());
		client.setFone(clientDTO.getFone());
		client.setDateOfBirth(client.getDateOfBirth());
		clientRepository.save(client);
	}

	public ClientDTO getClient(Long id) {

		Optional<Client> client = clientRepository.findById(id);
		ClientDTO clientDTO = new ClientDTO();

		if (client.isPresent()) {
			clientDTO.setId(id);
			clientDTO.setName(client.get().getName());
			clientDTO.setDateOfBirth(client.get().getDateOfBirth().toString());
			clientDTO.setFone(client.get().getFone());
			clientDTO.setDateTime(client.get().getDateTime().toString());

		}
		return clientDTO;

	}

	public void editClient(Long id, ClientDTO clientDTO) {

		Optional<Client> client = clientRepository.findById(id);

		if (client.isPresent()) {
			client.get().setName(clientDTO.getName());
			client.get().setFone(clientDTO.getFone());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(clientDTO.getDateTime(), formatter);

			client.get().setDateTime(dateTime);

			LocalDateTime birthdayHourAndDate = LocalDateTime.parse(clientDTO.getDateOfBirth(), formatter);
			client.get().setDateOfBirth(birthdayHourAndDate);

		}
		clientRepository.save(client.get());
	}

	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

}

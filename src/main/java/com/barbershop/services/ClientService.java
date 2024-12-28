package com.barbershop.services;

import java.time.LocalDate;
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

		DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateFormat = LocalDate.parse(clientDTO.getDateOfBirth(), dts1);

		client.setDateOfBirth(dateFormat);
		clientRepository.save(client);
	}

	public ClientDTO getClient(Long id) {

		Optional<Client> client = clientRepository.findById(id);
		ClientDTO clientDTO = new ClientDTO();

		if (client.isPresent()) {
			clientDTO.setId(id);
			clientDTO.setName(client.get().getName());
			if (client.get().getDateOfBirth() != null) {
				clientDTO.setDateOfBirth(client.get().getDateOfBirth().toString());
			}
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

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate birthdayHourAndDate = LocalDate.parse(clientDTO.getDateOfBirth(), formatter);
			client.get().setDateOfBirth(birthdayHourAndDate);

		}
		clientRepository.save(client.get());
	}

	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

}

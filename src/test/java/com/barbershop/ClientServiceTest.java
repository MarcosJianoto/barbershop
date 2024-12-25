package com.barbershop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barbershop.dto.ClientDTO;
import com.barbershop.services.ClientService;

@SpringBootTest(classes = BarbershopApplication.class)
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;

	@Test
	private void saveClientTest() {

		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setName("teste");
		clientDTO.setFone("92532075327");
		clientDTO.setDateOfBirth("25/10/2025");
		

	}

}

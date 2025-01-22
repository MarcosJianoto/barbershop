package com.barbershop.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.AppointmentsDTO;
import com.barbershop.dto.AppointmentsUpdateDTO;
import com.barbershop.entities.Appointments;
import com.barbershop.entities.Barber;
import com.barbershop.entities.BarberTimeOff;
import com.barbershop.entities.Client;
import com.barbershop.entities.Services;
import com.barbershop.entities.WorkingHours;
import com.barbershop.repositories.AppointmentsRepository;
import com.barbershop.repositories.BarberRepository;
import com.barbershop.repositories.BarberTimeOffRepository;
import com.barbershop.repositories.ClientRepository;
import com.barbershop.repositories.ServicesRepository;
import com.barbershop.repositories.WorkingHoursRepository;

@Service
public class AppointmentsService {

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BarberRepository barberRepository;

	@Autowired
	private ServicesRepository servicesRepository;

	@Autowired
	private WorkingHoursRepository workingHoursRepository;

	@Autowired
	private BarberTimeOffRepository barberTimeOffRepository;

	public void saveAppointments(AppointmentsDTO appointmentsDTO) throws IllegalAccessException {

		Barber barber = barberRepository.findById(appointmentsDTO.getBarberId())
				.orElseThrow(() -> new IllegalAccessException("Barber not found"));

		Client client = clientRepository.findByFone(appointmentsDTO.getClientFone())
				.orElseThrow(() -> new IllegalArgumentException("Client not found"));

		Services service = servicesRepository.findById(appointmentsDTO.getServiceId())
				.orElseThrow(() -> new IllegalAccessException(" Service not found"));

		if (barber.getIsActive()) {

			Appointments appointments = new Appointments();
			appointments.setBarberId(barber);
			appointments.setClientId(client);
			appointments.setServiceId(service);

			DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				LocalDate appointmentDate = LocalDate.parse(appointmentsDTO.getAppointmentDate(), dtfDate);
				appointments.setAppointmentDate(appointmentDate);

			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid date format. Expected dd/MM/yyyy");
			}

			DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm");
			try {
				LocalTime appointmentTime = LocalTime.parse(appointmentsDTO.getAppointmentTime(), dtfTime);
				appointments.setAppointmentTime(appointmentTime);

			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid time format. Expected HH:mm");
			}

			appointments.setAppointmentsStatusEnum(appointmentsDTO.getAppointmentsStatusEnum());
			appointments.setCreatedAt(LocalDateTime.now());
			appointments.setUpdatedAt(null);
			appointmentsRepository.save(appointments);

		}

	}

	public void updateAppointments(Long Id, AppointmentsUpdateDTO appointmentsUpdateDTO) throws IllegalAccessException {

		Appointments appointments = appointmentsRepository.findById(Id)
				.orElseThrow(() -> new IllegalAccessException("Appointments not found"));

		Client client = clientRepository.findByFone(appointmentsUpdateDTO.getClientFone())
				.orElseThrow(() -> new IllegalArgumentException("Client not found"));

		Barber barber = barberRepository.findById(appointmentsUpdateDTO.getBarberId())
				.orElseThrow(() -> new IllegalAccessException("Barber not found"));

		Services service = servicesRepository.findById(appointmentsUpdateDTO.getServiceId())
				.orElseThrow(() -> new IllegalAccessException(" Service not found"));

		if (barber.getIsActive()) {

			appointments.setBarberId(barber);
			appointments.setClientId(client);
			appointments.setUpdatedAt(LocalDateTime.now());
			appointments.setAppointmentsStatusEnum(appointmentsUpdateDTO.getAppointmentsStatusEnum());
			appointments.setServiceId(service);

			appointmentsRepository.save(appointments);
		}

	}

	public List<AppointmentsDTO> getAppointments() {

		List<Barber> activeBarbers = barberRepository.findAll().stream().filter(Barber::getIsActive).toList();

		if (activeBarbers.isEmpty()) {
			throw new IllegalStateException("No active barbers found");
		}

		List<AppointmentsDTO> barberAppointmentsFree = new ArrayList<>();

		for (Barber barb : activeBarbers) {

			// verificar se o barbeiro não tem folga nesses dias.
			// verificar os dias disponíveis do barbeiro.
			// verificar os horários disponíveis do barbeiro.
		}

		return barberAppointmentsFree;

	}

	public List<WorkingHours> getWorkingHours(Long barberId) {
		List<WorkingHours> workingHours = workingHoursRepository.findByBarber_Id(barberId);
		return workingHours;
	}

	public List<BarberTimeOff> getBarberTimeOff(Long barberId) {
		List<BarberTimeOff> barberTimeOffs = barberTimeOffRepository.findByBarberId(barberId);
		return barberTimeOffs;
	}

	public void deleteAppointments(Long id) {
		appointmentsRepository.deleteById(id);
	}

}

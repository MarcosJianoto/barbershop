package com.barbershop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fidelity")
public class Fidelity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fidelity_sequence")
	@SequenceGenerator(name = "fidelity_sequence", sequenceName = "fidelity_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "cuts_made")
	private Integer cutsMade;

	@Column(name = "free_cuts")
	private Integer freeCuts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getCutsMade() {
		return cutsMade;
	}

	public void setCutsMade(Integer cutsMade) {
		this.cutsMade = cutsMade;
	}

	public Integer getFreeCuts() {
		return freeCuts;
	}

	public void setFreeCuts(Integer freeCuts) {
		this.freeCuts = freeCuts;
	}

}

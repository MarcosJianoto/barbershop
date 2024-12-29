package com.barbershop.dto;

public class FidelityDTO {

	private Long id;

	private Long client;

	private Integer cutsMade;

	private Integer freeCuts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
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

package com.barbershop.entities;

public enum StatusProduct {

	AVAILABLE("Disponível para venda"), OUT_OF_STOCK("Fora de estoque"), DISCONTINUED("Descontinuado"),
	RESERVED("Reservado para pedidos"), PENDING_REPLENISHMENT("Aguardando reposição");

	private String description;

	StatusProduct(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

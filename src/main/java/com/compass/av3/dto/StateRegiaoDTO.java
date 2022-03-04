package com.compass.av3.dto;

import com.compass.av3.entity.State;

public class StateRegiaoDTO {

	private Long id;
	private String nome;
	private String capital;
	
	public StateRegiaoDTO() {}

	public StateRegiaoDTO(State state) {
		this.id = state.getId();
		this.nome = state.getNome();
		this.capital = state.getCapital();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
}
package com.compass.av3.dto;

import com.compass.av3.entity.State;

public class StateAreaDTO {

	private Long id;
	private String nome;
	private Double area;
	
	public StateAreaDTO() {}

	public StateAreaDTO(State state) {
		this.id = state.getId();
		this.nome = state.getNome();
		this.area = state.getArea();
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
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
}

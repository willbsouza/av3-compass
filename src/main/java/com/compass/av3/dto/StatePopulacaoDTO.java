package com.compass.av3.dto;

import com.compass.av3.entity.State;

public class StatePopulacaoDTO {

	private Long id;
	private String nome;
	private Integer populacao;
	
	public StatePopulacaoDTO() {}

	public StatePopulacaoDTO(State state) {
		this.id = state.getId();
		this.nome = state.getNome();
		this.populacao = state.getPopulacao();
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
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
}

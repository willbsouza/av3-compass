package com.compass.av3.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.compass.av3.entity.enums.Regiao;

@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Regiao regiao;
	
	@NotNull
	private Integer populacao;
	
	@NotNull @NotEmpty
	private String capital;
	
	@NotNull
	private Double area;
	
	@NotNull
	private LocalDate dataDeFundacao;
	
	@NotNull
	private Integer tempoDesdeFundacao;
	
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
	public String getRegiao() {
		return regiao.getDescricao();
	}
	public void setRegiao(String regiao) {
		this.regiao = Regiao.getEnum(regiao);
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}
	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}
	public Integer getTempoDesdeFundacao() {
		return tempoDesdeFundacao;
	}
	public void setTempoDesdeFundacao(Integer tempoDesdeFundacao) {
		this.tempoDesdeFundacao = tempoDesdeFundacao;
	}
}

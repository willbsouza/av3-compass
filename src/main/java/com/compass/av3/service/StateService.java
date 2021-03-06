package com.compass.av3.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.av3.dto.StateAreaDTO;
import com.compass.av3.dto.StatePopulacaoDTO;
import com.compass.av3.dto.StateRegiaoDTO;
import com.compass.av3.entity.State;
import com.compass.av3.repository.StateRepository;
import com.compass.av3.service.exception.DataTempoFundacaoException;
import com.compass.av3.service.exception.EntityNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	private void validarTempoFundacao(State state) {
		Integer tempoFundacao = state.getTempoDesdeFundacao();
		LocalDate dataHoje = LocalDate.now();
		LocalDate dataFundacao = state.getDataDeFundacao();
		Period periodo = Period.between(dataFundacao, dataHoje);
		if (periodo.getYears() != tempoFundacao) {
			throw new DataTempoFundacaoException("Tempo de Fundação ou Data de Fundação inválido.");
		}
	}

	public List<State> findAll() {
		return stateRepository.findAll();
	}

	public State findById(Long id) {
		return stateRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID " + id + " não encontrado "));
	}

	public State save(State state) {
		validarTempoFundacao(state);
		return stateRepository.save(state);
	}

	public State updateById(Long id, State state) {
		validarTempoFundacao(state);
		State stateParaAtualizar = findById(id);
		if (stateParaAtualizar != null) {
			stateParaAtualizar.setNome(state.getNome());
			stateParaAtualizar.setRegiao(state.getRegiao());
			stateParaAtualizar.setPopulacao(state.getPopulacao());
			stateParaAtualizar.setCapital(state.getCapital());
			stateParaAtualizar.setArea(state.getArea());
			stateParaAtualizar.setDataDeFundacao(state.getDataDeFundacao());
			stateParaAtualizar.setTempoDesdeFundacao(state.getTempoDesdeFundacao());
			return stateParaAtualizar;
		}
		throw new EntityNotFoundException("ID " + id + " não encontrado");
	}

	public void deleteById(Long id) {
		if (findById(id) != null) {
			stateRepository.deleteById(id);
		}
	}

	public List<StateRegiaoDTO> procurarPorRegiao(String nome) {
		List<StateRegiaoDTO> listaEstados = stateRepository.findAll().stream()
				.filter(state -> state.getRegiao().equalsIgnoreCase(nome)).map(StateRegiaoDTO::new)
				.collect(Collectors.toList());
		return listaEstados;
	}

	public List<StatePopulacaoDTO> procurarMaioresPopulacoes(Integer valor) {
		List<StatePopulacaoDTO> listaPopulacoes = stateRepository.findAll().stream()
				.filter(state -> state.getPopulacao() >= valor)
				.sorted(Comparator.comparing(State::getPopulacao).reversed()).map(StatePopulacaoDTO::new)
				.collect(Collectors.toList());
		return listaPopulacoes;
	}

	public List<StateAreaDTO> procurarMaioresAreas(Double valor) {
		List<StateAreaDTO> listaAreas = stateRepository.findAll().stream().filter(state -> state.getArea() >= valor)
				.sorted(Comparator.comparing(State::getArea).reversed()).map(StateAreaDTO::new)
				.collect(Collectors.toList());
		return listaAreas;
	}
}

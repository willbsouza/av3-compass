package com.compass.av3.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.av3.dto.StateAreaDTO;
import com.compass.av3.dto.StatePopulacaoDTO;
import com.compass.av3.dto.StateRegiaoDTO;
import com.compass.av3.entity.State;
import com.compass.av3.service.StateService;

@RestController
@RequestMapping("/api/states")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping
	public ResponseEntity<List<State>> findAll(){
		return ResponseEntity.ok(stateService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<State> findById(@PathVariable Long id){
		if(stateService.findById(id) != null) {
			return ResponseEntity.ok(stateService.findById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/regiao")
	public ResponseEntity<List<StateRegiaoDTO>> procurarPorRegiao(@RequestParam String nome){
		return ResponseEntity.ok(stateService.procurarPorRegiao(nome));
	}
	
	@GetMapping(path = "/populacao")
	public ResponseEntity<List<StatePopulacaoDTO>> procurarMaioresPopulacoes(@RequestParam Integer valor){
		return ResponseEntity.ok(stateService.procurarMaioresPopulacoes(valor));
	}
	
	@GetMapping(path = "/area")
	public ResponseEntity<List<StateAreaDTO>> procurarMaioresAreas(@RequestParam Double valor){
		return ResponseEntity.ok(stateService.procurarMaioresAreas(valor));		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<State> save(@RequestBody @Valid State state, UriComponentsBuilder uriBuilder) {
		URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(stateService.save(state));
	}
	
	@PutMapping(path = "/{id}")
	@Transactional
	public ResponseEntity<State> updateById(@PathVariable Long id, @RequestBody @Valid State state) {
		if(stateService.updateById(id, state) != null) {
			return ResponseEntity.ok(stateService.updateById(id, state));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		if (stateService.deleteById(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}


package com.example.APIBianca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.APIBianca.model.Estudante;
import com.example.APIBianca.repository.EstudanteRepo;

@RestController
@RequestMapping(value="/api/estudantes")
public class EstudanteController 
{
	@Autowired
	EstudanteRepo estudanteRepo;
	
	@PostMapping
	//salva estudante
	public Estudante salvaEstudante(@RequestBody Estudante estudante) {
		return estudanteRepo.save(estudante);
	}
	
	@GetMapping
	//retorna lista de estudantes
	public List<Estudante> listaEstudante(){
		return estudanteRepo.findAll();
	}
	
	@GetMapping("/{id}")
	//retorna um estudante a partir do id especificado
	public Estudante getEstudante(@PathVariable(value="id") Long id){
		return estudanteRepo.findById(id).get();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	//deleta um objeto estudante
	public ResponseEntity<Object> deletaEstudante(@PathVariable(value="id") Long id){
		Optional<Estudante> e = estudanteRepo.findById(id);
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		estudanteRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	//atualiza dados do estudante
	public Estudante atualizaEscola(@RequestBody Estudante estudante) {
		
		return estudanteRepo.save(estudante);
	}
}

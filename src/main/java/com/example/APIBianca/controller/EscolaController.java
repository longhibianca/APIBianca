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

import com.example.APIBianca.repository.EscolaRepo;
import com.example.APIBianca.model.Escola;
@RestController
@RequestMapping(value="/api/escolas")
public class EscolaController 
{
	@Autowired
	EscolaRepo escolaRepo;
	
	@GetMapping
	//retorna lista de escolas
	public List<Escola> listaEscola(){
		return escolaRepo.findAll();
	}

	@GetMapping("/{id}")
	//retorna uma escola a partir do id especificado
	public Escola getEscola(@PathVariable(value="id") Long id){
		return escolaRepo.findById(id).get();
	}
	
	@PostMapping
	//salva escola
	public Escola salvaEscola(@RequestBody Escola escola) {
		return escolaRepo.save(escola);
	}
	
	/*@DeleteMapping
	public void deletaCarrinho(@RequestBody Escola escola){
		escolaRepo.delete(escola);
	}*/
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	//deleta um objeto escola
	public ResponseEntity<Object> deletaEscola(@PathVariable(value="id") Long id){
		Optional<Escola> e = escolaRepo.findById(id);
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		escolaRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping
	//atualiza dados da escola
	public Escola atualizaEscola(@RequestBody Escola escola) {
		
		return escolaRepo.save(escola);
	}
}

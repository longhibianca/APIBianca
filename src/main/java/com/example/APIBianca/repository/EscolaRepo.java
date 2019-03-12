package com.example.APIBianca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.APIBianca.model.Escola;

public interface EscolaRepo extends JpaRepository<Escola, Long> {
	
}
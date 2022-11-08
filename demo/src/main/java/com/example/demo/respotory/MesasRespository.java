package com.example.demo.respotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Mesas;

public interface MesasRespository extends JpaRepository<Mesas, Long> {
	// List<Mesas> findByNameContaining(String name);
}
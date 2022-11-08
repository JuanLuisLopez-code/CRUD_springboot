package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Mesas;
import com.example.demo.respotory.MesasRespository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MesaController {
	@Autowired
	MesasRespository mesasRespository;

	@GetMapping("/mesas")
	public ResponseEntity<List<Mesas>> getAllNames() {
		try {
			List<Mesas> mesas = new ArrayList<Mesas>();
			mesasRespository.findAll().forEach(mesas::add);
			return new ResponseEntity<>(mesas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/mesas")
	public ResponseEntity<Mesas> createName(@RequestBody Mesas name_mesa) {
		try {
			Mesas _mesaNueva = mesasRespository.save(new Mesas(name_mesa.getName()));
			return new ResponseEntity<>(_mesaNueva, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

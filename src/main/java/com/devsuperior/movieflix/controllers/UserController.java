package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> findById() {
		UserDTO dto = service.profile();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<UserDTO> findByDefault(@PathVariable String name) {
		UserDTO dto = service.findByName(name);
		return ResponseEntity.ok().body(dto);
	}
	
}

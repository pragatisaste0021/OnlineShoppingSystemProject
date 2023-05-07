package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Moderator;
import com.example.demo.service.ModeratorService;

@RestController
@RequestMapping("/moderator")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeratorController {

	@Autowired
	ModeratorService service;
	
	@GetMapping("/list")
	public List<Moderator> findAllModerators() {
		List<Moderator> list = service.findAllModerators();
		return list;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity <Moderator> getModeratorById(@PathVariable ("id") int id) {
		return new ResponseEntity <Moderator> (service.findModeratorById(id), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity <Moderator> addModerator(@Valid @RequestBody Moderator m){
		return new ResponseEntity <Moderator> (service.addModerator(m), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <Moderator> updateModerator(@Valid @RequestBody Moderator m){
		return new ResponseEntity <Moderator> (service.updateModerator(m), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deleteModerator(@PathVariable ("id") int id){
		service.deleteModerator(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}
	
}

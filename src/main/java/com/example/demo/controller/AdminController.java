package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.pojo.AdminPojo;
import com.example.demo.domain.service.IAdminService;

@RestController
@RequestMapping(path="/admin")
public class AdminController {
	
	private final IAdminService iAdminService;
	
	
	
	public AdminController(IAdminService iAdminService) {
		this.iAdminService = iAdminService;
	}



	@GetMapping
	public ResponseEntity<List<AdminPojo>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(iAdminService.getAll());
	}
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity<AdminPojo> getAdminById(@PathVariable Long id){
		return ResponseEntity.of(iAdminService.getAdminById(id));
	}

	
	@GetMapping(path="/email/{email}")
	public ResponseEntity<AdminPojo> getAdminById(@PathVariable String email){
		return ResponseEntity.of(iAdminService.getAdminByEmail(email));
	}
	
	
	@PostMapping
	public ResponseEntity<AdminPojo> save(@RequestBody AdminPojo adminPojo){
		return ResponseEntity.status(HttpStatus.CREATED).body(iAdminService.save(adminPojo));
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return new ResponseEntity<>(this.iAdminService.deleteAdmin(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}

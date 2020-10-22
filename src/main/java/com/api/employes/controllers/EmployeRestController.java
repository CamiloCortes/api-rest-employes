package com.api.employes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.employes.models.entity.Employe;
import com.api.employes.models.services.IEmployeService;

@RestController
@RequestMapping("/api")
public class EmployeRestController {

	@Autowired
	@Qualifier("employeServiceImpl")
	private IEmployeService employeService;
	
	@GetMapping("/allEmployes")
	public List<Employe>getAllEmployes() {
		
		return employeService.findAll();
	}
	
	@PostMapping("/createEmploye")
	public void createEmploye(@RequestBody Employe employe) {
		
		employeService.save(employe);
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public void delete(@PathVariable Long id) {
		
		employeService.delete(id);
	}
}

package com.api.employes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.employes.models.entity.Employe;
import com.api.employes.models.entity.Role;
import com.api.employes.models.services.IEmployeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmployeRestController {

	@Autowired
	@Qualifier("employeServiceImpl")
	private IEmployeService employeService;

	@GetMapping("/allEmployes")
	public List<Employe> getAllEmployes() {

		return employeService.findAll();
	}

	@PostMapping("/createEmploye")
	public ResponseEntity<?>  createEmploye(@Valid @RequestBody Employe employe, BindingResult result) {
		Employe employeNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			employeNew = employeService.save(employe);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "El Empleado ha sido creado con éxito!");
		response.put("employe", employeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

		
	}

	@DeleteMapping("/deleteEmploye/{id}")
	public void delete(@PathVariable Long id) {

		employeService.delete(id);
	}

	@GetMapping("/getById/{id}")
	public Employe getById(Long id) {

		return employeService.findById(id);
	}
	
	@GetMapping("/allRoles")
	public List<Role> getAllRoles(){
		return employeService.findAllRoles();
	}
	
	@GetMapping("/allBoss")
	public List<Employe> getAllBoss(){
		
		return employeService.findAllBoss();
	}
}

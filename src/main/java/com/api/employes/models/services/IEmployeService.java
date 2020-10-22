package com.api.employes.models.services;

import java.util.List;

import com.api.employes.models.entity.Employe;

public interface IEmployeService {

	public List<Employe> findAll();
	
	public Employe save(Employe employe);
	
	public void delete(Long id);
	
	public Employe findById(Long id);
}

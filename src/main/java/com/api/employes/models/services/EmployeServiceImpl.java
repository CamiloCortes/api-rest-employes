package com.api.employes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.employes.models.dao.IEmployeDao;
import com.api.employes.models.entity.Employe;
import com.api.employes.models.entity.Role;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	private IEmployeDao employeDao;

	@Override
	public List<Employe> findAll() {

		return employeDao.findAll();
	}

	@Override
	public Employe save(Employe employe) {

		return employeDao.save(employe);
	}

	@Override
	public void delete(Long id) {
		
		employeDao.deleteById(id);
		
	}

	@Override
	public Employe findById(Long id) {
		
		return employeDao.findById(id).orElse(null);
	}

	@Override
	public List<Role> findAllRoles() {
		
		return employeDao.findAllRoles();
	}

	@Override
	public List<Employe> findAllBoss() {
		
		return employeDao.getAllBoss();
	}

}

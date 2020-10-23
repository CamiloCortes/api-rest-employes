package com.api.employes.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.employes.models.entity.Employe;
import com.api.employes.models.entity.Role;

public interface IEmployeDao extends JpaRepository<Employe, Long>{
	
	@Query("from Role")
	public List<Role> findAllRoles();
	
	@Query("select e from Employe e where e.role.id = 1")
	public List<Employe> getAllBoss();
}

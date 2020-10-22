package com.api.employes.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.employes.models.entity.Employe;

public interface IEmployeDao extends JpaRepository<Employe, Long>{

}

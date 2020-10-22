package com.api.employes.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.api.employes.models.dao.IEmployeDao;
import com.api.employes.models.entity.Employe;
import com.api.employes.models.services.EmployeServiceImpl;
import com.api.employes.models.services.IEmployeService;

@SpringBootTest
public class ApiRestEmployesApplicationTests {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean("test")
		public IEmployeService employeeService() {
			return new EmployeServiceImpl();
		}
	}

	@Autowired
	@Qualifier("test")
	private IEmployeService employeService;

	@MockBean
	private IEmployeDao employeRepository;

	@BeforeEach
    public void setUp() {
	   Employe employe = new Employe();
	   employe.setId((long)1);
	   employe.setEmail("test1@api.com");
	   Mockito.when(employeRepository.findById(employe.getId())).thenReturn(Optional.of(employe));
    }

	@Test
	void contextLoads() {
	}
	
	@Test
	public void validate_findById_employe() {
		
		Employe employe = employeService.findById((long)1);
		
		assertThat(employe.getEmail()).isEqualTo("test1@api.com");
	}

}

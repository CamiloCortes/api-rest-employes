package com.api.employes.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employes")
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 50, message = "el tamaño tiene que estar entre 4 y 12")
	@Column(nullable = false)
	private String fullname;

//	@NotEmpty(message = "no puede estar vacio")
//	@Column(nullable = false)
//	private String Descriptionfunction;

	@NotNull(message = "El rol no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Role role;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_boss")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Employe boss;

//	@Column(nullable = true)
//	private Long idBoss;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

//	public String getDescriptionfunction() {
//		return Descriptionfunction;
//	}
//
//	public void setDescriptionfunction(String descriptionfunction) {
//		Descriptionfunction = descriptionfunction;
//	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employe getBoss() {
		return boss;
	}

	public void setBoss(Employe boss) {
		this.boss = boss;
	}

//	public Long getIdBoss() {
//		return idBoss;
//	}
//
//	public void setIdBoss(Long idBoss) {
//		this.idBoss = idBoss;
//	}

	
}

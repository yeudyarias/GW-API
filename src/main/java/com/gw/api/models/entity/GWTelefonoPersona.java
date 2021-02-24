package com.gw.api.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "telefono_persona")
public class GWTelefonoPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefonoPersona;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)
	private Long idTelefono;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)
	private Long idPersona;

	public Long getIdTelefonoPersona() {
		return idTelefonoPersona;
	}

	public void setIdTelefonoPersona(Long idTelefonoPersona) {
		this.idTelefonoPersona = idTelefonoPersona;
	}

	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

}

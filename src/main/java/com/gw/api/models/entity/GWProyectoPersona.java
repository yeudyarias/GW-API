package com.gw.api.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "proyecto_persona")
public class GWProyectoPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyectoPersona;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idProyecto;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idPersona;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaInicio;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaFin;

	public Long getIdProyectoPersona() {
		return idProyectoPersona;
	}

	public void setIdProyectoPersona(Long idProyectoPersona) {
		this.idProyectoPersona = idProyectoPersona;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}

package com.gw.api.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paciente_enfermedad")
public class PacienteEnfermedad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enfermedad_id")
	private Enfermedad enfermedad;

	public PacienteEnfermedad() {

	}

	public PacienteEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	private static final long serialVersionUID = 1L;
}

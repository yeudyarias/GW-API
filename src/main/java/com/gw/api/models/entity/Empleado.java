package com.gw.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empleadoX")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 9, max = 12, message = "el tamaño tiene que estar entre 9 y 12")
	@Column(nullable = false)
	private String identificacion;

	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false)
	private String estadoCivil;

	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false)
	private String sexo;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 8, max = 15, message = "el tamaño tiene que estar entre 8 y 15")
	@Column(nullable = false)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private Boolean habilitado;
	
	@NotNull(message = "la región no puede ser vacia")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private static final long serialVersionUID = 1L;
}

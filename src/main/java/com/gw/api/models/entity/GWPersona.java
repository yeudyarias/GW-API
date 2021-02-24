package com.gw.api.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class GWPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String identificacion;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private String tipoIdentificacion;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaNacimiento;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String email;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String ubicacion;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private String estadoCivil;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}

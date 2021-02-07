package com.longiara.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
	@Column(nullable = false)
	private String nombre;

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
	@Column(nullable = false)
	private Long idEspecialidad;

	@NotEmpty(message = "No puede estar vacio")
	@Email(message = "No es una dirección de correo bien formada")
	@Column(nullable = false, unique = true)
	private String email;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 8, max = 15, message = "el tamaño tiene que estar entre 8 y 15")
	@Column(nullable = false)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private int habilitado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	private static final long serialVersionUID = 1L;
}

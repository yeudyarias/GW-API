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
@Table(name = "proyectos")
public class GWProyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 100, message = "el tamaño tiene que estar entre 5 y 100")
	@Column(nullable = false, unique = false)
	private String descripcion;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)
	private Date fechaInicio;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)
	private Date fechaFinal;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String ubicacion;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)

	private Long pais;

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long pais) {
		this.pais = pais;
	}
}

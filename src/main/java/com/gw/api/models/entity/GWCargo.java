package com.gw.api.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cargo")
public class GWCargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCargo;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String descripcion;

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
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
}

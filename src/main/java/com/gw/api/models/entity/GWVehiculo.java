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
@Table(name = "vehiculo")
public class GWVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long marca;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 3, max = 20, message = "el tamaño tiene que estar entre 3 y 20")
	@Column(nullable = false, unique = false)
	private String modelo;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String descripcion;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 4, message = "el tamaño tiene que ser de 4 digitos")
	@Column(nullable = false, unique = false)
	private String anno;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 1, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String chasis;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

}

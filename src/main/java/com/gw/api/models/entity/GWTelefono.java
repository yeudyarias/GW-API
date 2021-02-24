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
@Table(name = "telefono")
public class GWTelefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefono;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 8, max = 45, message = "el tamaño tiene que estar entre 8 y 45")
	@Column(nullable = false, unique = false)
	private String numero;
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false, unique = false)
	private String tipo;

	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

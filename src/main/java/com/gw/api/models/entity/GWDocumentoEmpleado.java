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
@Table(name = "documento_empleado")
public class GWDocumentoEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocumentoEmpleado;	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idProyecto;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String descripcion;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaEntrega;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaVencimiento;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Integer diasAlerta;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private byte[] documento;

	public Long getIdDocumentoEmpleado() {
		return idDocumentoEmpleado;
	}

	public void setIdDocumentoEmpleado(Long idDocumentoEmpleado) {
		this.idDocumentoEmpleado = idDocumentoEmpleado;
	}

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

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getDiasAlerta() {
		return diasAlerta;
	}

	public void setDiasAlerta(Integer diasAlerta) {
		this.diasAlerta = diasAlerta;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
}

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
@Table(name = "empleado_vehiculo")
public class GWEmpleadoVehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleadoVehiculo;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idEmpleado;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idVehiculo;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idProyecto;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaInicio;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fechaFin;
	@Column(nullable = true, unique = false)
	private String fallas;
	@Column(nullable = true, unique = false)
	private String descripcion;

	public Long getIdEmpleadoVehiculo() {
		return idEmpleadoVehiculo;
	}

	public void setIdEmpleadoVehiculo(Long idEmpleadoVehiculo) {
		this.idEmpleadoVehiculo = idEmpleadoVehiculo;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
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

	public String getFallas() {
		return fallas;
	}

	public void setFallas(String fallas) {
		this.fallas = fallas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

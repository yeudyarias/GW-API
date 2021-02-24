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
@Table(name = "horario_empleado")
public class GWHorarioEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHorarioEmpleado;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idEmpleado;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idProyecto;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date fecha;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date horaInicio;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Date horaFin;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, max = 45, message = "el tamaño tiene que estar entre 5 y 45")
	@Column(nullable = false, unique = false)
	private String descripcion;

	public Long getIdHorarioEmpleado() {
		return idHorarioEmpleado;
	}

	public void setIdHorarioEmpleado(Long idHorarioEmpleado) {
		this.idHorarioEmpleado = idHorarioEmpleado;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

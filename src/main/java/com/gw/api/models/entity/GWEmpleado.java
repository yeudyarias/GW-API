package com.gw.api.models.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "empleado")
public class GWEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private Long idPersona;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, unique = false)
	private Long idCargo;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private Date fechaInicio;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private Date fechaFin;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String tipoSalario;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private BigDecimal salario;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private BigDecimal montoHora;
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String estado;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
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

	public String getTipoSalario() {
		return tipoSalario;
	}

	public void setTipoSalario(String tipoSalario) {
		this.tipoSalario = tipoSalario;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getMontoHora() {
		return montoHora;
	}

	public void setMontoHora(BigDecimal montoHora) {
		this.montoHora = montoHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

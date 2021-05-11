package com.gw.api.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empleado")
public class GWEmpleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	@NotNull(message = "el cargo no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private GWCargo cargo;
	
	@NotNull(message = "el pais no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private GWPais pais;
	
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
	
	private String foto;	
	
	private String type;	
	
	@Column(length=100000)
	private byte[] picByte;
	
	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "id_persona", updatable = false, nullable = false)
	private GWPersona persona;
	
	@JsonBackReference
	@OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL) 
    private Usuario usuario;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_empleado")
	private List<GWDocumentoEmpleado> documentos;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public GWPersona getPersona() {
		return persona;
	}

	public void setPersona(GWPersona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GWCargo getCargo() {
		return cargo;
	}

	public void setCargo(GWCargo cargo) {
		this.cargo = cargo;
	}

	public GWPais getPais() {
		return pais;
	}

	public void setPais(GWPais pais) {
		this.pais = pais;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

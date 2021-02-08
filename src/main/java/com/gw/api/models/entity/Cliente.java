package com.gw.api.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 9, max = 20, message = "el tamaño tiene que estar entre 9 y 20")
	@Column(nullable = false, unique = true)
	private String identificacion;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 40, message = "el tamaño tiene que estar entre 4 y 40")
	@Column(nullable = false)
	private String nombre;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNa;

	@NotEmpty(message = "no puede estar vacio")
	@Column(name = "grupo_sanguineo")
	private String grupoSanguineo;

	@NotEmpty(message = "no puede estar vacio")
	@Column(name = "estado_civil")
	private String estadoCivil;

	@NotEmpty(message = "no puede estar vacio")
	private String religion;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = true)
	private String email;

	@NotEmpty(message = "no puede estar vacio")
	private String telefono;

	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIn;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 200, message = "el tamaño tiene que estar entre 4 y 200")
	@Column(nullable = false)
	private String direccion;

	private String foto;
	
	@NotEmpty(message = "no puede estar vacio")
	private String sexo;

	@JsonIgnoreProperties(value = { "cliente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<Contacto> contactos;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<PacienteEnfermedad>  pacenf;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 200, message = "el tamaño tiene que estar entre 4 y 200")
	@Column(nullable = false)
	private String observacion;
		
	
	
	@Transient
	private List<String> enfermedades;

	public Cliente() {
		this.facturas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNa() {
		return fechaNa;
	}

	public void setFechaNa(Date fechaNa) {
		this.fechaNa = fechaNa;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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

	public Date getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<PacienteEnfermedad> getPacenf() {
		return pacenf;
	}

	public void setPacenf(List<PacienteEnfermedad> pacenf) {
		this.pacenf = pacenf;
	}

	public List<String> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<String> enfermedades) {
		this.enfermedades = enfermedades;
	}




	private static final long serialVersionUID = 1L;
}
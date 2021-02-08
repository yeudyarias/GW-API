package com.gw.api.Util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gw.api.models.entity.Contacto;
import com.gw.api.models.entity.Factura;

public class ClienteModel implements Serializable {

	private Long id;

	private String identificacion;

	private String nombre;

	private Date fechaNa;

	private Modelo grupoSanguineo;

	private Modelo estadoCivil;

	private Modelo religion;

	private String email;

	private String telefono;

	private Date fechaIn;

	private String direccion;

	private String foto;
	
	private String observacion;

	private Modelo sexo;

	private List<Factura> facturas;

	private List<Contacto> contactos;

	private List<String> enfermedades;

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

	public Modelo getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(Modelo grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public Modelo getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Modelo estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Modelo getReligion() {
		return religion;
	}

	public void setReligion(Modelo religion) {
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

	public Modelo getSexo() {
		return sexo;
	}

	public void setSexo(Modelo sexo) {
		this.sexo = sexo;
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

	public List<String> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<String> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	private static final long serialVersionUID = 1L;

}

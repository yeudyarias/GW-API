package com.gw.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "persona")
public class GWPersona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false)
	private String apellidos;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String identificacion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, name="tipo_identificacion")
	private String tipoIdentificacion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, name= "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false, unique = false)
	private String email;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 10, max = 45, message = "el tamaño tiene que estar entre 10 y 45")
	@Column(nullable = false)
	private String direccion;
	
	@NotEmpty(message = "no puede estar vacio")	
	@Column(nullable = false)
	private String sexo;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 1, max = 2)
	@Column(nullable = false)
	private String estadoCivil;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 8, max = 15, message = "el tamaño tiene que estar entre 8 y 15")
	@Column(nullable = false)
	private String telefono;
	
	@JsonBackReference
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private GWEmpleado empleado;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public GWEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(GWEmpleado empleado) {
		this.empleado = empleado;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

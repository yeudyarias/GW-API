package com.gw.api.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sexo")
public class Sexo implements Serializable {
	
	@Id
	private char code;
	
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getCode() {
		return code;
	}
	public void setCode(char code) {
		this.code = code;
	}
	
	private static final long serialVersionUID = 1L;
	
}

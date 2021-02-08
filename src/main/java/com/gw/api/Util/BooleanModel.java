package com.gw.api.Util;

import java.io.Serializable;

public class BooleanModel  implements Serializable {

	private String estado;

	private String name;

	
	public BooleanModel(String estado, String name) {
		super();
		this.estado = estado;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}

package com.gw.api.Util;

import java.io.Serializable;

public class Modelo implements Serializable {

	private String code;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private static final long serialVersionUID = 1L;
}

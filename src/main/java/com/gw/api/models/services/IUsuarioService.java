package com.gw.api.models.services;

import com.gw.api.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}

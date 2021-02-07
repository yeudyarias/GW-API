package com.longiara.api.models.services;

import com.longiara.api.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}

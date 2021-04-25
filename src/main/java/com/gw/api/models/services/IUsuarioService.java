package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gw.api.models.entity.Role;
import com.gw.api.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

	public Usuario findByEmail(String email);
		

	Usuario loadUserByEmail(String email) throws UsernameNotFoundException;

	public Usuario save(Usuario usuario);
	
	public List<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public Usuario findById(Long id);
	
	public List<Role> getRoles(Long id);

	public void delete(Long id);

}

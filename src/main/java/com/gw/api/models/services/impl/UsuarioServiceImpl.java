package com.gw.api.models.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IUsuarioDao;
import com.gw.api.models.entity.GWPersona;
import com.gw.api.models.entity.Role;
import com.gw.api.models.entity.Usuario;
import com.gw.api.models.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException(
					"Error en el login: no existe el usuario '" + username + "' en el sistema!");
		}
		if (!usuario.getEnabled()) {
			logger.error("Error en el login: el usuario '" + username + "' se encuentra  deshabilitado!");
			throw new DisabledException(
					"Error en el login: el usuario '" + username + "' se encuentra deshabilitado!");
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getCodigo()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario loadUserByEmail(String email) throws UsernameNotFoundException {

		GWPersona persona = usuarioDao.findByEmail(email);
		Usuario usuario = persona.getEmpleado().getUsuario();

		if (usuario == null) {
			logger.error("Error en el login: no existe usuario en el sistema con el email '" + email + "'!");
			throw new UsernameNotFoundException(
					"Error en el login: no existe usuario en el sistema con el email '" + email + "'!");
		}

		return usuario;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario findByEmail(String email) {
		GWPersona p = usuarioDao.findByEmail(email);
		return p.getEmpleado().getUsuario();
	}

	@Override
	@Transactional
	public Usuario save(Usuario pais) {
		return usuarioDao.save(pais);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByIdEmpleado(Long id) {
		return usuarioDao.findByIdEmpleado(id);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {		
		Page<Usuario> l = usuarioDao.findAll(pageable);
		System.out.print("Existen: "+l.getSize());
		return l;
	}

	@Override
	public List<Role> getRoles(Long id) {
		return usuarioDao.getRoles(id);

	}

}

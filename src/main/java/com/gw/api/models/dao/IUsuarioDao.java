package com.gw.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gw.api.models.entity.GWPersona;
import com.gw.api.models.entity.Role;
import com.gw.api.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
	
	@Query("select u from GWPersona u where u.email=?1")
	public GWPersona findByEmail(String email);
	
	@Query("select r from Role r where r.id in (select u.role_id from UsuariosRoles u where u.role_id = r.id and u.usuario_id = ?1)")
	public List<Role> getRoles(Long idUsuario);
	

}

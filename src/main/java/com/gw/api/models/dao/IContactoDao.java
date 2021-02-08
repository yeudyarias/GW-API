package com.gw.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gw.api.models.entity.Contacto;

public interface IContactoDao  extends JpaRepository<Contacto, Long>{

	@Query("from Contacto where cliente_id = ?1")	
	public List<Contacto> findContactosCliente(Long id);
}

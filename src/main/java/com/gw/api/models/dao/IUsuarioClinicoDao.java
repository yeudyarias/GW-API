package com.gw.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gw.api.models.entity.Cliente;
import com.gw.api.models.entity.Enfermedad;
import com.gw.api.models.entity.Region;

public interface IUsuarioClinicoDao extends JpaRepository<Cliente, Long>{

	@Query("from Region")
	public List<Region> findAllRegiones();
	
	@Query("from Enfermedad")
	public List<Enfermedad> findAllEnfermedades();
	
}


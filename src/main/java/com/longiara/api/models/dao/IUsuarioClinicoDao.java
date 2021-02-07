package com.longiara.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.longiara.api.models.entity.Region;
import com.longiara.api.models.entity.UsuarioClinico;

public interface IUsuarioClinicoDao extends JpaRepository<UsuarioClinico, Long>{

	@Query("from Region")
	public List<Region> findAllRegiones();
	
}


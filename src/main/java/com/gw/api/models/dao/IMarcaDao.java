package com.gw.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.api.models.entity.GWMarca;

public interface IMarcaDao extends JpaRepository<GWMarca, Long>{
}

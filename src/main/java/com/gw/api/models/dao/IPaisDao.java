package com.gw.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.api.models.entity.GWPais;

public interface IPaisDao extends JpaRepository<GWPais, Long>{
}

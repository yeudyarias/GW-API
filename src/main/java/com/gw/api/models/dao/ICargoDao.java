package com.gw.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.api.models.entity.GWCargo;

public interface ICargoDao extends JpaRepository<GWCargo, Long>{
}

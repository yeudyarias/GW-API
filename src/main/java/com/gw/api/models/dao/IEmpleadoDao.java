package com.gw.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.api.models.entity.GWEmpleado;

public interface IEmpleadoDao  extends  JpaRepository<GWEmpleado, Long>{

}

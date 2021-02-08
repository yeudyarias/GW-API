package com.gw.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gw.api.models.entity.Empleado;

public interface IEmpleadoDao  extends CrudRepository<Empleado, Long>{

}

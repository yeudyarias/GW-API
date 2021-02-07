package com.longiara.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.longiara.api.models.entity.Empleado;

public interface IEmpleadoDao  extends CrudRepository<Empleado, Long>{

}

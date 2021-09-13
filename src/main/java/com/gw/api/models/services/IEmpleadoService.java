package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.Empleado;
import com.gw.api.models.entity.GWEmpleado;

public interface IEmpleadoService {


	public List<GWEmpleado> findAll();

	public Page<GWEmpleado> findAll(Pageable pageable);
	
	public GWEmpleado findById(Long id);

	public GWEmpleado save(GWEmpleado empleado);

	public void delete(Long id);
}

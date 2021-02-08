package com.gw.api.models.services;

import java.util.List;

import com.gw.api.models.entity.Especialidad;

public interface IEspecialidadService {

	public List<Especialidad> findAll();
	
	public Especialidad findById(Long id);
	
	public Especialidad save(Especialidad especialidad);
	
	public void delete(Long id);
}

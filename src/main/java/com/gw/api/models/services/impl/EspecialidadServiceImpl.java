package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IEspecialidadDao;
import com.gw.api.models.entity.Especialidad;
import com.gw.api.models.services.IEspecialidadService;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadDao especialidadDao;

	@Override
	@Transactional(readOnly = true)
	public List<Especialidad> findAll() {
		return (List<Especialidad>) especialidadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Especialidad findById(Long id) {
		return especialidadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Especialidad save(Especialidad especialidad) {
		return especialidadDao.save(especialidad);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		especialidadDao.deleteById(id);
	}


}

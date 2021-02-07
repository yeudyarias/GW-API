package com.longiara.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longiara.api.models.dao.IEmpleadoDao;
import com.longiara.api.models.entity.Empleado;
import com.longiara.api.models.services.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado usuarioClinico) {
		return empleadoDao.save(usuarioClinico);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empleadoDao.deleteById(id);
	}

}

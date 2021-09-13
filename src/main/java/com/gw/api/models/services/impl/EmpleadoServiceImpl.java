package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IEmpleadoDao;
import com.gw.api.models.entity.GWEmpleado;
import com.gw.api.models.services.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<GWEmpleado> findAll() {
		return (List<GWEmpleado>) empleadoDao.findAll();
	}
	
	@Override
	public Page<GWEmpleado> findAll(Pageable pageable) {		
		Page<GWEmpleado> l = empleadoDao.findAll(pageable);
		System.out.print("Existen: "+l.getSize());
		return l;
	}

	@Override
	@Transactional(readOnly = true)
	public GWEmpleado findById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public GWEmpleado save(GWEmpleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empleadoDao.deleteById(id);
	}

}

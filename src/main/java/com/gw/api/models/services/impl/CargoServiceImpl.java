package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.ICargoDao;
import com.gw.api.models.entity.GWCargo;
import com.gw.api.models.services.ICargoService;

@Service
public class CargoServiceImpl implements ICargoService {

	@Autowired
	private ICargoDao cargoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<GWCargo> findAll() {
		return (List<GWCargo>) cargoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public GWCargo findById(Long id) {
		return cargoDAO.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Page<GWCargo> findAll(Pageable pageable) {
		return cargoDAO.findAll(pageable);
	}

	@Override
	@Transactional
	public GWCargo save(GWCargo cargo) {
		return cargoDAO.save(cargo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cargoDAO.deleteById(id);
	}

}
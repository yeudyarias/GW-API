package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IMarcaDao;
import com.gw.api.models.entity.GWMarca;
import com.gw.api.models.services.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private IMarcaDao marcaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<GWMarca> findAll() {
		return (List<GWMarca>) marcaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public GWMarca findById(Long id) {
		return marcaDAO.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Page<GWMarca> findAll(Pageable pageable) {
		return marcaDAO.findAll(pageable);
	}

	@Override
	@Transactional
	public GWMarca save(GWMarca marca) {
		return marcaDAO.save(marca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		marcaDAO.deleteById(id);
	}

}

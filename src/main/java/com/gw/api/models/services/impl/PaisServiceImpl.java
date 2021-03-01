package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IPaisDao;
import com.gw.api.models.entity.GWPais;
import com.gw.api.models.services.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {

	@Autowired
	private IPaisDao paisDAO;

	@Override
	@Transactional(readOnly = true)
	public List<GWPais> findAll() {
		return (List<GWPais>) paisDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public GWPais findById(Long id) {
		return paisDAO.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Page<GWPais> findAll(Pageable pageable) {
		return paisDAO.findAll(pageable);
	}

	@Override
	@Transactional
	public GWPais save(GWPais pais) {
		return paisDAO.save(pais);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		paisDAO.deleteById(id);
	}

}

package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IContactoDao;
import com.gw.api.models.entity.Contacto;
import com.gw.api.models.services.IContactoService;

@Service
public class ContactoServiceImpl implements IContactoService {

	
	@Autowired
	private IContactoDao contactoDao;
	
	@Override
	@Transactional
	public Contacto save(Contacto contacto) {
		return contactoDao.save(contacto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		contactoDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Contacto findById(Long id) {
		return contactoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contacto> listaContactosCliente(Long id) {
		return contactoDao.findContactosCliente(id);
	}
}

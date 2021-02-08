package com.gw.api.models.services;

import java.util.List;

import com.gw.api.models.entity.Contacto;

public interface IContactoService {

	public Contacto save(Contacto contacto);

	public void delete(Long id);
	
	public Contacto findById(Long id);
	
	public List<Contacto> listaContactosCliente(Long id);
}

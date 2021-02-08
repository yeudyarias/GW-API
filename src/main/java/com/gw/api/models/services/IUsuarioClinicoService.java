package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.Cliente;
import com.gw.api.models.entity.Enfermedad;
import com.gw.api.models.entity.Factura;
import com.gw.api.models.entity.Producto;
import com.gw.api.models.entity.Region;

public interface IUsuarioClinicoService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public Cliente findById(Long id);

	public Cliente save(Cliente usuarioClinico);

	public void delete(Long id);

	public List<Region> findAllRegiones();
	
	public List<Enfermedad> findAllEnfermedades();

	public Factura findFacturaById(Long id);

	public Factura saveFactura(Factura factura);

	public void deleteFacturaById(Long id);

	public List<Producto> findProductoByNombre(String term);
	
	public void deleteEnfermedad(Long id);

}

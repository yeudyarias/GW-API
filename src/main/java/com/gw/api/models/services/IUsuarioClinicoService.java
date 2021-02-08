package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.Factura;
import com.gw.api.models.entity.Producto;
import com.gw.api.models.entity.Region;
import com.gw.api.models.entity.UsuarioClinico;

public interface IUsuarioClinicoService {

	public List<UsuarioClinico> findAll();

	public Page<UsuarioClinico> findAll(Pageable pageable);

	public UsuarioClinico findById(Long id);

	public UsuarioClinico save(UsuarioClinico usuarioClinico);

	public void delete(Long id);

	public List<Region> findAllRegiones();

	public Factura findFacturaById(Long id);

	public Factura saveFactura(Factura factura);

	public void deleteFacturaById(Long id);

	public List<Producto> findProductoByNombre(String term);

}

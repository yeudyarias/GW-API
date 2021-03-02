package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.GWMarca;

public interface IMarcaService {

	public List<GWMarca> findAll();

	public Page<GWMarca> findAll(Pageable pageable);

	public GWMarca findById(Long id);

	public GWMarca save(GWMarca marca);

	public void delete(Long id);
}

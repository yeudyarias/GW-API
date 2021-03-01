package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.GWPais;

public interface IPaisService {

	public List<GWPais> findAll();

	public Page<GWPais> findAll(Pageable pageable);

	public GWPais findById(Long id);

	public GWPais save(GWPais pais);

	public void delete(Long id);
}

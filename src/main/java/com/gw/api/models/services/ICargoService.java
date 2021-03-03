package com.gw.api.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gw.api.models.entity.GWCargo;

public interface ICargoService {

	public List<GWCargo> findAll();

	public Page<GWCargo> findAll(Pageable pageable);

	public GWCargo findById(Long id);

	public GWCargo save(GWCargo cargo);

	public void delete(Long id);
}


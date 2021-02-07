package com.longiara.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.longiara.api.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}

package com.longiara.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longiara.api.models.dao.IFacturaDao;
import com.longiara.api.models.dao.IProductoDao;
import com.longiara.api.models.dao.IUsuarioClinicoDao;
import com.longiara.api.models.entity.Factura;
import com.longiara.api.models.entity.Producto;
import com.longiara.api.models.entity.Region;
import com.longiara.api.models.entity.UsuarioClinico;
import com.longiara.api.models.services.IUsuarioClinicoService;

@Service
public class UsuarioClinicoServiceImpl implements IUsuarioClinicoService {

		@Autowired
		private IUsuarioClinicoDao usuarioClinicoDao;
		
		@Autowired
		private IFacturaDao facturaDao;
		
		@Autowired
		private IProductoDao productoDao;

		@Override
		@Transactional(readOnly = true)
		public List<UsuarioClinico> findAll() {
			return (List<UsuarioClinico>) usuarioClinicoDao.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Page<UsuarioClinico> findAll(Pageable pageable) {
			return usuarioClinicoDao.findAll(pageable);
		}
		
		@Override
		@Transactional(readOnly = true)
		public UsuarioClinico findById(Long id) {
			return usuarioClinicoDao.findById(id).orElse(null);
		}

		@Override
		@Transactional
		public UsuarioClinico save(UsuarioClinico cliente) {
			return usuarioClinicoDao.save(cliente);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			usuarioClinicoDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public List<Region> findAllRegiones() {
			return usuarioClinicoDao.findAllRegiones();
		}

		@Override
		@Transactional(readOnly = true)
		public Factura findFacturaById(Long id) {
			return facturaDao.findById(id).orElse(null);
		}

		@Override
		@Transactional
		public Factura saveFactura(Factura factura) {
			return facturaDao.save(factura);
		}

		@Override
		@Transactional
		public void deleteFacturaById(Long id) {
			facturaDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public List<Producto> findProductoByNombre(String term) {
			return productoDao.findByNombreContainingIgnoreCase(term);
		}

	}

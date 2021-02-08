package com.gw.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.api.models.dao.IFacturaDao;
import com.gw.api.models.dao.IPacienteEnfermedadDao;
import com.gw.api.models.dao.IProductoDao;
import com.gw.api.models.dao.IUsuarioClinicoDao;
import com.gw.api.models.entity.Cliente;
import com.gw.api.models.entity.Enfermedad;
import com.gw.api.models.entity.Factura;
import com.gw.api.models.entity.Producto;
import com.gw.api.models.entity.Region;
import com.gw.api.models.services.IUsuarioClinicoService;

@Service
public class UsuarioClinicoServiceImpl implements IUsuarioClinicoService {

		@Autowired
		private IUsuarioClinicoDao usuarioClinicoDao;
		
		@Autowired
		private IPacienteEnfermedadDao pacienteEnfermedadDao;
		
		@Autowired
		private IFacturaDao facturaDao;
		
		@Autowired
		private IProductoDao productoDao;

		@Override
		@Transactional(readOnly = true)
		public List<Cliente> findAll() {
			return (List<Cliente>) usuarioClinicoDao.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Page<Cliente> findAll(Pageable pageable) {
			return usuarioClinicoDao.findAll(pageable);
		}
		
		@Override
		@Transactional(readOnly = true)
		public Cliente findById(Long id) {
			return usuarioClinicoDao.findById(id).orElse(null);
		}

		@Override
		@Transactional
		public Cliente save(Cliente cliente) {
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
		public List<Enfermedad> findAllEnfermedades() {
			return usuarioClinicoDao.findAllEnfermedades();
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
		@Transactional
		public void deleteEnfermedad(Long id) {
			pacienteEnfermedadDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public List<Producto> findProductoByNombre(String term) {
			return productoDao.findByNombreContainingIgnoreCase(term);
		}

	}

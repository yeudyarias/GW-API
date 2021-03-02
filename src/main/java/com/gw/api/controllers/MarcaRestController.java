package com.gw.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gw.api.models.entity.GWMarca;
import com.gw.api.models.services.IMarcaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/marca")
public class MarcaRestController {

	@Autowired
	private IMarcaService marcaService;

	@GetMapping("/marcas")
	public List<GWMarca> index() {
		return marcaService.findAll();
	}

	@GetMapping("/marcas/page/{page}")
	public Page<GWMarca> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return marcaService.findAll(pageable);
	}

	@GetMapping("/marcas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		GWMarca marca = null;
		Map<String, Object> response = new HashMap<>();

		try {
			marca = marcaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (marca == null) {
			response.put("mensaje", "ID de marca es: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<GWMarca>(marca, HttpStatus.OK);
	}

	@PostMapping("/marcas")
	public ResponseEntity<?> create(@Valid @RequestBody GWMarca marca, BindingResult result) {

		GWMarca marcaNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			marcaNew = marcaService.save(marca);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Marca creada con éxito!");
		response.put("empleado", marcaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/marcas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody GWMarca marca, BindingResult result, @PathVariable Long id) {

		GWMarca marcaActual = marcaService.findById(id);

		GWMarca marcaUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (marcaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la marca ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			marcaActual.setDescripcion(marca.getDescripcion());
			marcaActual.setNombre(marca.getNombre());

			marcaUpdated = marcaService.save(marcaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la marca en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La Marca ha sido actualizado con éxito!");
		response.put("Marca", marcaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/marcas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			marcaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la marca de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Marca eliminada con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
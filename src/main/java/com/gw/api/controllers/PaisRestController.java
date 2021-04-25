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

import com.gw.api.models.entity.GWPais;
import com.gw.api.models.services.IPaisService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/pais")
public class PaisRestController {

	@Autowired
	private IPaisService paisService;

	@GetMapping("/paises")
	public List<GWPais> index() {
		return paisService.findAll();
	}

	@GetMapping("/paises/page/{page}")
	public Page<GWPais> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return paisService.findAll(pageable);
	}

	@GetMapping("/paises/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		GWPais pais = null;
		Map<String, Object> response = new HashMap<>();

		try {
			pais = paisService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (pais == null) {
			response.put("mensaje", "El pais ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<GWPais>(pais, HttpStatus.OK);
	}

	@PostMapping("/paises")
	public ResponseEntity<?> create(@Valid @RequestBody GWPais pais, BindingResult result) {

		GWPais paisNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			paisNew = paisService.save(pais);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El pais ha sido creado con éxito!");
		response.put("empleado", paisNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/paises/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody GWPais pais, BindingResult result, @PathVariable Long id) {

		GWPais paisActual = paisService.findById(id);

		GWPais paisUpdated = null;

		Map<String, Object> response = new HashMap<>(); 

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (paisActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el pais ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			paisActual.setDescripcion(pais.getDescripcion());
			paisActual.setNombre(pais.getNombre());

			paisUpdated = paisService.save(paisActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el pais en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El pais ha sido actualizado con éxito!");
		response.put("pais", paisUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/paises/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			paisService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el pais de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Pais eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

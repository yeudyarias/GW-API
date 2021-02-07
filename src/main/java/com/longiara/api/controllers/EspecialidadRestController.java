package com.longiara.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.longiara.api.models.entity.Especialidad;
import com.longiara.api.models.services.IEspecialidadService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/esp")
public class EspecialidadRestController {

	@Autowired
	private IEspecialidadService especialidadService;

	@GetMapping("/especialidad")
	public List<Especialidad> index() {
		return especialidadService.findAll();
	}
	
	@GetMapping("/especialidads/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Especialidad especialidad = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			especialidad = especialidadService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(especialidad == null) {
			response.put("mensaje", "La especialidad ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Especialidad>(especialidad, HttpStatus.OK);
	}
	
	@PostMapping("/especialidad")
	public ResponseEntity<?> create(@Valid @RequestBody Especialidad especialidad, BindingResult result) {
		
		Especialidad especialidadNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			especialidadNew = especialidadService.save(especialidad);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La especialidad ha sido creado con éxito!");
		response.put("especialidad", especialidadNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/especialidad/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Especialidad especialidad, BindingResult result, @PathVariable Long id) {

		Especialidad especialidadActual = especialidadService.findById(id);

		Especialidad especialidadUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (especialidadActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el especialidad ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {			
			especialidadActual.setNombre(especialidad.getNombre());			
			especialidadUpdated = especialidadService.save(especialidadActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la especialidad en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La especialidad ha sido actualizado con éxito!");
		response.put("especialidad", especialidadUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/especialidad/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    especialidadService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la especialidad de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La especialidad eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

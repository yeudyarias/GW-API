package com.gw.api.controllers;

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

import com.gw.api.models.entity.UsuarioClinico;
import com.gw.api.models.services.IUsuarioClinicoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioClinicoRestController {

	@Autowired
	private IUsuarioClinicoService usuarioClinicoService;

	@GetMapping("/usuarioClinicos")
	public List<UsuarioClinico> index() {
		return usuarioClinicoService.findAll();
	}
	
	@GetMapping("/usuarioClinicos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		UsuarioClinico usuarioClinico = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			usuarioClinico = usuarioClinicoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(usuarioClinico == null) {
			response.put("mensaje", "El usuarioClinico ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UsuarioClinico>(usuarioClinico, HttpStatus.OK);
	}
	
	@PostMapping("/usuarioClinicos")
	public ResponseEntity<?> create(@Valid @RequestBody UsuarioClinico usuarioClinico, BindingResult result) {
		
		UsuarioClinico usuarioClinicoNew = null;
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
			usuarioClinicoNew = usuarioClinicoService.save(usuarioClinico);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuarioClinico ha sido creado con éxito!");
		response.put("usuarioClinico", usuarioClinicoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarioClinicos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody UsuarioClinico usuarioClinico, BindingResult result, @PathVariable Long id) {

		UsuarioClinico usuarioClinicoActual = usuarioClinicoService.findById(id);

		UsuarioClinico usuarioClinicoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuarioClinicoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuarioClinico ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			usuarioClinicoActual.setApellido(usuarioClinico.getApellido());
			usuarioClinicoActual.setNombre(usuarioClinico.getNombre());
			usuarioClinicoActual.setEmail(usuarioClinico.getEmail());
			usuarioClinicoActual.setCreateAt(usuarioClinico.getCreateAt());

			usuarioClinicoUpdated = usuarioClinicoService.save(usuarioClinicoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuarioClinico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuarioClinico ha sido actualizado con éxito!");
		response.put("usuarioClinico", usuarioClinicoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarioClinicos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    usuarioClinicoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuarioClinico de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuarioClinico eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

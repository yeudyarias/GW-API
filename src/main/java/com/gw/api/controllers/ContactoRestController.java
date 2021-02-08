package com.gw.api.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

import com.gw.api.models.entity.Contacto;
import com.gw.api.models.services.IContactoService;
import com.gw.api.models.services.IUsuarioClinicoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ContactoRestController {

	@Autowired
	private IContactoService contactoService;
	
	@Autowired
	private IUsuarioClinicoService usuarioClinicoService;
	
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/contactos/{id}")
	public ResponseEntity<?> create(@Valid @RequestBody Contacto contacto, BindingResult result, @PathVariable Long id) {
		
		Contacto contactoNew = null;
		Map<String, Object> response = new HashMap<>();
		 
		if(result.hasErrors()) { Hola

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			contacto.setCliente(usuarioClinicoService.findById(id));
			contacto.setFechaIn(new Date());
			contactoNew = contactoService.save(contacto);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El contacto ha sido creado con éxito!");
		response.put("contacto", contactoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/contactos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Contacto contacto, BindingResult result, @PathVariable Long id) {

		Contacto contactoActual = contactoService.findById(id);

		Contacto contactoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (contactoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el contacto ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {			
			contactoActual.setEmail(contacto.getEmail());
			contactoActual.setNombre(contacto.getNombre());
			contactoActual.setParentesco(contacto.getParentesco());
			contactoActual.setTelefono(contacto.getTelefono());

			contactoUpdated = contactoService.save(contactoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el contacto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El contacto ha sido actualizado con éxito!");
		response.put("contacto", contactoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/contactos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {	
			contactoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el contacto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El contacto eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/contactos/cliente/{id}")
	public List<Contacto> listaContactosCliente(@PathVariable Long id){
		return contactoService.listaContactosCliente(id);
	}
}

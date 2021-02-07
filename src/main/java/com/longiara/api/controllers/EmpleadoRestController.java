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

import com.longiara.api.models.entity.Empleado;
import com.longiara.api.models.services.IEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/esp")
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping("/empleados")
	public List<Empleado> index() {
		return empleadoService.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Empleado empleado = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			empleado = empleadoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(empleado == null) {
			response.put("mensaje", "El empleado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<?> create(@Valid @RequestBody Empleado empleado, BindingResult result) {
		
		Empleado empleadoNew = null;
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
			empleadoNew = empleadoService.save(empleado);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El empleado ha sido creado con éxito!");
		response.put("empleado", empleadoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id) {

		Empleado empleadoActual = empleadoService.findById(id);

		Empleado empleadoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (empleadoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el empleado ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			empleadoActual.setEmail(empleado.getEmail());
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setIdentificacion(empleado.getIdentificacion());
			empleadoActual.setEstadoCivil(empleado.getEstadoCivil());
			empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
			empleadoActual.setIdEspecialidad(empleado.getIdEspecialidad());
			empleadoActual.setSexo(empleado.getSexo());
			empleadoActual.setTelefono(empleado.getTelefono());

			empleadoUpdated = empleadoService.save(empleadoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el empleado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El empleado ha sido actualizado con éxito!");
		response.put("empleado", empleadoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    empleadoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el empleado de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El empleado eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
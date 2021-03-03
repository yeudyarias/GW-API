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

import com.gw.api.models.entity.GWCargo;
import com.gw.api.models.services.ICargoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/cargo")
public class CargoRestController {

	@Autowired
	private ICargoService cargoService;

	@GetMapping("/cargos")
	public List<GWCargo> index() {
		return cargoService.findAll();
	}

	@GetMapping("/cargos/page/{page}")
	public Page<GWCargo> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return cargoService.findAll(pageable);
	}

	@GetMapping("/cargos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		GWCargo cargo = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cargo = cargoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cargo == null) {
			response.put("mensaje", "ID de cargo es: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<GWCargo>(cargo, HttpStatus.OK);
	}

	@PostMapping("/cargos")
	public ResponseEntity<?> create(@Valid @RequestBody GWCargo cargo, BindingResult result) {

		GWCargo cargoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			cargoNew = cargoService.save(cargo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Cargo creada con éxito!");
		response.put("empleado", cargoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/cargos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody GWCargo cargo, BindingResult result, @PathVariable Long id) {

		GWCargo cargoActual = cargoService.findById(id);

		GWCargo cargoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (cargoActual == null) {
			response.put("mensaje", "Error: no se pudo editar el ID del cargo: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			cargoActual.setDescripcion(cargo.getDescripcion());
			cargoActual.setNombre(cargo.getNombre());

			cargoUpdated = cargoService.save(cargoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cargo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cargo ha sido actualizado con éxito!");
		response.put("Cargo", cargoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/cargos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			cargoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el cargo de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Cargo eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
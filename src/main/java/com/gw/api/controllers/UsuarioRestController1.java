package com.gw.api.controllers;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gw.api.Util.EmailUtil;
import com.gw.api.models.entity.Usuario;
import com.gw.api.models.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController1 {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnoder;
	
	@GetMapping("/usuarios")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}

	@PutMapping("/usuarios")
	public ResponseEntity<?> updatePassword(
			@Valid @RequestBody Usuario user, BindingResult result) {

		Usuario usuarioUpdated = null;
		Usuario usuario = usuarioService.findByEmail(user.getEmail());
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (usuario == null) {
				response.put("mensaje", "Error: Usuario con el correo indicado ("
						.concat(user.getEmail().concat(") no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); 			
		}

		try {

			String newPassword = generateRandomPassword(10);
			String passwordEncripted = passwordEnoder.encode(newPassword);
			usuario.setPassword(passwordEncripted);
			usuarioUpdated = usuarioService.save(usuario);
			EmailUtil.recuperarContrasenna(newPassword, usuarioUpdated);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la contraseña");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Contraseña enviada exitosamente al correo "+usuarioUpdated.getEmail());		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
		

	// Method to generate a random alphanumeric password of a specific length
	public static String generateRandomPassword(int len) {
		// ASCII range – alphanumeric (0-9, a-z, A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		// each iteration of the loop randomly chooses a character from the given
		// ASCII range and appends it to the `StringBuilder` instance

		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

}

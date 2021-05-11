package com.gw.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController1 {

//	@Autowired
//	private IUsuarioService usuarioService;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEnoder;
//	
//	@GetMapping("/usuarios")
//	public List<Usuario> index() {
//		return usuarioService.findAll();
//	}
//
//	@PutMapping("/usuarios")
//	public ResponseEntity<?> updatePassword(
//			@Valid @RequestBody Usuario user, BindingResult result) {
//
//		Usuario usuarioUpdated = null;
//		Usuario usuario = usuarioService.findByEmail(user.getEmail());
//		Map<String, Object> response = new HashMap<>();
//		
//		if (result.hasErrors()) {
//
//			List<String> errors = result.getFieldErrors().stream()
//					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
//					.collect(Collectors.toList());
//
//			response.put("errors", errors);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//		}
//
//		if (usuario == null) {
//				response.put("mensaje", "Error: Usuario con el correo indicado ("
//						.concat(user.getEmail().concat(") no existe en la base de datos!")));
//				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); 			
//		}
//
//		try {
//
//			String newPassword = generateRandomPassword(10);
//			String passwordEncripted = passwordEnoder.encode(newPassword);
//			usuario.setPassword(passwordEncripted);
//			usuarioUpdated = usuarioService.save(usuario);
//			EmailUtil.recuperarContrasenna(newPassword, usuarioUpdated);
//
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al actualizar la contraseña");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response.put("mensaje", "Contraseña enviada exitosamente al correo "+usuarioUpdated.getEmail());		
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
//	}
//		
//
//	// Method to generate a random alphanumeric password of a specific length
//	public static String generateRandomPassword(int len) {
//		// ASCII range – alphanumeric (0-9, a-z, A-Z)
//		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//
//		SecureRandom random = new SecureRandom();
//		StringBuilder sb = new StringBuilder();
//
//		// each iteration of the loop randomly chooses a character from the given
//		// ASCII range and appends it to the `StringBuilder` instance
//
//		for (int i = 0; i < len; i++) {
//			int randomIndex = random.nextInt(chars.length());
//			sb.append(chars.charAt(randomIndex));
//		}
//
//		return sb.toString();
//	}

}

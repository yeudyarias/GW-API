package com.gw.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioClinicoRestController {

//	@Autowired
//	private IUsuarioClinicoService usuarioClinicoService;
//	
//	@Autowired
//	private IUploadFileService uploadService;
//	
//	// private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
//
//	@GetMapping("/clientes")
//	public List<Cliente> index() {
//		return usuarioClinicoService.findAll();
//	}
//	
//	@GetMapping("/clientes/page/{page}")
//	public Page<Cliente> index(@PathVariable Integer page) {
//		Pageable pageable = PageRequest.of(page, 10);
//		return usuarioClinicoService.findAll(pageable);
//	}
//	
//	@Secured({"ROLE_ADMIN", "ROLE_USER"})
//	@GetMapping("/clientes/{id}")
//	public ResponseEntity<?> show(@PathVariable Long id) {
//		
//		Cliente cliente = null;
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			cliente = usuarioClinicoService.findById(id);
//		} catch(DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		if(cliente == null) {
//			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		ClienteModel clienteModel = UtilModel.convertirCliente(cliente);
//		
//		return new ResponseEntity<ClienteModel>(clienteModel, HttpStatus.OK);
//	}
//	
//	@Secured("ROLE_ADMIN")
//	@PostMapping("/clientes")
//	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
//				
//		Cliente clienteNew = null;
//		Map<String, Object> response = new HashMap<>();		
//		cliente.setPacenf(UtilModel.setEnfermedades(cliente.getEnfermedades(), listarEnfermedades()));
//		cliente.setFechaIn(new Date());	
//		if(result.hasErrors()) {
//
//			List<String> errors = result.getFieldErrors()
//					.stream()
//					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
//					.collect(Collectors.toList());
//			
//			response.put("errors", errors);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//		}
//		
//		try {								
//			clienteNew = usuarioClinicoService.save(cliente);
//		} catch(DataAccessException e) {
//			response.put("mensaje", "Error al realizar el insert en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		response.put("mensaje", "El cliente ha sido creado con éxito!");
//		response.put("cliente", clienteNew);
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//	
//	@Secured("ROLE_ADMIN")
//	@PutMapping("/clientes/{id}")
//	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
//
//		Cliente clienteActual = usuarioClinicoService.findById(id);
//
//		Cliente clienteUpdated = null;
//
//		Map<String, Object> response = new HashMap<>();
//
//		if(result.hasErrors()) {
//
//			List<String> errors = result.getFieldErrors()
//					.stream()
//					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
//					.collect(Collectors.toList());
//			
//			response.put("errors", errors);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//		}
//		
//		if (clienteActual == null) {
//			response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
//					.concat(id.toString().concat(" no existe en la base de datos!")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//
//		try {
//
//			clienteActual.setIdentificacion(cliente.getIdentificacion());
//			clienteActual.setNombre(cliente.getNombre());
//			clienteActual.setFechaNa(cliente.getFechaNa());
//			clienteActual.setSexo(cliente.getSexo());
//			clienteActual.setGrupoSanguineo(cliente.getGrupoSanguineo());
//			clienteActual.setEstadoCivil(cliente.getEstadoCivil());
//			clienteActual.setReligion(cliente.getReligion());
//			clienteActual.setEmail(cliente.getEmail());
//			clienteActual.setTelefono(cliente.getTelefono());
//			clienteActual.setDireccion(cliente.getDireccion());				
//			clienteActual.setObservacion(cliente.getObservacion());
//			clienteActual.setFechaIn(cliente.getFechaIn());
//			clienteActual.setFoto(cliente.getFoto());
//			clienteActual.setContactos(cliente.getContactos());		
//			clienteActual.setFacturas(cliente.getFacturas());							
//			clienteActual.setPacenf(UtilModel.setEnfermedades(cliente.getEnfermedades(), listarEnfermedades()));
//			clienteUpdated = usuarioClinicoService.save(clienteActual);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al actualizar el paciente en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response.put("mensaje", "El paciente ha sido actualizado con éxito!");
//		response.put("cliente", clienteUpdated);
//
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//	
//	@Secured("ROLE_ADMIN")
//	@DeleteMapping("/clientes/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			Cliente usuarioClinico = usuarioClinicoService.findById(id);
//			String nombreFotoAnterior = usuarioClinico.getFoto();
//			
//			uploadService.eliminar(nombreFotoAnterior);
//			
//		    usuarioClinicoService.delete(id);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al eliminar el cliente de la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		response.put("mensaje", "El cliente eliminado con éxito!");
//		
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//	}
//	
//	@Secured({"ROLE_ADMIN", "ROLE_USER"})
//	@PostMapping("/clientes/upload")
//	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
//		Map<String, Object> response = new HashMap<>();
//		
//		Cliente usuarioClinico = usuarioClinicoService.findById(id);
//		
//		if(!archivo.isEmpty()) {
//
//			String nombreArchivo = null;
//			try {
//				nombreArchivo = uploadService.copiar(archivo);
//			} catch (IOException e) {
//				response.put("mensaje", "Error al subir la imagen del cliente");
//				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
//				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//			
//			String nombreFotoAnterior = usuarioClinico.getFoto();
//			
//			uploadService.eliminar(nombreFotoAnterior);
//						
//			usuarioClinico.setFoto(nombreArchivo);
//			
//			usuarioClinicoService.save(usuarioClinico);
//			
//			response.put("cliente", usuarioClinico);
//			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
//			
//		}
//		
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//	
////	@GetMapping("/uploads/img/{nombreFoto:.+}")
////	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
////
////		Resource recurso = null;
////		
////		try {
////			recurso = uploadService.cargar(nombreFoto);
////		} catch (MalformedURLException e) {
////			e.printStackTrace();
////		}
////		
////		HttpHeaders cabecera = new HttpHeaders();
////		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
////		
////		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
////	}
//	
//	@Secured("ROLE_ADMIN")
//	@GetMapping("/clientes/regiones")
//	public List<Region> listarRegiones(){
//		return usuarioClinicoService.findAllRegiones();
//	}
//	
//	@Secured("ROLE_ADMIN")
//	@GetMapping("/clientes/enfermedades")
//	public List<Enfermedad> listarEnfermedades(){
//		return usuarioClinicoService.findAllEnfermedades();
//	}
}


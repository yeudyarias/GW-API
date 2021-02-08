package com.gw.api.Util;

import java.util.ArrayList;
import java.util.List;

import com.gw.api.models.entity.Cliente;
import com.gw.api.models.entity.Enfermedad;
import com.gw.api.models.entity.PacienteEnfermedad;

public final class UtilModel {

	public static ClienteModel convertirCliente(Cliente cliente) {
		ClienteModel modelo = new ClienteModel();
		modelo.setDireccion(cliente.getDireccion());
		modelo.setEmail(cliente.getEmail());
		modelo.setEstadoCivil(getEstadoCivil(cliente.getEstadoCivil()));
		modelo.setFacturas(cliente.getFacturas());
		modelo.setFechaIn(cliente.getFechaIn());
		modelo.setFechaNa(cliente.getFechaNa());
		modelo.setFoto(cliente.getFoto());
		modelo.setGrupoSanguineo(getGrupoSanguineo(cliente.getGrupoSanguineo()));
		modelo.setId(cliente.getId());
		modelo.setIdentificacion(cliente.getIdentificacion());
		modelo.setNombre(cliente.getNombre());		
		modelo.setReligion(getReligion(cliente.getReligion()));
		modelo.setSexo(getSexo(cliente.getSexo()));
		modelo.setTelefono(cliente.getTelefono());
		modelo.setContactos(cliente.getContactos());
		modelo.setObservacion(cliente.getObservacion());
		modelo.setEnfermedades(getEnfermedades(cliente.getPacenf()));
		return modelo;

	}

	private static List<String> getEnfermedades(List<PacienteEnfermedad> listaCliente) {
		List<String> result = new ArrayList<String>();

		for (PacienteEnfermedad cliente : listaCliente) {
			result.add(cliente.getEnfermedad().getNombre());
		}

		return result;
	}

	public static List<PacienteEnfermedad> setEnfermedades(List<String> listaSelect, List<Enfermedad> listaEnferdades) {
		List<PacienteEnfermedad> result = new ArrayList<PacienteEnfermedad>();
		for (String select : listaSelect) {
			for (Enfermedad enfermedad : listaEnferdades) {
				if (select.equals(enfermedad.getNombre())) {
					result.add(new PacienteEnfermedad(enfermedad));
				}
			}
		}

		return result;
	}
	
	public static Cliente setClienteData(ClienteModel cliente) {
		Cliente clienteActual  = new Cliente();
		clienteActual.setIdentificacion(cliente.getIdentificacion());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setFechaNa(cliente.getFechaNa());
		clienteActual.setSexo(cliente.getSexo().getCode());
		clienteActual.setGrupoSanguineo(cliente.getGrupoSanguineo().getCode());
		clienteActual.setEstadoCivil(cliente.getEstadoCivil().getCode());
		clienteActual.setReligion(cliente.getReligion().getCode());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setTelefono(cliente.getTelefono());
		clienteActual.setDireccion(cliente.getDireccion());				
		clienteActual.setObservacion(cliente.getObservacion());
		clienteActual.setFechaIn(cliente.getFechaIn());
		clienteActual.setFoto(cliente.getFoto());
		clienteActual.setContactos(cliente.getContactos());		
		clienteActual.setFacturas(cliente.getFacturas());	
		
		return clienteActual;
	}

	private static Modelo getReligion(String ec) {
		Modelo modelo = new Modelo();
		modelo.setCode(ec);
		if (ec.equals("c")) {
			modelo.setName("Católico");
		} else if (ec.equals("e")) {
			modelo.setName("Evangelico");
		} else if (ec.equals("tj")) {
			modelo.setName("Testigo de Jeova");
		} else if (ec.equals("m")) {
			modelo.setName("Musulman");
		} else if (ec.equals("j")) {
			modelo.setName("Judío");
		}

		return modelo;
	}

	private static Modelo getSexo(String ec) {
		Modelo modelo = new Modelo();
		modelo.setCode(ec);
		if (ec.equals("m")) {
			modelo.setName("Masculino");
		} else if (ec.equals("f")) {
			modelo.setName("Femenino");
		}

		return modelo;
	}

	private static Modelo getEstadoCivil(String ec) {
		Modelo modelo = new Modelo();
		modelo.setCode(ec);
		if (ec.equals("s")) {
			modelo.setName("Soltero");
		} else if (ec.equals("c")) {
			modelo.setName("Casado");
		} else if (ec.equals("d")) {
			modelo.setName("Divorciado");
		} else if (ec.equals("v")) {
			modelo.setName("Viudo");
		} else if (ec.equals("ul")) {
			modelo.setName("Unión Libre'");
		}

		return modelo;
	}

	private static Modelo getGrupoSanguineo(String ec) {
		Modelo modelo = new Modelo();
		modelo.setCode(ec);
		if (ec.equals("a+")) {
			modelo.setName("A+");
		} else if (ec.equals("a-")) {
			modelo.setName("A-");
		} else if (ec.equals("b+")) {
			modelo.setName("B+");
		} else if (ec.equals("b-")) {
			modelo.setName("B-");
		} else if (ec.equals("ab+")) {
			modelo.setName("AB+");
		} else if (ec.equals("ab-")) {
			modelo.setName("AB-");
		} else if (ec.equals("o+")) {
			modelo.setName("O+");
		} else if (ec.equals("o-")) {
			modelo.setName("O-");
		}

		return modelo;
	}

}

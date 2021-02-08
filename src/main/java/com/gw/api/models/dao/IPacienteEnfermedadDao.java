package com.gw.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gw.api.models.entity.PacienteEnfermedad;

public interface IPacienteEnfermedadDao  extends JpaRepository<PacienteEnfermedad, Long>{

	
//	@Query(value = "DELETE FROM paciente_enfermedad p WHERE p.cliente_id = :id", nativeQuery = true)
//	public void deleteEnfermedades(@Param("id") Long id);

}

package com.myapp.bricolaje.model.persistency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.Cargo;

@Repository
public interface ICargoDao extends JpaRepository<Cargo, Integer>{
	
	@Query(value = "SELECT c FROM CARGOS c WHERE UPPER(c.descripcion) = ?1")
	List<Cargo> findByDescripcionExacta(String descripcion);
	
	@Query(value = "SELECT c FROM CARGOS c WHERE UPPER(c.descripcion) LIKE %?1%")
	List<Cargo> findByQueContengaDescripcion(String descripcion);
	
	
	Cargo findByDescripcion(String descripcion);
	
}

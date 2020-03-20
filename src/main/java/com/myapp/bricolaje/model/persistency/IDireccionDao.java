package com.myapp.bricolaje.model.persistency;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.Direccion;

@Repository
public interface IDireccionDao extends JpaRepository<Direccion, Integer> {
	
	
	Optional<Direccion> findByCalleAvenida(String calleAvenida);
	
	@Query(value = "SELECT d FROM DIRECCIONES d WHERE d.codigoPostal LIKE %?1%")
	List<Direccion> findByCodigoPostal(int codigoPostal);
	
	@Query(value = "SELECT d FROM DIRECCIONES d WHERE d.localidad LIKE %?1%")
	List<Direccion> findByLocalidad(String localidad);
	
	@Query(value = "SELECT d FROM DIRECCIONES d WHERE d.provincia LIKE %?1%")
	List<Direccion> findByProvincia(String provincia);
	
	@Query(value = "SELECT d FROM DIRECCIONES d WHERE d.calleAvenida LIKE %?1%")
	List<Direccion> findByAllCalleAvenida(String calleAvenida);
	
}

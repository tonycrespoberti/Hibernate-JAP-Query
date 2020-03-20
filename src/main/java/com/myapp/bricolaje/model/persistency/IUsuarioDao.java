/*
 * Author: Tony Crespo - tonycrespo@outlook.com
 * System Engineer, Java Spring MVC, Data, Boot, Cloud Developer
 */
package com.myapp.bricolaje.model.persistency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	//Importante: HQL usa el nombre deL Entity asociado a la clase
	//Usuarios por lo que debemos usar USUARIOS no el nombre de la tabla MySQL
	//Pensamos en entidades y propiedades no en tablas y columnas.
	@Query(value = "SELECT u FROM USUARIOS u WHERE u.idUsuario = ?1 AND u.dni = ?2")
	Usuario findByIdUsuarioAndDni(Long idUsuario, String dni);
	
	
	Usuario findByDni(String dni);
	
	
	@Query(value = "SELECT u FROM USUARIOS u WHERE u.nombres LIKE %?1%")
	List<Usuario> findByNombres(String nombres);
	
	
	@Query(value = "SELECT u FROM USUARIOS u INNER JOIN u.rol r WHERE r.idRol = ?1")
	List<Usuario> findAll();
	
}

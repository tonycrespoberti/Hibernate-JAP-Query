/*
 * Author: Tony Crespo - tonycrespo@outlook.com
 * System Engineer, Java Spring MVC, Data, Boot, Cloud Developer
 */
package com.myapp.bricolaje.model.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.bricolaje.model.repo.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	//Importante: HQL usa el nombre deL Entity asociado a la clase
	//Usuarios por lo que debemos usar USUARIOS no el nombre de la tabla MySQL
	//Pensamos en entidades y propiedades no en tablas y columnas.
	@Query("select u from USUARIOS as u where u.idUsuario = ?1 and u.dni = ?2")
	Usuario findByIdUsuarioAndDni(Long idUsuario, String dni);
}

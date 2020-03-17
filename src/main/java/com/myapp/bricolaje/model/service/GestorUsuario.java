/*
 * Author: Tony Crespo - tonycrespo@outlook.com
 * System Engineer, Java Spring MVC, Data, Boot, Cloud Developer
 */
package com.myapp.bricolaje.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.bricolaje.model.persistency.IUsuarioDao;
import com.myapp.bricolaje.model.repo.Usuario;

@Service
public class GestorUsuario {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	//------------------
	
	/**
	 * Método que gestiona el alta de nuevos usuarios
	 * @param usuario Recibe como parámetro un objeto del tipo Usuario
	 * @return	Devuelve 0 si la persistencia fue exitosa
	 * 			1 si el Id es cero
	 * 			2 si el DNI es nulo
	 * 			3 si el usuario ya existe
	 * 			4 si el Nombre es nulo
	 * 			5 si el Apellido es nulo
	 * 			6 si la Edad es cero
	 * 			7 si el eMail es nulo
	 * 			8 si el Telefono es cero
	 * 			9 si hubo un fallo intentando dar de alta al nuevo usuario
	 */
	public int altaUsuario(Usuario usuario) {
		if (usuario.getIdUsuario() != 0) {
			
			if (usuario.getDni() != null) {
				
				if (buscarUsuario(usuario.getIdUsuario(), usuario.getDni())) {
					
					return 3; //El usuario ya existe
					
				}else {
					
					if (usuario.getNombres() != null) {
						
						if (usuario.getApellidos() != null) {
							
							if (usuario.getEdad() != 0) {
								
								if (usuario.getEmail() != null) {
									
									if (usuario.getTelefono() != 0) {
										
										if (usuario.isEstado()) {
											
											Optional<Usuario> optUsuario = Optional.of(usuarioDao.save(usuario));
											
											if (optUsuario.isPresent()) {
												
												return 0;
												
											}else {
												
												return 9;
											}
										}
										
									}else {
										
										return 8; //El telefono es cero
									}
									
									
								}else {
									
									return 7; //El email es null
									
								}
								
							}else {
								
								return 6; //La edad es cero
							}
							
						}else {
							
							return 5; //El apellido es null
							
						}
						
					}else {
						
						return 4; //El nombre es null
					}
				}
				
			}else {
				
				return 2; // El dni es null
			}
			
		}else {
			
			return 1; // Id es cero
			
		}
		
		return 0;
	}
	
	
	public boolean buscarUsuario(Long idUsuario, String dni) {
		
		return false;
	}
}

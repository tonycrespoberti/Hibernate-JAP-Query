/*
 * Author: Tony Crespo - tonycrespo@outlook.com
 * System Engineer, Java Spring MVC, Data, Boot, Cloud Developer
 */

package com.myapp.bricolaje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myapp.bricolaje.model.repo.Cargo;
import com.myapp.bricolaje.model.service.GestorCargo;

@Controller
public class ControladorCargo {

	@Autowired
	private GestorCargo gestorCargo;
	
	
	//------------------
	
	
	/**
	 * API Rest encargado de dar de alta a nuevos cargos
	 * @param cargo Recibe del Body los datos del nuevo cargo
	 * @return Codigo de resultado: 
	 * 		0 si es correcto, 
	 *		1 sino hay especificado un Id, 
	 * 		2 sino hay descripcion, 
	 * 		3 si hubo problemas en persistirlo, 
	 * 		4 si ya existe uno previamente en la BBDD
	 */
	@PostMapping(path = "/nuevo/cargo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> altaCargo(@RequestBody Cargo cargo){
		
		int cargoResponse = gestorCargo.agregarCargo(cargo);
		
		if (cargoResponse == 0) {
			
			return new ResponseEntity<Integer>(0, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Integer>(cargoResponse, HttpStatus.BAD_REQUEST);
	}
}

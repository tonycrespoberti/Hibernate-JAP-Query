package com.myapp.bricolaje.model.repo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "ROLES")
@Table(name = "ROLES")
@Scope("prototype")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;
	
	@Column(name = "ROL")
	private String descripcion;
	
	/*
	Creamos la relación bidereccional con Usuario, sabiendo que Rol es la entidad débil
	 
	Con mappedBy enlazamos el atributo usuario de la Tabla Rol con la Tabla Usuario.
	Mapeamos o enlazamos ésta relación con el atributo rol que está definido en la clase Usuario
	Definimos un fetch del tipo LAZY para cuando se soliciten direcciones no nos tariga todos los
	usuarios asociados a la relación. Por ejemplo, si deseo añadir a un List todas las direcciones, no me
	interesa que se cargen también todos los usuarios.
	EAGGER es carga temprana y puede tener un impacto importante a nivel de uso de recursos cuando
	se haga un get de la entidad usuario.
	*/
	@OneToOne(mappedBy = "rol", fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "ID_PERMISO")
	private Permiso permiso;
	
	//--------------------------

	public Rol() {
	}

	public Rol(int idRol, String descripcion, Permiso permiso) {
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.permiso = permiso;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	//Importante no colocar en el ToString el atributo Usuario para no crear un bucle infinito
	//producto de la relación. Podemos agregar por ejemplo usuario.getNombre() sin problema, más no
	//el atributo usuario completo.
	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", descripcion=" + descripcion + ", permiso=" + permiso.getIdPermiso()
				+ "]";
	}
}

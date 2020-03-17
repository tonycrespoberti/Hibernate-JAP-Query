package com.myapp.bricolaje.model.repo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Entity(name = "USUARIOS")
@Table(name = "USUARIOS")
@SessionScope
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private long idUsuario;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombres;
	
	@Column(name = "APELLIDO")
	private String apellidos;
	
	@Column(name = "EDAD")
	private int edad;
	
	@Column(name = "TELEFONO")
	private long telefono;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ESTADO")
	private boolean estado;
	
	/* 
	La entidad dueña o fuerte es Usuario, por lo que usaremos id_rol como foreign key en la tabla Usuario) 
	Esto lo hacemos con la anotación JoinColumn.
	El mecanismo de Cascada es usado por JPA para agregar o eliminar los datos en las tablas relacionadas, además
	de ayudarnos a no tener primero que agregar/eliminar un registro/objeto en una para que no de fallos en la otra
	
	Del lado de la entidad débil, en este caso la tabla Rol, debemos analizar la conveniencia o no de emplear
	la propiedad EAGER o LAZY. Con EAGER haríamos una carga temprana de los roles asociados al Usuario. Con
	LAZY solo dispondremos de los roles del usuario cuando realicemos un Get del Usuario.
	
	Tener cuidado en el ToString en ambas clases relacionadas para no crear un bucle que por la relación una llamará
	a la otra y viceversa
	*/
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "ID_ROL")
	private Rol rol;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	
		
	
	//--------------------------
	
	public Usuario() {
		
	}

	public Usuario(long idUsuario, String dni, String nombres, String apellidos, int edad, long telefono, String email, boolean estado, Rol rol) {
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
		this.rol = rol;
	}

	public long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", edad=" + edad + ", telefono=" + telefono + ", email=" + email + ", estado=" + estado + ", rol="
				+ rol + ", direccion=" + direccion + "]";
	}
}

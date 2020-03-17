package com.myapp.bricolaje.model.repo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "CLIENTES")
@Table(name = "CLIENTES")
@Scope("prototype")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "NIF")
	private String nif;
	
	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name = "NOMBRE_COMERCIAL")
	private String nombreComercial;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	
	@Column(name = "PERSONA_CONTACTO")
	private String personaContacto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CARGO")
	private Cargo cargo;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> listaPedidos;
	
	//------------------------------

	public Cliente() {

	}

	public Cliente(Long idCliente, String nif, String razonSocial, String nombreComercial, Direccion direccion,
			String personaContacto, Cargo cargo, List<Pedido> listaPedidos) {
		this.idCliente = idCliente;
		this.nif = nif;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.direccion = direccion;
		this.personaContacto = personaContacto;
		this.cargo = cargo;
		this.listaPedidos = listaPedidos;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nif=" + nif + ", razonSocial=" + razonSocial
				+ ", nombreComercial=" + nombreComercial + ", direccion=" + direccion + ", personaContacto="
				+ personaContacto + ", cargo=" + cargo.getIdCargo() + ", listaPedidos=" + listaPedidos + "]";
	}
	
	
	
	
	
}

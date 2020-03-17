package com.myapp.bricolaje.model.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component
@Entity(name = "CARGOS")
@Table(name = "CARGOS")
@Scope("prototype")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARGO")
	private int idCargo;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToOne(mappedBy = "cargo", fetch = FetchType.LAZY)
	private Cliente cliente;

	//-------------------
	
	public Cargo() {

	}

	public Cargo(int idCargo, String descripcion, Cliente cliente) {
		this.idCargo = idCargo;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", descripcion=" + descripcion + ", cliente=" + cliente + "]";
	}
}

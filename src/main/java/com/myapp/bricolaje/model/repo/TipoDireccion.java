package com.myapp.bricolaje.model.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "TIPODIRECCIONES")
@Table(name = "TIPODIRECCIONES")
@Scope("prototype")
public class TipoDireccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_DIRECCION")
	private int idTipoDireccion;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToOne(mappedBy = "tipoDireccion", fetch = FetchType.LAZY)
	private Direccion direccion;
	
	//--------------------------

	public TipoDireccion() {

	}

	public TipoDireccion(int idTipoDireccion, String descripcion, Direccion direccion) {
		this.idTipoDireccion = idTipoDireccion;
		this.descripcion = descripcion;
		this.direccion = direccion;
	}

	public int getIdTipoDireccion() {
		return idTipoDireccion;
	}

	public void setIdTipoDireccion(int idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "TipoDireccion [idTipoDireccion=" + idTipoDireccion + ", descripcion=" + descripcion + ", direccion="
				+ direccion.getIdDireccion() + "]";
	}
}

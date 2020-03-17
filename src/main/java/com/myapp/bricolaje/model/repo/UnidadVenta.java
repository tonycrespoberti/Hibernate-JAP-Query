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
@Entity(name = "UNIDAD_VENTA")
@Table(name = "UNIDAD_VENTA")
@Scope("prototype")
public class UnidadVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UNIDAD_VENTA")
	private int idUnidadVenta;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToOne(mappedBy = "unidadVenta", fetch = FetchType.LAZY)
	private Producto producto;
	
	//----------------------

	public UnidadVenta() {

	}

	public UnidadVenta(int idUnidadVenta, String descripcion, Producto producto) {
		this.idUnidadVenta = idUnidadVenta;
		this.descripcion = descripcion;
		this.producto = producto;
	}

	public int getIdUnidadVenta() {
		return idUnidadVenta;
	}

	public void setIdUnidadVenta(int idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", descripcion=" + descripcion + ", producto=" + producto             
				+ "]";
	}
	
}

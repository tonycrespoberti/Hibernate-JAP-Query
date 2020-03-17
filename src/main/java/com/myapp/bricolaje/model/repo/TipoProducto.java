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
@Entity(name = "TIPO_PRODUCTO")
@Table(name = "TIPO_PRODUCTO")
@Scope("prototype")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_PRODUCTO")
	private int idTipoProducto;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToOne(mappedBy = "tipoProducto", fetch = FetchType.LAZY)
	private Producto producto;
	
	//----------------------------

	public TipoProducto() {
	
	}

	public TipoProducto(int idTipoProducto, String descripcion, Producto producto) {
		super();
		this.idTipoProducto = idTipoProducto;
		this.descripcion = descripcion;
		this.producto = producto;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
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
		return "TipoProducto [idTipoProducto=" + idTipoProducto + ", descripcion=" + descripcion + ", producto="
				+ producto + "]";
	}
}

/*
 * Author: Tony Crespo - tonycrespo@outlook.com
 * System Engineer, Java Spring MVC, Data, Boot, Cloud Developer
 */
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
@Entity(name = "PRODUCTOS")
@Table(name = "PRODUCTOS")
@Scope("prototype")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private int idProducto;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_TIPO_PRODUCTO")
	private TipoProducto tipoProducto;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_UNIDAD_VENTA")
	private UnidadVenta unidadVenta;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<Pedido> listaPedidos;
	
	@Column(name = "PRECIO")
	private Double precio;
	
	@Column(name = "IMPUESTO")
	private Double impuesto;
	
	@Column(name = "RUTA_LOGO")
	private String rutaLogo;
	
}

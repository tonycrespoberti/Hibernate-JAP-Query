package com.myapp.bricolaje.model.repo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "PEDIDOS")
@Table(name = "PEDIDOS")
@Scope("prototype")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO")
	private Long idPedido;
	
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "ID_PRODUCTO")
	private int idProducto;
	
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	@Column(name = "PRECIO")
	private Double precio;
	
	@Column(name = "IMPUESTO")
	private Double impuesto;
	
	@Column(name = "SUB_TOTAL")
	private Double subTotal;
	
	@Column(name = "TOTAL")
	private Double total;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", insertable = false, updatable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
	private Producto producto;

	//----------------------------------
	
	public Pedido() {

	}

	public Pedido(Long idPedido, Long idCliente, int idProducto, int cantidad, Double precio, Double impuesto,
			Double subTotal, Double total, Date fecha, Cliente cliente) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.impuesto = impuesto;
		this.subTotal = subTotal;
		this.total = total;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", precio=" + precio + ", impuesto=" + impuesto + ", subTotal=" + subTotal
				+ ", total=" + total + ", fecha=" + fecha + "]";
	}
}

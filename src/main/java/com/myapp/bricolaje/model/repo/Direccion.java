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
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component
@Entity(name = "DIRECCIONES")
@Table(name = "DIRECCIONES")
@Scope("prototype")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECCION")
	private int idDireccion;
	
	@Column(name = "CALLE_AVENIDA")
	private String calleAvenida;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "PLANTA")
	private String planta;
	
	@Column(name = "PUERTA")
	private String puerta;
	
	@Column(name = "LOCALIDAD")
	private String localidad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "CODIGO_POSTAL")
	private int codigoPostal;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "ID_TIPO_DIRECCION")
	private TipoDireccion tipoDireccion;
	
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
	private Cliente cliente;

	//--------------------------
	
	public Direccion() {
	
	}


	public Direccion(int idDireccion, String calleAvenida, String numero, String planta, String puerta,
			String localidad, String provincia, int codigoPostal, TipoDireccion tipoDireccion) {
		this.idDireccion = idDireccion;
		this.calleAvenida = calleAvenida;
		this.numero = numero;
		this.planta = planta;
		this.puerta = puerta;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.tipoDireccion = tipoDireccion;
	}


	public int getIdDireccion() {
		return idDireccion;
	}


	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}


	public String getCalleAvenida() {
		return calleAvenida;
	}


	public void setCalleAvenida(String calleAvenida) {
		this.calleAvenida = calleAvenida;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getPlanta() {
		return planta;
	}


	public void setPlanta(String planta) {
		this.planta = planta;
	}


	public String getPuerta() {
		return puerta;
	}


	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}


	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}


	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calleAvenida=" + calleAvenida + ", numero=" + numero
				+ ", planta=" + planta + ", puerta=" + puerta + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", codigoPostal=" + codigoPostal + ", tipoDireccion=" + tipoDireccion.getIdTipoDireccion()+ "]";
	}
}

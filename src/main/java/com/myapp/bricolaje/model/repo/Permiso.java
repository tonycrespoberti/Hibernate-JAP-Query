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
@Entity(name = "PERMISOS")
@Table(name = "PERMISOS")
@Scope("prototype")
public class Permiso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERMISO")
	private int idPermiso;
	
	@Column(name = "TIPO_PERMISO")
	private String tipoPermiso;
	
	@OneToOne(mappedBy = "permiso", fetch = FetchType.LAZY)
	private Rol rol;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "ID_MODULO")
	private Modulo modulo;
	
	//--------------------------

	public Permiso() {
	}

	public Permiso(int idPermiso, String tipoPermiso, Modulo modulo) {
		this.idPermiso = idPermiso;
		this.tipoPermiso = tipoPermiso;
		this.modulo = modulo;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(String tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", tipoPermiso=" + tipoPermiso + "]";
	}
	
}

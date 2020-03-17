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
@Entity(name = "MODULOS")
@Table(name = "MODULOS")
@Scope("prototype")
public class Modulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MODULO")
	private int idModulo;
	
	@Column(name = "MODULO")
	private String modulo;
	
	@OneToOne(mappedBy = "modulo", fetch = FetchType.LAZY)
	private Permiso permiso;
	
	//--------------------------

	public Modulo() {
	}

	public Modulo(int idModulo, String modulo) {
		this.idModulo = idModulo;
		this.modulo = modulo;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", modulo=" + modulo + "]";
	}
}

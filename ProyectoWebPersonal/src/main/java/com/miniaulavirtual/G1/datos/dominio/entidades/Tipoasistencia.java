package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoasistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoasistencia.findAll", query="SELECT t FROM Tipoasistencia t")
public class Tipoasistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoAsistencia;

	private String tipo;

	public Tipoasistencia() {
	}

	public int getIdTipoAsistencia() {
		return this.idTipoAsistencia;
	}

	public void setIdTipoAsistencia(int idTipoAsistencia) {
		this.idTipoAsistencia = idTipoAsistencia;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
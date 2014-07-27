package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clasedictado database table.
 * 
 */
@Entity
@NamedQuery(name="Clasedictado.findAll", query="SELECT c FROM Clasedictado c")
public class Clasedictado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClaseDictado;

	private int idMatriculaDetalle;

	private String nota;

	public Clasedictado() {
	}

	public int getIdClaseDictado() {
		return this.idClaseDictado;
	}

	public void setIdClaseDictado(int idClaseDictado) {
		this.idClaseDictado = idClaseDictado;
	}

	public int getIdMatriculaDetalle() {
		return this.idMatriculaDetalle;
	}

	public void setIdMatriculaDetalle(int idMatriculaDetalle) {
		this.idMatriculaDetalle = idMatriculaDetalle;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}
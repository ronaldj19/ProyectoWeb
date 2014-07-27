package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatricula;

	public Matricula() {
	}

	public int getIdMatricula() {
		return this.idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

}
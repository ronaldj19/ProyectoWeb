package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cicloprogramado database table.
 * 
 */
@Entity
@NamedQuery(name="Cicloprogramado.findAll", query="SELECT c FROM Cicloprogramado c")
public class Cicloprogramado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCicloProgramado;

	private int ciclo_idCiclo;

	private int idCursoProgramado;

	public Cicloprogramado() {
	}

	public int getIdCicloProgramado() {
		return this.idCicloProgramado;
	}

	public void setIdCicloProgramado(int idCicloProgramado) {
		this.idCicloProgramado = idCicloProgramado;
	}

	public int getCiclo_idCiclo() {
		return this.ciclo_idCiclo;
	}

	public void setCiclo_idCiclo(int ciclo_idCiclo) {
		this.ciclo_idCiclo = ciclo_idCiclo;
	}

	public int getIdCursoProgramado() {
		return this.idCursoProgramado;
	}

	public void setIdCursoProgramado(int idCursoProgramado) {
		this.idCursoProgramado = idCursoProgramado;
	}

}
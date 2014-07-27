package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cursoprogramado database table.
 * 
 */
@Entity
@NamedQuery(name="Cursoprogramado.findAll", query="SELECT c FROM Cursoprogramado c")
public class Cursoprogramado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCursoProgramado;

	private int idCurso;

	private int idDocente;

	private int idGrupo;

	private int idHorario;

	private int idTipo;

	public Cursoprogramado() {
	}

	public int getIdCursoProgramado() {
		return this.idCursoProgramado;
	}

	public void setIdCursoProgramado(int idCursoProgramado) {
		this.idCursoProgramado = idCursoProgramado;
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdDocente() {
		return this.idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public int getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

}
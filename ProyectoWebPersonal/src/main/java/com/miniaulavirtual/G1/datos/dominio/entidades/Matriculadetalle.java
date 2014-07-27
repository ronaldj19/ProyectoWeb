package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matriculadetalle database table.
 * 
 */
@Entity
@NamedQuery(name="Matriculadetalle.findAll", query="SELECT m FROM Matriculadetalle m")
public class Matriculadetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatriculaDetalle;

	private int idAlumno;

	private int idCicloProgramado;

	private int idMatricula;

	public Matriculadetalle() {
	}

	public int getIdMatriculaDetalle() {
		return this.idMatriculaDetalle;
	}

	public void setIdMatriculaDetalle(int idMatriculaDetalle) {
		this.idMatriculaDetalle = idMatriculaDetalle;
	}

	public int getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdCicloProgramado() {
		return this.idCicloProgramado;
	}

	public void setIdCicloProgramado(int idCicloProgramado) {
		this.idCicloProgramado = idCicloProgramado;
	}

	public int getIdMatricula() {
		return this.idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

}
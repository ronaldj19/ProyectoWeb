package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHorario;

	private String dia;

	@Column(name="h_fin")
	private String hFin;

	@Column(name="h_inicio")
	private String hInicio;

	public Horario() {
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHFin() {
		return this.hFin;
	}

	public void setHFin(String hFin) {
		this.hFin = hFin;
	}

	public String getHInicio() {
		return this.hInicio;
	}

	public void setHInicio(String hInicio) {
		this.hInicio = hInicio;
	}

}
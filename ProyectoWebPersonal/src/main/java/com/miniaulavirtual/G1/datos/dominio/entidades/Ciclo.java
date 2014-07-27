package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciclo database table.
 * 
 */
@Entity
@NamedQuery(name="Ciclo.findAll", query="SELECT c FROM Ciclo c")
public class Ciclo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCiclo;

	private int anio;

	private String codigo;

	private String nombre;

	public Ciclo() {
	}

	public int getIdCiclo() {
		return this.idCiclo;
	}

	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
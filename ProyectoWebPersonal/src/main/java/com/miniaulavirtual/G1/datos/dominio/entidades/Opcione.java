package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opciones database table.
 * 
 */
@Entity
@Table(name="opciones")
@NamedQuery(name="Opcione.findAll", query="SELECT o FROM Opcione o")
public class Opcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOpciones;

	@Column(name="nombre_opcion")
	private String nombreOpcion;

	public Opcione() {
	}

	public int getIdOpciones() {
		return this.idOpciones;
	}

	public void setIdOpciones(int idOpciones) {
		this.idOpciones = idOpciones;
	}

	public String getNombreOpcion() {
		return this.nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

}
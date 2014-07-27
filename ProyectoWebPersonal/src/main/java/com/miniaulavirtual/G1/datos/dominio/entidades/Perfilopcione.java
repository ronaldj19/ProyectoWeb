package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfilopcione database table.
 * 
 */
@Entity
@NamedQuery(name="Perfilopcione.findAll", query="SELECT p FROM Perfilopcione p")
public class Perfilopcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPerfil_Opciones;

	private String idOpciones;

	private String idPerfil;

	public Perfilopcione() {
	}

	public int getIdPerfil_Opciones() {
		return this.idPerfil_Opciones;
	}

	public void setIdPerfil_Opciones(int idPerfil_Opciones) {
		this.idPerfil_Opciones = idPerfil_Opciones;
	}

	public String getIdOpciones() {
		return this.idOpciones;
	}

	public void setIdOpciones(String idOpciones) {
		this.idOpciones = idOpciones;
	}

	public String getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

}
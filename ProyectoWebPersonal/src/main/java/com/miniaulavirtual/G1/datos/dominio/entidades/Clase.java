package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Clase.buscar", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase")
public class Clase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClase;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private Tipo tipo;
	
	@Temporal( TemporalType.DATE )
	private Date fecha;
	private String tema;
	
	int tomadasAsistencia;
	
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public int getTomadasAsistencia() {
		return tomadasAsistencia;
	}
	public void setTomadasAsistencia(int tomadasAsistencia) {
		this.tomadasAsistencia = tomadasAsistencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClase;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		if (idClase != other.idClase)
			return false;
		return true;
	}
}

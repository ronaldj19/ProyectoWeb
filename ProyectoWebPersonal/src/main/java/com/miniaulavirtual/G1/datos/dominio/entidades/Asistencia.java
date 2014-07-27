package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
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


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Asistencia.listarPorClase", query="SELECT a FROM Asistencia a WHERE a.clase.idClase = :idClase")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAsistencia;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private Alumno alumno;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private Clase clase;
	
	@Temporal( TemporalType.DATE )
	private Date fechaModificacion;
	
	private String asistencia;

	public Asistencia() {
		asistencia = "No tomado";
	}

	public int getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
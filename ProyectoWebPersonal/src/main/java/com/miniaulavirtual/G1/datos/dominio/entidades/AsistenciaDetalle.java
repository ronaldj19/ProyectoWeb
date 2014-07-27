package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asistencia_detalle database table.
 * 
 */
@Entity
@Table(name="asistencia_detalle")
@NamedQuery(name="AsistenciaDetalle.findAll", query="SELECT a FROM AsistenciaDetalle a")
public class AsistenciaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idAsistencia_Detalle;

	private int asistencia_idAsistencia;

	private int claseDictado_idClaseDictado;

	private String horatomada;

	private int tipoAsistencia_idTipoAsistencia;

	public AsistenciaDetalle() {
	}

	public String getIdAsistencia_Detalle() {
		return this.idAsistencia_Detalle;
	}

	public void setIdAsistencia_Detalle(String idAsistencia_Detalle) {
		this.idAsistencia_Detalle = idAsistencia_Detalle;
	}

	public int getAsistencia_idAsistencia() {
		return this.asistencia_idAsistencia;
	}

	public void setAsistencia_idAsistencia(int asistencia_idAsistencia) {
		this.asistencia_idAsistencia = asistencia_idAsistencia;
	}

	public int getClaseDictado_idClaseDictado() {
		return this.claseDictado_idClaseDictado;
	}

	public void setClaseDictado_idClaseDictado(int claseDictado_idClaseDictado) {
		this.claseDictado_idClaseDictado = claseDictado_idClaseDictado;
	}

	public String getHoratomada() {
		return this.horatomada;
	}

	public void setHoratomada(String horatomada) {
		this.horatomada = horatomada;
	}

	public int getTipoAsistencia_idTipoAsistencia() {
		return this.tipoAsistencia_idTipoAsistencia;
	}

	public void setTipoAsistencia_idTipoAsistencia(int tipoAsistencia_idTipoAsistencia) {
		this.tipoAsistencia_idTipoAsistencia = tipoAsistencia_idTipoAsistencia;
	}

}
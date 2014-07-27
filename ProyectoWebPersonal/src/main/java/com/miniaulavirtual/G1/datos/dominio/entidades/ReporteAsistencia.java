package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;

import javax.persistence.*;


public class ReporteAsistencia implements Serializable {

	private Clase clase;
	private int asistencias;
	private int faltas;
	private int tardanzas;
	
	public void anadirAsistencia() {
		asistencias ++;
	}
	
	public void anadirTardanza() {
		tardanzas ++;
	}
	
	public void anadirFalta() {
		faltas ++;
	}
	
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	public int getTardanzas() {
		return tardanzas;
	}
	public void setTardanzas(int tardanzas) {
		this.tardanzas = tardanzas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
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
		ReporteAsistencia other = (ReporteAsistencia) obj;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		return true;
	}
	
}
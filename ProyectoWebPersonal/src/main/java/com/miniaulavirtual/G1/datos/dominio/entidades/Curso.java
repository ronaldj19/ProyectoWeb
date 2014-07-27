package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c"),
@NamedQuery(name = "Curso.listar",query = "SELECT c FROM Curso c"),
@NamedQuery(name = "Curso.listarPorDocente",query = "SELECT DISTINCT c FROM Curso c LEFT JOIN c.grupos as grupo "
		+ " LEFT JOIN grupo.tipos as tipo WHERE tipo.docente.codigo = :codigoDocente"),
@NamedQuery(name = "Curso.listarPorAlumno",query = "SELECT DISTINCT c FROM Curso c LEFT JOIN c.grupos as grupo  LEFT JOIN grupo.alumnos"
				+ " as alumno WHERE alumno.idAlumno = :idAlumno"),
@NamedQuery(name = "Curso.buscarPorNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombreCurso")
})

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	
	private String codigo;
	
	private String nombre;

	private int nro_creditos;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy="curso")
	private List<Grupo> grupos;
	
	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNro_creditos() {
		return this.nro_creditos;
	}

	public void setNro_creditos(int nro_creditos) {
		this.nro_creditos = nro_creditos;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCurso;
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
		Curso other = (Curso) obj;
		if (idCurso != other.idCurso)
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
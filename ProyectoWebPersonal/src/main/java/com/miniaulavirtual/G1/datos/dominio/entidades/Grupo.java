package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g"),
@NamedQuery(name = "Grupo.buscar", query = "SELECT g FROM Grupo g WHERE g.idGrupo= :idGrupo"),
@NamedQuery(name = "Grupo.listarPorAlumno", query = "SELECT g FROM Grupo g LEFT JOIN g.alumnos as alumno WHERE alumno.idAlumno= :idAlumno")
})
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;
	
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable
	private List<Alumno> alumnos;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn
	private List<Tipo> tipos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private Curso curso;
	 
	public Grupo() {
	}

	public int getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGrupo;
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
		Grupo other = (Grupo) obj;
		if (idGrupo != other.idGrupo)
			return false;
		return true;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
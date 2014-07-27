package com.miniaulavirtual.G1.vista.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.miniaulavirtual.G1.datos.dominio.entidades.Alumno;
import com.miniaulavirtual.G1.datos.dominio.entidades.Asistencia;
import com.miniaulavirtual.G1.datos.dominio.entidades.Clase;
import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;
import com.miniaulavirtual.G1.datos.dominio.entidades.Docente;
import com.miniaulavirtual.G1.datos.dominio.entidades.Grupo;
import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AlumnoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AsistenciaDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.GrupoDao;


@ManagedBean(name = "asistencia3")
@ViewScoped
public class ControladorReporteAsistenciaCursoAlumno implements Serializable{
	@EJB
	private CursoDao cursoDao;
	@EJB
	private AlumnoDao alumnoDao;
	@EJB
	private GrupoDao grupoDao;
	@EJB
	private AsistenciaDao asistenciaDao;
	
	private List<Grupo> grupos;
	private List<Curso> cursos;
	private List<Tipo> tipos;
	private List<Clase> clases;
	private List<Asistencia> asistencias;
	
	private Grupo grupoSeleccionado;
	private Curso cursoSeleccionado;
	private Tipo tipoSeleccionado;
	private Alumno alumnoSeleccionado;
	private Alumno alumno;
	
	@PostConstruct
	public void inicializar() {
		alumno = new Alumno();
		alumno.setIdAlumno(1);
		cursos = cursoDao.listarPorAlumno(alumno);
		cursoSeleccionado = cursos.get(0);
		
		cargarGrupos();
	}
	
	public void cargarGrupos() {
		grupos = cursoSeleccionado.getGrupos();
		grupoSeleccionado = grupos.get(0);
		
		cargarTipos();
	}
	
	public void cargarTipos() {
		tipos = grupoSeleccionado.getTipos();
		tipoSeleccionado = tipos.get(0);
		
		clases = tipoSeleccionado.getClases();
	}
	
	public void cargarAsistencias() {
		List<Asistencia> temp;
		asistencias = new ArrayList<>();
		
		for(int i = 0; i < clases.size(); i ++) {
			temp = asistenciaDao.listarPorClase(clases.get(i));
			
			for(int j = 0; j < temp.size(); j ++) {
				if(temp.get(j).getAlumno().getIdAlumno() == alumno.getIdAlumno()) {
					asistencias.add(temp.get(j));
					break;
				}
			}
		}
	}
		
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCursoSeleccionado() {
		return cursoSeleccionado;
	}

	public void setCursoSeleccionado(Curso cursoSeleccionado) {
		this.cursoSeleccionado = cursoSeleccionado;
	}


	public List<Grupo> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo getGrupoSeleccionado() {
		return grupoSeleccionado;
	}

	public void setGrupoSeleccionado(Grupo grupoSeleccionado) {
		this.grupoSeleccionado = grupoSeleccionado;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Tipo getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(Tipo tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}
}

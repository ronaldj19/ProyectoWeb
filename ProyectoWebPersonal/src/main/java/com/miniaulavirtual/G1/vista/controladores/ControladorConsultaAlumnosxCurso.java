package com.miniaulavirtual.G1.vista.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.miniaulavirtual.G1.datos.dominio.entidades.Alumno;
import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;
import com.miniaulavirtual.G1.datos.dominio.entidades.Docente;
import com.miniaulavirtual.G1.datos.dominio.entidades.Grupo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AlumnoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;
import com.miniaulavirtual.G1.vista.util.MensajesJSF;


@ManagedBean(name = "alumnosPorGrupo")
@ViewScoped
public class ControladorConsultaAlumnosxCurso implements Serializable{
	@EJB
	private CursoDao cursoDao;
	@EJB
	private AlumnoDao alumnoDao;
	
	
	private List<Alumno> alumnos;
	
	private List<Grupo> grupos;
	private List<Curso> cursos;
	
	private Grupo grupoSeleccionado;
	private Curso cursoSeleccionado;
	
	
	@PostConstruct
	public void inicializar() {
		Docente docente = new Docente();
		docente.setCodigo("1");
		cursos = cursoDao.listarPorDocente(docente);
		cursoSeleccionado = cursos.get(0);
		
		cargarGrupos();
	}
	
	public void cargarGrupos() {
		grupos = cursoSeleccionado.getGrupos();
		grupoSeleccionado = grupos.get(0);
	}
	
	public void cargarAlumnos() {
		
		alumnos = alumnoDao.listaPorGrupo(grupoSeleccionado);
		
		if(alumnos.size() == 0)
			MensajesJSF.mostrarMensajeDialogo("Alumnos por grup", "No se encuentran alumnos en la base de datos");
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

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}

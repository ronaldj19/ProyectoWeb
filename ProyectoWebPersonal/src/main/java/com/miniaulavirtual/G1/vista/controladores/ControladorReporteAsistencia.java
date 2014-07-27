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
import com.miniaulavirtual.G1.datos.dominio.entidades.ReporteAsistencia;
import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AlumnoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AsistenciaDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.GrupoDao;


@ManagedBean(name = "asistencia2")
@ViewScoped
public class ControladorReporteAsistencia implements Serializable{
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
	private List<ReporteAsistencia> reporteAsistencias;
	
	private Grupo grupoSeleccionado;
	private Curso cursoSeleccionado;
	private Tipo tipoSeleccionado;
	
	
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
		
		cargarTipos();
	}
	
	public void cargarTipos() {
		tipos = grupoSeleccionado.getTipos();
		tipoSeleccionado = tipos.get(0);
		
		clases = tipoSeleccionado.getClases();
		cargarAsistencias();
	}
	
	public void cargarAsistencias() {
		
		reporteAsistencias = new ArrayList<>();
		
		for(int i = 0; i < clases.size(); i ++) {
			Clase clase = clases.get(i);
			ReporteAsistencia reporteAsistencia = new ReporteAsistencia();
			reporteAsistencia.setClase(clase);
			
			asistencias = asistenciaDao.listarPorClase(clase);
			
			if(asistencias.size() == 0)
				continue;
			
			for(int j = 0; j < asistencias.size(); j ++) {
				if(asistencias.get(j).getAsistencia().equals("Asistio"))
					reporteAsistencia.anadirAsistencia();
				if(asistencias.get(j).getAsistencia().equals("Falto"))
					reporteAsistencia.anadirFalta();
				if(asistencias.get(j).getAsistencia().equals("Tardanza"))
					reporteAsistencia.anadirTardanza();
			}
			
			reporteAsistencias.add(reporteAsistencia);
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

	public List<ReporteAsistencia> getReporteAsistencias() {
		return reporteAsistencias;
	}

	public void setReporteAsistencias(List<ReporteAsistencia> reporteAsistencias) {
		this.reporteAsistencias = reporteAsistencias;
	}
}

package com.miniaulavirtual.G1.vista.controladores;

import java.util.ArrayList;
import java.util.Date;
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
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AsistenciaDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.ClaseDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;
import com.miniaulavirtual.G1.vista.util.MensajesJSF;

@ManagedBean(name = "asistencia")
@ViewScoped
public class ControladorRegistrarAsistencia {
	
	@EJB
	private CursoDao cursoDao;
	@EJB
	private AsistenciaDao asistenciaDao;
	@EJB
	private ClaseDao claseDao;
	
	private Docente docente;
	private List<Curso> cursos;
	private List<Grupo> grupos;
	private List<Tipo> tipos;
	private List<Asistencia> asistencias;
	
	private Clase claseActual;
	private Curso cursoSeleccionado;
	private Grupo grupoSeleccionado;
	private Tipo tipoSeleccionado;
	
	private boolean sePuedeGuardar;
	
	@PostConstruct
	public void inicializarPagina() {
		docente = new Docente();
		docente.setCodigo("1");
		
		cursos = cursoDao.listarPorDocente(docente);
		grupos = new ArrayList<>();
		tipos = new ArrayList<>();
		asistencias = new ArrayList<>();
		
		sePuedeGuardar = false;
	}
	
	public void cargarTipos() {
		tipos = grupoSeleccionado.getTipos();
		sePuedeGuardar = false;
	}
	
	public void cargarGrupos() {
		grupos = cursoSeleccionado.getGrupos();
		sePuedeGuardar = false;
	}
	
	public void cargarAsistencias() throws Exception{
		claseActual = buscarClaseActual();
		
		if(noExisteClaseParaEsteDia()) {
			MensajesJSF.mostrarMensajeDialogo("Tomar asistencia", "No hay ninguna clase para el dia de hoy");
			inicializarPagina();
			return;
		}
		
		if(claseActual.getTomadasAsistencia() == 1) 
			MensajesJSF.mostrarMensajeNotify("Tomar asistencia", "Esta es su segunda toma de asistencia");
		
		if(claseActual.getTomadasAsistencia() == 2) {
			MensajesJSF.mostrarMensajeNotify("Tomar asistencia", "Ud. Puede tomar como máximo 2 asistencia de un curso en el día");
			inicializarPagina();
			return;
		}
		
		asistencias = asistenciaDao.listarPorClase(claseActual);
		
		if(noSeHaTomadoAsistencia()) {
			asistencias = crearPrimeraTomaAsistencia();
		}
		
		sePuedeGuardar = true;
	}

	private boolean noExisteClaseParaEsteDia() {
		return claseActual == null;
	}
	
	private Clase buscarClaseActual() {
		List<Clase> clases = tipoSeleccionado.getClases();
		
		for(int i = 0; i < clases.size(); i ++) {
			if(esClaseDelDia(clases.get(i))) {
				return clases.get(i);
			}
		}
		
		return null;
	}
	
	private List<Asistencia> crearPrimeraTomaAsistencia() {
		List<Asistencia> asistencias = new ArrayList<>();
		
		List<Alumno> alumnos = grupoSeleccionado.getAlumnos();
		
		for(int i = 0; i < alumnos.size(); i ++) {
			Asistencia asistencia = new Asistencia();
			asistencia.setAlumno(alumnos.get(i));
			asistencia.setAsistencia("Asistio");
			asistencia.setClase(claseActual);
			
			asistencias.add(asistencia);
		}
		
		return asistencias;
	}

	private boolean noSeHaTomadoAsistencia() {
		return asistencias.size() == 0;
	}

	
	
	private boolean esClaseDelDia(Clase clase) {
		Date fechaActual = new Date();
		Date fechaClase = clase.getFecha();
		
		if(esMismoDia(fechaActual, fechaClase) &&
		esMismoMes(fechaActual, fechaClase) &&
		esMismoAnio(fechaActual, fechaClase)) 
			return true;
		else
			return false;
	}
	
	public void tomarAsistencia() throws Exception {
		
		claseActual.setTomadasAsistencia(claseActual.getTomadasAsistencia() + 1);
		claseDao.guardarOrActualizar(claseActual);
		
		for(int i = 0; i < asistencias.size(); i ++) {
			asistenciaDao.guardarOrActualizar(asistencias.get(i));
		}
		
		MensajesJSF.mostrarMensajeDialogo("Tomar asistencia", "Se registró correctamente la asistencia");
		inicializarPagina();
	}
	
	private boolean esMismoAnio(Date fechaActual, Date fechaClase) {
		return fechaActual.getYear() == fechaClase.getYear();
	}

	private boolean esMismoMes(Date fechaActual, Date fechaClase) {
		return fechaActual.getMonth() == fechaClase.getMonth();
	}

	private boolean esMismoDia(Date fechaActual, Date fechaClase) {
		return fechaActual.getDate() == fechaClase.getDate();
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

	public Tipo getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(Tipo tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public boolean isSePuedeGuardar() {
		return sePuedeGuardar;
	}

	public void setSePuedeGuardar(boolean sePuedeGuardar) {
		this.sePuedeGuardar = sePuedeGuardar;
	}
}

package com.miniaulavirtual.G1.vista.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

@ManagedBean(name = "corregir")
@ViewScoped
public class ControladorCorregirAsistencia {
	
	@EJB
	private CursoDao cursoDao;
	@EJB
	private AsistenciaDao asistenciaDao;
	@EJB
	private ClaseDao claseDao;
	
	private List<Curso> cursos;
	private List<Grupo> grupos;
	private List<Tipo> tipos;
	private List<Clase> clases;
	private List<Asistencia> asistencias;
	private List<String> asistenciasInicial;
	
	private Curso cursoSeleccionado;
	private Grupo grupoSeleccionado;
	private Tipo tipoSeleccionado;
	private Clase claseSeleccionada;

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
		
		cargarClases();
	}
	
	public void cargarClases() {
		clases = tipoSeleccionado.getClases();
		List<Clase> temp = new ArrayList<>(clases);
		
		for(int i = 0; i < temp.size(); i ++) {
			if(!esClasePasada(temp.get(i)))
				clases.remove(i);
		}
		
		if(clases.size() == 0)
			MensajesJSF.mostrarMensajeDialogo("Clases", "No existen clases");
		else {
			claseSeleccionada = clases.get(0);
			cargarAsistencias();
		}
	}
	
	private boolean esClasePasada(Clase clase) {
		Date hoy = new Date();
		hoy.setHours(0);
		hoy.setMinutes(0);
		hoy.setSeconds(0);
		
		if(clase.getFecha().before(hoy))
			return true;
		else
			return false;
	}
	
	public void cargarAsistencias() {
		asistencias = asistenciaDao.listarPorClase(claseSeleccionada);
		asistenciasInicial = new ArrayList<>();
		
		for(int i = 0; i < asistencias.size(); i ++) {
			asistenciasInicial.add(asistencias.get(i).getAsistencia());
		}
	}

	public void actualizarAsistencia() throws Exception {
		boolean hayModificacion = false;
		Asistencia nueva;
		String inicial;
		Date fechaModificacion = new Date();
		
		for(int i = 0; i < asistencias.size(); i ++) {
			inicial = asistenciasInicial.get(i);
			nueva = asistencias.get(i);
			
			if(!inicial.equals(nueva.getAsistencia())){
				asistenciasInicial.set(i, nueva.getAsistencia());
				hayModificacion = true;
				nueva.setFechaModificacion(fechaModificacion);
				asistenciaDao.guardarOrActualizar(nueva);
			}
		}
		
		if(hayModificacion) {
			MensajesJSF.mostrarMensajeDialogo("Corregir asistencia", "Se actualizo la asistencia");
		}
		else {
			MensajesJSF.mostrarMensajeDialogo("Corregir asistencia", "No se encontro modificaciones");
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

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase getClaseSeleccionada() {
		return claseSeleccionada;
	}

	public void setClaseSeleccionada(Clase claseSeleccionada) {
		this.claseSeleccionada = claseSeleccionada;
	}
}

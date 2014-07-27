package com.miniaulavirtual.G1.vista.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.miniaulavirtual.G1.datos.dominio.entidades.Alumno;
import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;
import com.miniaulavirtual.G1.datos.dominio.entidades.Grupo;
import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.AlumnoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.GrupoDao;
import com.miniaulavirtual.G1.negocio.excepciones.ServicioException;
import com.miniaulavirtual.G1.vista.util.MensajesJSF;


@ManagedBean(name = "matricula")
@ViewScoped
public class ControladorRegistrarMatricula implements Serializable{
	@EJB
	private CursoDao cursoDao;
	@EJB
	private AlumnoDao alumnoDao;
	@EJB
	private GrupoDao grupoDao;
	
	private List<Alumno> alumnosTotal;
	private List<Alumno> alumnosMatriculados;
	private List<Alumno> alumnosA;
	private List<Alumno> alumnosB;
	
	private String number = "1";
	private List<Grupo> grupos;
	private List<Curso> cursos;
	
	private Grupo grupoSeleccionado;
	private Curso cursoSeleccionado;
	private Tipo teoria, practica, laboratorio;
	
	private List<Alumno> alumnosSeleccionadosMatricula;
	
	@PostConstruct
	public void inicializar() {
		cursos = cursoDao.listar();
		cursoSeleccionado = cursos.get(0);
		
		cargarGrupos();
	}
	
	public void cargarGrupos() {
		grupos = cursoSeleccionado.getGrupos();
		grupoSeleccionado = grupos.get(0);
		
		cargarDetallesGrupo();
	}
	
	public void cargarDetallesGrupo() {
		List<Tipo> tipoClases = grupoSeleccionado.getTipos();
		
		alumnosA = new ArrayList<>();
		alumnosB = new ArrayList<>();
		
		laboratorio = tipoClases.get(0);
		practica = tipoClases.get(1);
		teoria = tipoClases.get(2);
		
		cargarAlumnos();
	}

	private void cargarAlumnos() {
		alumnosMatriculados = new ArrayList<>();
		alumnosTotal = alumnoDao.listar();
		
		List<Alumno> temporal = new ArrayList<>(alumnosTotal);
		
		for(int i = 0; i < temporal.size(); i ++) {
			Alumno alumno = temporal.get(i);
			List<Grupo> grupos = alumno.getGrupos();
			
			for(int j = 0; j < grupos.size(); j ++) {
				Grupo grupo = grupos.get(j);
				
				if(grupo.getIdGrupo() == grupoSeleccionado.getIdGrupo()) {
					alumnosMatriculados.add(alumno);
					alumnosTotal.remove(alumno);
					break;
				}
			}
		}
	}
	
	public void matricularAlumnos() {
		for(int i = 0; i < alumnosA.size(); i ++) {
			Alumno alumno = alumnosA.get(i);
			
			alumnosTotal.remove(alumno);
			
			alumno.getGrupos().add(grupoSeleccionado);
			grupoSeleccionado.getAlumnos().add(alumno);
			alumnosMatriculados.add(alumno);
		}
		
	}
	
	public void desmatricularAlumnos() {
		for(int i = 0; i < alumnosB.size(); i ++) {
			Alumno alumno = alumnosB.get(i);
			
			alumno.getGrupos().remove(grupoSeleccionado);
			grupoSeleccionado.getAlumnos().remove(alumno);
			alumnosTotal.add(alumno);
			
			alumnosMatriculados.remove(alumno);
		}
	}
	
	public void actualizarMatricula() {
		try{
			
			grupoDao.guardarOrActualizar(grupoSeleccionado);
			
			for(int i = 0; i < alumnosMatriculados.size(); i ++) {
				Alumno alumno = alumnosMatriculados.get(i);
				alumnoDao.guardarOrActualizar(alumno);
			}

			MensajesJSF.mostrarMensajeDialogo("Matricula", "Registro Guardado");
		}
		catch (Exception e) {
			MensajesJSF.mostrarMensajeDialogo("Registrar matricula", e.getMessage());
		}
	}
	
	public List<Alumno> getAlumnosTotal() {
		return alumnosTotal;
	}

	public void setAlumnosTotal(List<Alumno> alumnosTotal) {
		this.alumnosTotal = alumnosTotal;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public List<Alumno> getAlumnosSeleccionadosMatricula() {
		return alumnosSeleccionadosMatricula;
	}

	public void setAlumnosSeleccionadosMatricula(
			List<Alumno> alumnosSeleccionadosMatricula) {
		this.alumnosSeleccionadosMatricula = alumnosSeleccionadosMatricula;
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

	public Tipo getTeoria() {
		return teoria;
	}

	public void setTeoria(Tipo teoria) {
		this.teoria = teoria;
	}

	public Tipo getPractica() {
		return practica;
	}

	public void setPractica(Tipo practica) {
		this.practica = practica;
	}

	public Tipo getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Tipo laboratorio) {
		this.laboratorio = laboratorio;
	}

	public List<Alumno> getAlumnosMatriculados() {
		return alumnosMatriculados;
	}

	public void setAlumnosMatriculados(List<Alumno> alumnosMatriculados) {
		this.alumnosMatriculados = alumnosMatriculados;
	}

	public List<Alumno> getAlumnosA() {
		return alumnosA;
	}

	public void setAlumnosA(List<Alumno> alumnosA) {
		this.alumnosA = alumnosA;
	}

	public List<Alumno> getAlumnosB() {
		return alumnosB;
	}

	public void setAlumnosB(List<Alumno> alumnosB) {
		this.alumnosB = alumnosB;
	}
}

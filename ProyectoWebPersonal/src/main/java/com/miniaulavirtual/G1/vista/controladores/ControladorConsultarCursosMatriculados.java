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


@ManagedBean(name = "cursosDeAlumno")
@ViewScoped
public class ControladorConsultarCursosMatriculados implements Serializable{
	@EJB
	private AlumnoDao alumnoDao;
	@EJB
	private GrupoDao grupoDao;
	
	private List<Grupo> grupos;

	
	@PostConstruct
	public void inicializar() {
		Alumno alumno = new Alumno();
		alumno.setIdAlumno(1);
		
		grupos = grupoDao.listarPorAlumno(alumno);
	}
	
	public String aceptar() {
		return "registrarMatricula";
	}
	

	public List<Grupo> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
}

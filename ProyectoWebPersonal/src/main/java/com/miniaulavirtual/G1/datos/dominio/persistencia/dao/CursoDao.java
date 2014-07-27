package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.miniaulavirtual.G1.datos.dominio.entidades.Alumno;
import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;
import com.miniaulavirtual.G1.datos.dominio.entidades.Docente;

@Stateless
public class CursoDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;
	
	public List<Curso> listarPorDocente(Docente docente) {
		
		Query query = em.createNamedQuery("Curso.listarPorDocente");
		query.setParameter("codigoDocente", docente.getCodigo());
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Curso> cursos = query.getResultList();

		return cursos;
	}
	
	public List<Curso> listar() {
		Query query = em.createNamedQuery("Curso.listar");
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Curso> cursos = query.getResultList();

		return cursos;
	}

	public Curso buscarPorNombre(String nombreCurso) {
		Query query = em.createNamedQuery("Curso.buscarPorNombre");
		query.setParameter("nombreCurso", nombreCurso);
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Curso curso = (Curso)query.getSingleResult();

		return curso;
	}

	public List<Curso> listarPorAlumno(Alumno alumno) {
		Query query = em.createNamedQuery("Curso.listarPorAlumno");
		query.setParameter("idAlumno", alumno.getIdAlumno());
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Curso> cursos = query.getResultList();

		return cursos;
	}

}

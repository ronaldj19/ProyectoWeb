package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.miniaulavirtual.G1.datos.dominio.entidades.Alumno;
import com.miniaulavirtual.G1.datos.dominio.entidades.Grupo;

@Stateless
public class AlumnoDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;
	
	public List<Alumno> listar() {
		Query query = em.createNamedQuery("Alumno.listar");
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Alumno> alumnos = query.getResultList();
		
		return alumnos;
	}
	
	public List<Alumno> listaPorGrupo(Grupo grupo) {
		Query query = em.createNamedQuery("Alumno.listarPorGrupo");
		query.setParameter("idGrupo", grupo.getIdGrupo());
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Alumno> alumnos = query.getResultList();

		return alumnos;
	}
	
	public void guardarOrActualizar(Alumno alumno) {
		em.merge(alumno);
	}
}

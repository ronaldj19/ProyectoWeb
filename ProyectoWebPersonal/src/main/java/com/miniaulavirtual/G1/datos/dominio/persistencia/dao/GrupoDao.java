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
public class GrupoDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;
	
	public Grupo buscar(String idGrupo) {
		Query query = em.createNamedQuery("Grupo.buscar");
		query.setParameter("idGrupo", Integer.parseInt(idGrupo));
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Grupo grupo = (Grupo)query.getSingleResult();

		return grupo;
	}


	public void guardarOrActualizar(Grupo grupoSeleccionado) {
		em.merge(grupoSeleccionado);
	}


	public List<Grupo> listarPorAlumno(Alumno alumno) {
		Query query = em.createNamedQuery("Grupo.listarPorAlumno");
		query.setParameter("idAlumno", alumno.getIdAlumno());
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Grupo> grupos = query.getResultList();

		return grupos;
	}

}

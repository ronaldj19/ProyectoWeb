package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.miniaulavirtual.G1.datos.dominio.entidades.Clase;
import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;

@Stateless
public class ClaseDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;
	
	public void guardarOrActualizar(Clase clase) {
		
		em.merge(clase);
	}

	public Clase buscar(String idClase) {
		Query query = em.createNamedQuery("Clase.buscar");
		query.setParameter("idClase", Integer.parseInt(idClase));
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Clase tipo = (Clase)query.getSingleResult();

		return tipo;
	}
	
}

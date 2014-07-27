package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;

@Stateless
public class TipoDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;

	public Tipo buscar(String idTipo) {
		Query query = em.createNamedQuery("Tipo.buscar");
		query.setParameter("idTipo", Integer.parseInt(idTipo));
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Tipo tipo = (Tipo)query.getSingleResult();

		return tipo;
	}

}

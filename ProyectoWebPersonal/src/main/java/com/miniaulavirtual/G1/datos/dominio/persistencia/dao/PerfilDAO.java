package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PerfilDAO {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;

}

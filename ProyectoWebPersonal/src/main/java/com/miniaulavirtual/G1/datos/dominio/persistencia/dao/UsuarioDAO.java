package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.miniaulavirtual.G1.datos.dominio.entidades.Usuario;



@Stateless
public class UsuarioDAO {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;

	public Usuario validar(String username, String password) {
		Query query = em.createNamedQuery("Usuario.Validar");
		query.setParameter("username", username);
		query.setParameter("password", password);

		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			return usuario;
		}
		catch (NoResultException nre) {
			return null;
		}
	}

	public void actualizar(Usuario usuario) {
		em.merge(usuario);
	}

}

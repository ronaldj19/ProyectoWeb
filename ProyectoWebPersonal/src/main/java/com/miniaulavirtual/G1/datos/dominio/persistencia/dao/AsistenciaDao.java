package com.miniaulavirtual.G1.datos.dominio.persistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.miniaulavirtual.G1.datos.dominio.entidades.Asistencia;
import com.miniaulavirtual.G1.datos.dominio.entidades.Clase;
import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;

@Stateless
public class AsistenciaDao {

	@PersistenceContext(unitName = "Mini_Aula_Virtual-G1")
	private EntityManager em;
	
	public List<Asistencia> listarPorClase(Clase clase) {
		Query query = em.createNamedQuery("Asistencia.listarPorClase");
		query.setParameter("idClase", clase.getIdClase());
		
		List<Asistencia> asistencias = query.getResultList();
		
		return asistencias;
	}
	
	public void guardarOrActualizar(Asistencia asistencia) {
		em.merge(asistencia);
	}
}

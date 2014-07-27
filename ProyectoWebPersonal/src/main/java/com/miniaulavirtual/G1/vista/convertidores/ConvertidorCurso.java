package com.miniaulavirtual.G1.vista.convertidores;


import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.miniaulavirtual.G1.datos.dominio.entidades.Curso;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.CursoDao;


@FacesConverter("convertidor.curso")
public class ConvertidorCurso implements Converter {

	@EJB
	private CursoDao cursoDao;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String nombreCurso) {
		return cursoDao.buscarPorNombre(nombreCurso);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		Curso curso = (Curso) objeto;

		return curso.getNombre();
	}
}

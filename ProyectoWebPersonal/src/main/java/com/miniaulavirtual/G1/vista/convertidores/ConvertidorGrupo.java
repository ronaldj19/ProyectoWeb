package com.miniaulavirtual.G1.vista.convertidores;


import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.miniaulavirtual.G1.datos.dominio.entidades.Grupo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.GrupoDao;


@FacesConverter("convertidor.grupo")
public class ConvertidorGrupo implements Converter {

	@EJB
	private GrupoDao grupoDao;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idGrupo) {
		return grupoDao.buscar(idGrupo);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		Grupo grupo = (Grupo) objeto;

		return grupo.getIdGrupo() + "";
	}
}

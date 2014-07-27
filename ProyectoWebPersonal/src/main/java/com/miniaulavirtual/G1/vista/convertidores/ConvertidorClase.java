package com.miniaulavirtual.G1.vista.convertidores;


import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.miniaulavirtual.G1.datos.dominio.entidades.Clase;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.ClaseDao;


@FacesConverter("convertidor.clase")
public class ConvertidorClase implements Converter {

	@EJB
	private ClaseDao claseDao;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idClase) {
		return claseDao.buscar(idClase);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		Clase clase = (Clase) objeto;

		return clase.getIdClase() + "";
	}
}

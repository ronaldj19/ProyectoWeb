package com.miniaulavirtual.G1.vista.convertidores;


import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.miniaulavirtual.G1.datos.dominio.entidades.Tipo;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.TipoDao;


@FacesConverter("convertidor.tipo")
public class ConvertidorTipo implements Converter {

	@EJB
	private TipoDao tipoDao;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idTipo) {
		return tipoDao.buscar(idTipo);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		Tipo tipo= (Tipo) objeto;

		return tipo.getIdTipo() + "";
	}
}

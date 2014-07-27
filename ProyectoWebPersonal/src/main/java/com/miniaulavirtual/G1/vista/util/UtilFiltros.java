package com.miniaulavirtual.G1.vista.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;



@Stateless
public class UtilFiltros {

//	public List<Dependencia> filtrarAreas(List<Dependencia> areas, String filtro) {
//		filtro = filtro.trim().toLowerCase();
//
//		List<Dependencia> filtradas = new ArrayList<>();
//
//		for (Dependencia dependencia : areas) {
//			if (dependencia.getNombre().toLowerCase().startsWith(filtro) || dependencia.getCodigo().startsWith(filtro))
//				filtradas.add(dependencia);
//
//		}
//
//		return filtradas;
//	}
//
//	public List<Trabajador> filtrarTrabajadores(List<Trabajador> trabajadores, String filtro) {
//		filtro = filtro.trim().toLowerCase();
//
//		List<Trabajador> filtradas = new ArrayList<>();
//
//		for (Trabajador trabajador : trabajadores) {
//			if (trabajador.getNroDoc().toLowerCase().startsWith(filtro))
//				filtradas.add(trabajador);
//		}
//
//		return filtradas;
//	}
//
//	public List<TipoBien> filtrarTiposBienes(List<TipoBien> tiposBienes, String filtro) {
//		filtro = filtro.trim().toLowerCase();
//
//		List<TipoBien> filtradas = new ArrayList<>();
//
//		for (TipoBien tipoBien : tiposBienes) {
//			if (tipoBien.getDescripcion().toLowerCase().startsWith(filtro))
//				filtradas.add(tipoBien);
//		}
//
//		return filtradas;
//	}
}

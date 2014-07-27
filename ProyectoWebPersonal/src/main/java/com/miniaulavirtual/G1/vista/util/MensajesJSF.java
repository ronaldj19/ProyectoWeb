package com.miniaulavirtual.G1.vista.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class MensajesJSF {

	public static void mostrarMensajeNotify(String resumen, String detalle) {
		FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	public static void mostrarMensajeDialogo(String resumen, String detalle) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}

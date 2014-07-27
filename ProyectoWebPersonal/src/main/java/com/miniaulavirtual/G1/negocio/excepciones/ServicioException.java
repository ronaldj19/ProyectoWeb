package com.miniaulavirtual.G1.negocio.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServicioException extends RuntimeException {

	public ServicioException() {

	}

	public ServicioException(String mensaje) {
		super(mensaje);
	}
}

package com.miniaulavirtual.G1.negocio.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = false)
public class PersistenciaException extends RuntimeException {

	public PersistenciaException() {

	}

	public PersistenciaException(String mensaje) {
		super(mensaje);
	}
}

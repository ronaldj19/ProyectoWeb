package com.miniaulavirtual.G1.datos.dominio.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilManager {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MYSQL_Base");
	private static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("SQLite_base");

	private UtilManager() {

	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static EntityManager getEntityManagerSQLite() {
		return emf2.createEntityManager();
	}

	public static void resetearBaseSqlite() {
		emf2 = Persistence.createEntityManagerFactory("SQLite_base");
	}
}

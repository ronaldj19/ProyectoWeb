package com.miniaulavirtual.G1.datos.dominio.persistencia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilBaseDatos {

	public static Connection conexion;

	public static Connection getConexion() {
		if (conexion == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				System.exit(1);
			}

			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "123456");
				conexion.setAutoCommit(false);
			}
			catch (SQLException e) {
				System.exit(4);
			}
		}

		return conexion;
	}
}

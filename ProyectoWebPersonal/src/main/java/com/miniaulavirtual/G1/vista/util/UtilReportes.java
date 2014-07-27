package com.miniaulavirtual.G1.vista.util;


import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class UtilReportes {

	private static final String RUTA_BASE = FacesContext.getCurrentInstance().getExternalContext().getRealPath(".");

//	public static void generarFichaTecnicaEquiposDonacion(Dependencia dependencia, Informe informeDonacion) {
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_FICHATECNICA_EQUIPOSDONACIONs");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_FICHATECNICADONACION_EQUIPOS");
//		Map<String, Object> parametros = cargarParametrosDonacion(dependencia, informeDonacion);
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//	
//	public static void generarFichaTecnicaMueblesDonacion(Dependencia dependencia, Informe informeDonacion){
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_FICHATECNICA_MUEBLESDONACION");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_FICHATECNICAMUEBLESDONACION");	
//		Map<String, Object> parametros = cargarParametrosDonacion(dependencia, informeDonacion);
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//	
//	public static void generarFichaTecnicaEquipos(Dependencia dependencia, Expediente expediente) {
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_FICHA_TECNICA_EQUIPOS");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_FICHA_TECNICA_EQUIPOS");
//
//		Map<String, Object> parametros = cargarParametros(dependencia, expediente);
//
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//
//	
//	public static void generarFichaTecnicaMuebles(Dependencia dependencia, Expediente expediente) {
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_FICHA_TECNICA_MUEBLES");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_FICHA_TECNICA_MUEBLES");
//
//		Map<String, Object> parametros = cargarParametros(dependencia, expediente);
//
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//
//	
//	public static void generarReporteBajaMuebles(Dependencia dependencia, Informe informe) {
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_INFORME_BAJAS_MUEBLES");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_INFORME_BAJAS_MUEBLES");
//
//		Map<String, Object> parametros = cargarParametrosBaja(dependencia, informe);
//
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//
//	public static void generarReporteBajaEquipos(Dependencia dependencia, Informe informe) {
//		String rutaArchivoJasper = obtenerRutaArchivo("UtilReportes.JASPER_INFORME_BAJAS_EQUIPOS");
//		String rutaArchivoPdf = obtenerRutaArchivo("UtilReportes.PDF_INFORME_BAJAS_EQUIPOS");
//	
//		Map<String, Object> parametros = cargarParametrosBaja(dependencia, informe);
//
//		generarArchivoPdf(rutaArchivoJasper, rutaArchivoPdf, parametros);
//	}
//
//	
//	private static void generarArchivoPdf(String rutaArchivoJasper, String rutaArchivoPdf,
//			Map<String, Object> parametros) {
//		try {
//			Connection conexion = UtilBaseDatos.getConexion();
//			JasperPrint print = JasperFillManager.fillReport(rutaArchivoJasper, parametros, conexion);
//			
//			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, rutaArchivoPdf);
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//			exporter.exportReport();
//
//		}
//		catch (JRException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static Map<String, Object> cargarParametros(Dependencia dependencia, Expediente expediente) {
//		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("facultad", dependencia.getNombre());
//		parametros.put("informe", expediente.getNumero());
//		return parametros;
//	}
//	
//	private static Map<String, Object> cargarParametrosBaja(Dependencia dependencia, Informe informe) {
//		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("facultad", dependencia.getNombre()); 
//		parametros.put("informe", informe.getNumero());
//		return parametros;
//	}
//
//	
//	
//	private static Map<String, Object> cargarParametrosDonacion(Dependencia dependencia, Informe informe) {
//		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("facultad", dependencia.getNombre()); 
//		parametros.put("informe", informe.getNumero());
//		return parametros;
//	}
//
//	private static String obtenerRutaArchivo(String archivo) {
//		return RUTA_BASE.substring(0, RUTA_BASE.length() - 1) + Messages.getString(archivo);
//	}
}

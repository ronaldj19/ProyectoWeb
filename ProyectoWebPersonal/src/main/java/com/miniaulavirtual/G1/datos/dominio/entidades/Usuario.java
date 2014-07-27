package com.miniaulavirtual.G1.datos.dominio.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	           @NamedQuery(name = "Usuario.Validar",query = "SELECT u FROM Usuario u where u.nombreUsuario=:username and u.contrasenia=:password"), })

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private int codigo;

	private String contrasenia;

	private int dni;

	private int edad;

	private String email;

	private String estado;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String nombres;

	private String perfil_Opciones_idPerfil_Opciones;

	private String sexo;

	private String tema;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPerfil_Opciones_idPerfil_Opciones() {
		return this.perfil_Opciones_idPerfil_Opciones;
	}

	public void setPerfil_Opciones_idPerfil_Opciones(String perfil_Opciones_idPerfil_Opciones) {
		this.perfil_Opciones_idPerfil_Opciones = perfil_Opciones_idPerfil_Opciones;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
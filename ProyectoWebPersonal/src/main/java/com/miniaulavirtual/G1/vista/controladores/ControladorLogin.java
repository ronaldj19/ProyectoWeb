package com.miniaulavirtual.G1.vista.controladores;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.miniaulavirtual.G1.datos.dominio.entidades.Usuario;
import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.UsuarioDAO;
import com.miniaulavirtual.G1.vista.util.MensajesJSF;

@ManagedBean(name = "loginBean")
@SessionScoped
public class ControladorLogin {

	private String username;
	private String password;
	private Usuario usuario;
	private boolean loggedIn = false;

	@EJB
	private UsuarioDAO usuarioDao;

	@PostConstruct
	public void inicializar() {
		usuario = new Usuario();
		usuario.setTema("home");
	}

	public String loginUsuario() {

		usuario = usuarioDao.validar(username, password);

		if (usuario != null) {
			loggedIn = true;
			return "registrarAsistencia.xhtml";
		}
		else {
			MensajesJSF.mostrarMensajeNotify("Error Login", "Usuario no encontrado");
			limpiarFormulario();

			return null;
		}
	}

	private void limpiarFormulario() {
		username = "";
		password = "";
	}

	public void checkLogin() {

		if (!loggedIn) {
			redirigirAlLogin();
		}
	}

	private void redirigirAlLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication()
				.getNavigationHandler();
		handler.performNavigation("login");
	}

	public String cerrarSesion() {
		loggedIn = false;
		return "login.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
